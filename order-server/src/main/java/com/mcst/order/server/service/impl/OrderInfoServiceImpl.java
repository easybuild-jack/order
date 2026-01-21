package com.mcst.order.server.service.impl;

import cn.hutool.core.util.IdUtil;
import com.mcst.easyfk.core.dto.login.UserData;
import com.mcst.easyfk.core.dto.page.PageResult;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.dto.request.SearchRequest;
import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.core.exception.BusinessException;
import com.mcst.easyfk.core.utils.common.TransformUtil;
import com.mcst.easyfk.repository.util.ConditionUtil;
import com.mcst.easyfk.service.util.ServiceUtil;
import com.mcst.easyfk.service.util.UserDataFiltrationUtil;
import com.mcst.order.api.dto.OrderAmountDto;
import com.mcst.order.api.dto.OrderDiscountDto;
import com.mcst.order.api.dto.OrderGoodsDto;
import com.mcst.order.api.dto.OrderInfoDto;
import com.mcst.order.api.dto.OrderPayDto;
import com.mcst.order.api.enums.OrderStatusEnum;
import com.mcst.order.api.request.CancelOrderReq;
import com.mcst.order.api.request.CreateOrderReq;
import com.mcst.order.api.request.OrderGoodsItem;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.api.response.CancelOrderResp;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.server.repository.IOrderAmountRepository;
import com.mcst.order.server.repository.IOrderDiscountRepository;
import com.mcst.order.server.repository.IOrderGoodsRepository;
import com.mcst.order.server.repository.IOrderInfoRepository;
import com.mcst.order.server.repository.IOrderPayRepository;
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
    public CreateOrderResp createOrder(CreateOrderReq req) {
        if (!StringUtils.hasText(req.getOrderNo())) {
            throw new BusinessException("订单编号不能为空");
        }

        if (CollectionUtils.isEmpty(req.getGoodsList())) {
            throw new BusinessException("商品列表不能为空");
        }

        String orderInfoId = IdUtil.fastSimpleUUID();

        OrderInfoDto orderInfoDto = buildOrderInfo(req, orderInfoId);
        orderInfoRepository.insertSelective(orderInfoDto);

        for (OrderGoodsItem item : req.getGoodsList()) {
            OrderGoodsDto orderGoodsDto = buildOrderGoods(req, orderInfoId, item);
            orderGoodsRepository.insertSelective(orderGoodsDto);
        }

        OrderAmountDto orderAmountDto = buildOrderAmount(req, orderInfoId);
        orderAmountRepository.insertSelective(orderAmountDto);

        if (!CollectionUtils.isEmpty(req.getUserCouponIds())) {
            OrderDiscountDto orderDiscountDto = buildOrderDiscount(req, orderInfoId);
            orderDiscountRepository.insertSelective(orderDiscountDto);
        }

        OrderPayDto orderPayDto = buildOrderPay(req, orderInfoId);
        orderPayRepository.insertSelective(orderPayDto);

        CreateOrderResp resp = new CreateOrderResp();
        resp.setOrderInfoId(orderInfoId);
        resp.setOrderNo(req.getOrderNo());
        resp.setOrderStatus(OrderStatusEnum.PENDING_PAYMENT.getCode());
        resp.setPayType(req.getPayType());
        resp.setPayStatus(req.getPayStatus() != null ? req.getPayStatus() : 0);
        resp.setTotalAmount(req.getTotalAmount());
        resp.setGoodsCount(req.getGoodsCount());

        return resp;
    }

    @Override
    public BaseResult<CancelOrderResp> cancelOrder(CancelOrderReq req) {
        if (!StringUtils.hasText(req.getOrderNo())) {
            throw new BusinessException("订单编号不能为空");
        }

        OrderInfoDto orderInfoDto = orderInfoRepository.queryOneByField("orderNo", req.getOrderNo());
        if (orderInfoDto == null) {
            throw new BusinessException("订单不存在: " + req.getOrderNo());
        }

        Integer oldStatus = orderInfoDto.getOrderStatus();
        if (oldStatus == null) {
            oldStatus = 0;
        }

        if (!OrderStatusEnum.PENDING_PAYMENT.getCode().equals(oldStatus)) {
            if (OrderStatusEnum.CANCELED.getCode().equals(oldStatus)) {
                CancelOrderResp resp = new CancelOrderResp();
                resp.setOrderInfoId(orderInfoDto.getOrderInfoId());
                resp.setOrderNo(req.getOrderNo());
                resp.setOldOrderStatus(oldStatus);
                resp.setNewOrderStatus(oldStatus);
                resp.setCancelTime(orderInfoDto.getCancelTime());
                return BaseResult.success(resp);
            }
            throw new BusinessException("当前订单状态不允许取消");
        }

        orderInfoDto.setOrderStatus(OrderStatusEnum.CANCELED.getCode());
        orderInfoDto.setCancelReasonType(req.getCancelReasonType());
        orderInfoDto.setCancelRemark(req.getCancelRemark());
        orderInfoDto.setCancelTime(LocalDateTime.now());
        orderInfoRepository.updateSelective(orderInfoDto);

        CancelOrderResp resp = new CancelOrderResp();
        resp.setOrderInfoId(orderInfoDto.getOrderInfoId());
        resp.setOrderNo(req.getOrderNo());
        resp.setOldOrderStatus(oldStatus);
        resp.setNewOrderStatus(OrderStatusEnum.CANCELED.getCode());
        resp.setCancelTime(orderInfoDto.getCancelTime());

        return BaseResult.success(resp);
    }

    private OrderInfoDto buildOrderInfo(CreateOrderReq req, String orderInfoId) {
        OrderInfoDto dto = new OrderInfoDto();
        dto.setOrderInfoId(orderInfoId);
        dto.setOrderNo(req.getOrderNo());
        dto.setUserId(req.getUserId());
        dto.setUserThirdAccount(req.getUserThirdAccount());
        dto.setUserPhone(req.getUserPhone());
        dto.setOrderType(req.getOrderType());
        dto.setDispatchType(req.getDispatchType());
        dto.setOrderSource(req.getOrderSource());
        dto.setClientType(req.getClientType());
        dto.setMerchantId(req.getMerchantId());
        dto.setMerchantName(req.getMerchantName());
        dto.setAgentId(req.getAgentId());
        dto.setAgentName(req.getAgentName());
        dto.setUserRemark(req.getUserRemark());
        dto.setInvoiceFlag(req.getInvoiceFlag());
        dto.setOrderStatus(OrderStatusEnum.PENDING_PAYMENT.getCode());
        dto.setTotalAmount(req.getTotalAmount());
        dto.setActualPayAmount(req.getActualPayAmount());
        dto.setGoodsCount(req.getGoodsCount());
        dto.setOrderDate(LocalDate.now());
        dto.setOrderTime(LocalDateTime.now());
        return dto;
    }

    private OrderGoodsDto buildOrderGoods(CreateOrderReq req, String orderInfoId, OrderGoodsItem item) {
        OrderGoodsDto dto = new OrderGoodsDto();
        dto.setOrderGoodsId(IdUtil.fastSimpleUUID());
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
        dto.setGoodsType(item.getGoodsType());
        dto.setGiftFlag(item.getGiftFlag());
        return dto;
    }

    private OrderAmountDto buildOrderAmount(CreateOrderReq req, String orderInfoId) {
        OrderAmountDto dto = new OrderAmountDto();
        dto.setOrderAmountId(IdUtil.fastSimpleUUID());
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
        dto.setOrderDiscountId(IdUtil.fastSimpleUUID());
        dto.setOrderInfoId(orderInfoId);
        dto.setOrderNo(req.getOrderNo());
        dto.setGoodsAmount(req.getGoodsAmount());
        dto.setDiscountAmount(req.getDiscountAmount() != null ? req.getDiscountAmount() : java.math.BigDecimal.ZERO);
        dto.setDiscountAfterAmount(req.getDiscountAfterAmount() != null ? req.getDiscountAfterAmount() : req.getTotalAmount());
        dto.setUserCouponIds(String.join(",", req.getUserCouponIds()));
        dto.setDiscountRemark(req.getDiscountRemark());
        return dto;
    }

    private OrderPayDto buildOrderPay(CreateOrderReq req, String orderInfoId) {
        OrderPayDto dto = new OrderPayDto();
        dto.setOrderPayId(IdUtil.fastSimpleUUID());
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

}
