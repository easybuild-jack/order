package com.mcst.order.server.service.impl;

import cn.hutool.core.util.IdUtil;
import com.mcst.common.enums.order.OrderStatusEnum;
import com.mcst.common.enums.pay.PayStatusEnum;
import com.mcst.easyfk.core.builders.BRBuilder;
import com.mcst.easyfk.core.dto.login.UserData;
import com.mcst.easyfk.core.dto.page.PageResult;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.dto.request.SearchRequest;
import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.core.exception.BusinessException;
import com.mcst.easyfk.core.utils.common.EmptyUtil;
import com.mcst.easyfk.core.utils.common.TransformUtil;
import com.mcst.easyfk.repository.search.SCBuilder;
import com.mcst.easyfk.repository.search.SearchCondition;
import com.mcst.easyfk.repository.util.ConditionUtil;
import com.mcst.easyfk.service.util.ServiceUtil;
import com.mcst.easyfk.service.util.UserDataFiltrationUtil;
import com.mcst.order.api.dto.*;
import com.mcst.order.api.request.*;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.server.repository.*;
import com.mcst.order.server.service.IOrderInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Service
public class OrderInfoServiceImpl implements IOrderInfoService {

    @Resource
    private IOrderInfoRepository orderInfoRepository;

    @Resource
    private IOrderGoodsRepository orderGoodsRepository;

    @Resource
    private IOrderAmountRepository orderAmountRepository;

    @Resource
    private IOrderPayRepository orderPayRepository;

    @Resource
    private IOrderDiscountRepository orderDiscountRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult<CreateOrderResp> createOrder(CreateOrderReq req) {
        if (!StringUtils.hasText(req.getOrderNo())) {
            throw new BusinessException("订单编号不能为空");
        }

        if (CollectionUtils.isEmpty(req.getGoodsList())) {
            throw new BusinessException("商品列表不能为空");
        }

        String orderInfoId = IdUtil.fastSimpleUUID();
        OrderInfoDto orderInfoDto = buildOrderInfo(req, orderInfoId);
        orderInfoRepository.insert(orderInfoDto);

        for (OrderGoodsItem item : req.getGoodsList()) {
            OrderGoodsDto orderGoodsDto = buildOrderGoods(req, orderInfoId, item);
            orderGoodsRepository.insert(orderGoodsDto);
        }

        OrderAmountDto orderAmountDto = buildOrderAmount(req, orderInfoId);
        orderAmountRepository.insert(orderAmountDto);

        if (!CollectionUtils.isEmpty(req.getUserCouponIds())) {
            OrderDiscountDto orderDiscountDto = buildOrderDiscount(req, orderInfoId);
            orderDiscountRepository.insert(orderDiscountDto);
        }

        OrderPayDto orderPayDto = buildOrderPay(req, orderInfoId);
        orderPayRepository.insert(orderPayDto);

        CreateOrderResp resp = new CreateOrderResp();
        resp.setOrderInfoId(orderInfoId);
        resp.setOrderNo(req.getOrderNo());
        resp.setOrderStatus(orderInfoDto.getOrderStatus());
        resp.setPayType(req.getPayType());
        resp.setPayStatus(req.getPayStatus() != null ? req.getPayStatus() : 0);
        resp.setTotalAmount(req.getTotalAmount());
        resp.setGoodsCount(req.getGoodsCount());
        return BRBuilder.successResult(resp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult<?> cancelOrder(CancelOrderReq req) {
        if (!StringUtils.hasText(req.getOrderNo())) {
            throw new BusinessException("订单编号不能为空");
        }
        OrderInfoDto orderInfoDto = orderInfoRepository.queryOneByField("orderNo", req.getOrderNo());
        if (orderInfoDto == null) {
            throw new BusinessException("订单不存在: " + req.getOrderNo());
        }
        if (EmptyUtil.isNotEmpty(req.getUserId())) {
            if (!orderInfoDto.getUserId().equals(req.getUserId())) {
                throw new BusinessException("数据错误，订单不属于当前用户");
            }
        }
        int oldStatus = Optional.ofNullable(orderInfoDto.getOrderStatus()).orElse(OrderStatusEnum.PENDING_PAYMENT.getValue());
        if (OrderStatusEnum.CANCELED.getValue() == oldStatus) {
            return BRBuilder.successResult();
        }
        if (OrderStatusEnum.PENDING_PAYMENT.getValue() != oldStatus) {
            return BRBuilder.failResult().setMsg("当前订单状态不允许取消");
        }
        orderInfoDto.setOrderStatus(OrderStatusEnum.CANCELED.getValue());
        orderInfoDto.setCancelRemark(req.getCancelRemark());
        orderInfoDto.setCancelTime(LocalDateTime.now());
        orderInfoRepository.updateBySelective(orderInfoDto);
        OrderPayDto orderPayDto = orderPayRepository.queryOneByField("orderNo", req.getOrderNo());
        if (orderPayDto != null) {
            orderPayDto.setPayStatus(PayStatusEnum.CANCELLED.getValue());
            orderPayRepository.updateBySelective(orderPayDto);
        }
        return BRBuilder.successResult();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult<?> payCallback(PayCallbackReq req) {
        if (!StringUtils.hasText(req.getOrderNo())) {
            throw new BusinessException("订单编号不能为空");
        }
        if (!StringUtils.hasText(req.getThirdTradeNo())) {
            throw new BusinessException("第三方交易编号不能为空");
        }
        OrderInfoDto orderInfoDto = orderInfoRepository.queryOneByField("orderNo", req.getOrderNo());
        if (orderInfoDto == null) {
            throw new BusinessException("订单不存在: " + req.getOrderNo());
        }
        OrderPayDto orderPayDto = orderPayRepository.queryOneByField("orderNo", req.getOrderNo());
        int oldPayStatus = orderPayDto != null ? orderPayDto.getPayStatus() : 0;
        Integer oldOrderStatus = orderInfoDto.getOrderStatus();
        // 幂等性处理：订单已支付，直接返回成功
        if (orderPayDto != null && PayStatusEnum.PAID.getValue() == oldPayStatus) {
            return BRBuilder.successResult();
        }
        // 校验订单状态：只有待支付状态才能进行支付回调
        if (OrderStatusEnum.PENDING_PAYMENT.getValue() != oldOrderStatus) {
            return BRBuilder.failResult().setMsg("当前订单状态不允许支付回调");
        }
        LocalDateTime payTime = req.getPayTime() != null ? req.getPayTime() : LocalDateTime.now();
        LocalDate payDate = payTime.toLocalDate();
        // 更新订单信息状态
        orderInfoDto.setOrderStatus(OrderStatusEnum.WAITING_DELIVER.getValue());
        orderInfoRepository.updateBySelective(orderInfoDto);
        // 更新订单支付信息
        if (orderPayDto != null) {
            orderPayDto.setPayStatus(PayStatusEnum.PAID.getValue());
            orderPayDto.setThirdTradeNo(req.getThirdTradeNo());
            orderPayDto.setPayTime(payTime);
            orderPayDto.setPayDate(payDate);
            if (StringUtils.hasText(req.getPayType())) {
                orderPayDto.setPayType(req.getPayType());
            }
            if (req.getActualPayAmount() != null) {
                orderPayDto.setActualPayAmount(req.getActualPayAmount());
            }
            orderPayRepository.updateBySelective(orderPayDto);
        }
        return BRBuilder.successResult();
    }

    @Override
    public OrderInfoResp queryById(String id, String... selectColumns) {
        return TransformUtil.transformObj(this.orderInfoRepository.queryById(id, selectColumns), OrderInfoResp.class);
    }

    @Override
    public OrderInfoResp queryOneByField(String field, Object value, String... selectColumns) {
        return TransformUtil.transformObj(this.orderInfoRepository.queryOneByField(field, value, selectColumns), OrderInfoResp.class);
    }

    @Override
    public List<OrderInfoResp> queryList(SearchRequest<OrderInfoReq> param) {
        UserDataFiltrationUtil.saasDataFiltration(param, OrderInfoReq.class, Map.of(OrderInfoReq::getAgentId, UserData::getAgentId, OrderInfoReq::getMerchantId, UserData::getMerchantId));
        return TransformUtil.transformList(this.orderInfoRepository.queryByCondition(ConditionUtil.conditionByRequest(param)), OrderInfoResp.class);
    }

    @Override
    public OrderInfoResp queryOne(SearchRequest<OrderInfoReq> param) {
        UserDataFiltrationUtil.saasDataFiltration(param, OrderInfoReq.class, Map.of(OrderInfoReq::getAgentId, UserData::getAgentId, OrderInfoReq::getMerchantId, UserData::getMerchantId));
        return TransformUtil.transformObj(this.orderInfoRepository.queryOneByCondition(ConditionUtil.conditionByRequest(param)), OrderInfoResp.class);
    }

    @Override
    public long count(SearchRequest<OrderInfoReq> param) {
        UserDataFiltrationUtil.saasDataFiltration(param, OrderInfoReq.class, Map.of(OrderInfoReq::getAgentId, UserData::getAgentId, OrderInfoReq::getMerchantId, UserData::getMerchantId));
        return this.orderInfoRepository.countByCondition(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public boolean exists(SearchRequest<OrderInfoReq> param) {
        UserDataFiltrationUtil.saasDataFiltration(param, OrderInfoReq.class, Map.of(OrderInfoReq::getAgentId, UserData::getAgentId, OrderInfoReq::getMerchantId, UserData::getMerchantId));
        return this.orderInfoRepository.exists(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public PageResult<OrderInfoResp> queryByPage(SearchRequest<OrderInfoReq> param) {
        UserDataFiltrationUtil.saasDataFiltration(param, OrderInfoReq.class, Map.of(OrderInfoReq::getAgentId, UserData::getAgentId, OrderInfoReq::getMerchantId, UserData::getMerchantId));
        return TransformUtil.transformPageResult(this.orderInfoRepository.queryByPage(ConditionUtil.conditionByRequest(param)), OrderInfoResp.class);
    }

    @Override
    public BaseResult<?> save(ModifyRequest<OrderInfoReq> param) {
        UserDataFiltrationUtil.setSaasData(param, Map.of(OrderInfoReq::getAgentId, UserData::getAgentId, OrderInfoReq::getAgentName, UserData::getAgentName, OrderInfoReq::getMerchantId, UserData::getMerchantId, OrderInfoReq::getMerchantName, UserData::getMerchantName));
        return ServiceUtil.save(param, orderInfoRepository, OrderInfoDto.class);
    }

    @Override
    public BaseResult<?> delete(ModifyRequest<OrderInfoReq> param) {
        return ServiceUtil.delete(param, orderInfoRepository, OrderInfoDto.class);
    }

    @Override
    public String insertAndReturnId(OrderInfoReq param) {
        return ServiceUtil.insertAndReturnId(param, orderInfoRepository, OrderInfoDto.class);
    }

    @Override
    public BaseResult<?> rollbackOrder(String orderNo) {
        SearchCondition condition = SCBuilder.<OrderInfoDto>builder().equalsConditions(OrderInfoDto::getOrderNo, orderNo).build();
        return this.orderInfoRepository.deleteByCondition(condition);
    }

    private OrderInfoDto buildOrderInfo(CreateOrderReq req, String orderInfoId) {
        OrderInfoDto dto = new OrderInfoDto();
        dto.setOrderInfoId(orderInfoId);
        dto.setOrderNo(req.getOrderNo());
        dto.setUserId(req.getUserId());
        dto.setUserThirdAccount(req.getUserThirdAccount());
        dto.setUserPhone(req.getUserPhone());
        dto.setDispatchType(Optional.ofNullable(req.getDispatchType()).orElse(1));
        dto.setOrderSource(Optional.ofNullable(req.getOrderSource()).orElse(0));
        dto.setClientType(req.getClientType());
        dto.setMerchantId(req.getMerchantId());
        dto.setMerchantName(req.getMerchantName());
        dto.setAgentId(req.getAgentId());
        dto.setAgentName(req.getAgentName());
        dto.setUserRemark(req.getUserRemark());
        dto.setInvoiceFlag(Optional.ofNullable(req.getInvoiceFlag()).orElse(0));
        int payStatus = Optional.ofNullable(req.getPayStatus()).orElse(0);
        int orderStatus = OrderStatusEnum.PENDING_PAYMENT.getValue();
        if (PayStatusEnum.PAID.getValue() == payStatus) {
            orderStatus = OrderStatusEnum.WAITING_DELIVER.getValue();
        }
        dto.setOrderStatus(orderStatus);
        dto.setTotalAmount(req.getTotalAmount());
        dto.setActualPayAmount(req.getActualPayAmount());
        dto.setGoodsCount(req.getGoodsCount());
        dto.setOrderDate(LocalDate.now());
        dto.setOrderTime(LocalDateTime.now());
        return dto;
    }

    private OrderGoodsDto buildOrderGoods(CreateOrderReq req, String orderInfoId, OrderGoodsItem item) {
        OrderGoodsDto dto = new OrderGoodsDto();
        dto.setOrderInfoId(orderInfoId);
        dto.setOrderNo(req.getOrderNo());
        dto.setUserId(req.getUserId());
        dto.setUserThirdAccount(req.getUserThirdAccount());
        dto.setUserPhone(req.getUserPhone());
        dto.setGoodsId(item.getGoodsId());
        dto.setGoodsName(item.getGoodsName());
        dto.setGoodsNo(item.getGoodsNo());
        dto.setGoodsSkuId(item.getGoodsSkuId());
        dto.setGoodsSkuNo(item.getGoodsSkuNo());
        dto.setGoodsSkuName(item.getGoodsSkuName());
        dto.setGoodsPicUrl(item.getGoodsPic());
        dto.setGoodsCount(item.getGoodsCount());
        dto.setGoodsPrice(item.getGoodsPrice());
        dto.setGoodsType(Optional.ofNullable(item.getGoodsType()).orElse(0));
        dto.setGiftFlag(Optional.ofNullable(item.getGiftFlag()).orElse(0));
        return dto;
    }

    private OrderAmountDto buildOrderAmount(CreateOrderReq req, String orderInfoId) {
        OrderAmountDto dto = new OrderAmountDto();
        dto.setOrderInfoId(orderInfoId);
        dto.setOrderNo(req.getOrderNo());
        dto.setTotalAmount(req.getTotalAmount());
        dto.setGoodsAmount(req.getGoodsAmount());
        dto.setDiscountAmount(req.getDiscountAmount() != null ? req.getDiscountAmount() : java.math.BigDecimal.ZERO);
        dto.setDiscountAfterAmount(req.getDiscountAfterAmount() != null ? req.getDiscountAfterAmount() : req.getTotalAmount());
        dto.setPostageAmount(req.getPostageAmount() != null ? req.getPostageAmount() : java.math.BigDecimal.ZERO);
        dto.setActualPayAmount(req.getActualPayAmount());
        return dto;
    }

    private OrderDiscountDto buildOrderDiscount(CreateOrderReq req, String orderInfoId) {
        OrderDiscountDto dto = new OrderDiscountDto();
        dto.setOrderInfoId(orderInfoId);
        dto.setOrderNo(req.getOrderNo());
        dto.setGoodsAmount(req.getGoodsAmount());
        dto.setDiscountAmount(req.getDiscountAmount() != null ? req.getDiscountAmount() : java.math.BigDecimal.ZERO);
        dto.setDiscountAfterAmount(req.getDiscountAfterAmount() != null ? req.getDiscountAfterAmount() : req.getGoodsAmount());
        dto.setUserCouponIds(String.join(",", req.getUserCouponIds()));
        dto.setDiscountRemark(req.getDiscountRemark());
        return dto;
    }

    private OrderPayDto buildOrderPay(CreateOrderReq req, String orderInfoId) {
        OrderPayDto dto = new OrderPayDto();
        dto.setOrderInfoId(orderInfoId);
        dto.setOrderNo(req.getOrderNo());
        dto.setActualPayAmount(req.getActualPayAmount());
        dto.setPayStatus(req.getPayStatus() != null ? req.getPayStatus() : 0);
        dto.setPayType(req.getPayType());
        dto.setThirdTradeNo(req.getThirdTradeNo());
        dto.setPayDate(req.getPayDate());
        dto.setPayTime(req.getPayTime());
        return dto;
    }

}
