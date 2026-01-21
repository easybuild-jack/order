package com.mcst.order.server.service.impl;

import com.mcst.easyfk.core.builders.BRBuilder;
import com.mcst.easyfk.core.dto.page.PageResult;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.dto.request.SearchRequest;
import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.core.exception.BusinessException;
import com.mcst.easyfk.core.utils.common.OrderNoUtil;
import com.mcst.easyfk.core.utils.common.TransformUtil;
import com.mcst.easyfk.repository.util.ConditionUtil;
import com.mcst.easyfk.service.util.ServiceUtil;
import com.mcst.order.api.dto.OrderInfoDto;
import com.mcst.order.api.dto.OrderRefundDto;
import com.mcst.order.api.dto.OrderRefundGoodsDto;
import com.mcst.order.api.dto.OrderGoodsDto;
import com.mcst.order.api.enums.OrderStatusEnum;
import com.mcst.order.api.enums.RefundStatusEnum;
import com.mcst.order.api.request.*;
import com.mcst.order.api.response.*;
import com.mcst.order.server.repository.IOrderGoodsRepository;
import com.mcst.order.server.repository.IOrderInfoRepository;
import com.mcst.order.server.repository.IOrderRefundGoodsRepository;
import com.mcst.order.server.repository.IOrderRefundRepository;
import com.mcst.order.server.service.IOrderRefundService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 订单退款 服务实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Service
public class OrderRefundServiceImpl implements IOrderRefundService {

    @Resource
    private IOrderRefundRepository orderRefundRepository;

    @Resource
    private IOrderRefundGoodsRepository orderRefundGoodsRepository;

    @Resource
    private IOrderInfoRepository orderInfoRepository;

    @Resource
    private IOrderGoodsRepository orderGoodsRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult<ApplyRefundResp> applyRefund(ApplyRefundReq req) {
        if (!StringUtils.hasText(req.getOrderNo())) {
            throw new BusinessException("订单编号不能为空");
        }
        if (req.getRefundType() == null) {
            throw new BusinessException("退款类型不能为空");
        }

        // 查询订单
        OrderInfoDto orderInfo = orderInfoRepository.queryOneByField("orderNo", req.getOrderNo());
        if (orderInfo == null) {
            throw new BusinessException("订单不存在: " + req.getOrderNo());
        }

        // 校验订单状态：待发货、待收货、已收货可以申请退款
        Integer orderStatus = orderInfo.getOrderStatus();
        if (orderStatus == null || orderStatus < OrderStatusEnum.WAITING_DELIVER.getValue()
                || orderStatus > OrderStatusEnum.RECEIVED.getValue()) {
            return BRBuilder.<ApplyRefundResp>failResult().setMsg("当前订单状态不允许申请退款");
        }

        // 校验是否已存在未完成的退款申请
        OrderRefundDto existRefund = orderRefundRepository.queryOneByField("orderNo", req.getOrderNo());
        if (existRefund != null) {
            Integer refundStatus = existRefund.getRefundStatus();
            if (refundStatus != null && refundStatus != RefundStatusEnum.AUDIT_REJECTED.getCode()
                    && refundStatus != RefundStatusEnum.CLOSED.getCode()) {
                return BRBuilder.<ApplyRefundResp>failResult().setMsg("该订单已存在进行中的退款申请");
            }
        }

        // 生成退款单

        String orderRefundNo = "RF" + OrderNoUtil.get18OrderNumber();
        OrderRefundDto refundDto = new OrderRefundDto();
        refundDto.setOrderRefundNo(orderRefundNo);
        refundDto.setOrderInfoId(orderInfo.getOrderInfoId());
        refundDto.setOrderNo(req.getOrderNo());
        refundDto.setUserId(orderInfo.getUserId());
        refundDto.setUserPhone(orderInfo.getUserPhone());
        refundDto.setRefundType(req.getRefundType());
        refundDto.setRefundSource(0); // 用户申请
        refundDto.setRefundStatus(RefundStatusEnum.WAIT_AUDIT.getCode());
        refundDto.setRefundReasonType(req.getRefundReasonType());
        refundDto.setRefundReason(req.getRefundReason());
        refundDto.setApplyRemark(req.getApplyRemark());
        refundDto.setRefundEvidencePics(req.getRefundEvidencePics());
        refundDto.setRefundAmount(orderInfo.getActualPayAmount()); // 整单退款，金额自动计算
        refundDto.setContactName(req.getContactName());
        refundDto.setContactPhone(req.getContactPhone());
        String orderRefundId = orderRefundRepository.insertAndReturnId(refundDto);

        // 插入退款商品明细（整单退款，退所有商品）
        List<OrderGoodsDto> goodsList = orderGoodsRepository.queryByField("orderNo", req.getOrderNo());
        for (OrderGoodsDto goods : goodsList) {
            OrderRefundGoodsDto refundGoods = new OrderRefundGoodsDto();
            refundGoods.setOrderRefundId(orderRefundId);
            refundGoods.setOrderInfoId(orderInfo.getOrderInfoId());
            refundGoods.setOrderNo(req.getOrderNo());
            refundGoods.setOrderGoodsId(goods.getOrderGoodsId());
            refundGoods.setGoodsId(goods.getGoodsId());
            refundGoods.setGoodsSkuId(goods.getGoodsSkuId());
            refundGoods.setGoodsName(goods.getGoodsName());
            refundGoods.setGoodsSkuName(goods.getGoodsSkuName());
            refundGoods.setGoodsPic(goods.getGoodsPicUrl());
            refundGoods.setGoodsPrice(goods.getGoodsPrice());
            refundGoods.setReturnQuantity(goods.getGoodsCount());
            orderRefundGoodsRepository.insert(refundGoods);
        }

        // 更新订单售后状态
        orderInfo.setRefundFlag(1);
        orderInfoRepository.updateBySelective(orderInfo);

        ApplyRefundResp resp = new ApplyRefundResp();
        resp.setOrderRefundId(orderRefundId);
        resp.setOrderRefundNo(orderRefundNo);
        resp.setOrderNo(req.getOrderNo());
        resp.setRefundType(req.getRefundType());
        resp.setRefundStatus(RefundStatusEnum.WAIT_AUDIT.getCode());
        resp.setRefundAmount(orderInfo.getActualPayAmount());

        return BRBuilder.successResult(resp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult<AuditRefundResp> auditRefund(AuditRefundReq req) {
        if (!StringUtils.hasText(req.getOrderRefundNo())) {
            throw new BusinessException("退款单号不能为空");
        }
        if (req.getAuditResult() == null) {
            throw new BusinessException("审核结果不能为空");
        }

        // 查询退款单
        OrderRefundDto refundDto = orderRefundRepository.queryOneByField("orderRefundNo", req.getOrderRefundNo());
        if (refundDto == null) {
            throw new BusinessException("退款单不存在: " + req.getOrderRefundNo());
        }

        Integer oldStatus = refundDto.getRefundStatus();
        if (oldStatus == null || oldStatus != RefundStatusEnum.WAIT_AUDIT.getCode()) {
            return BRBuilder.<AuditRefundResp>failResult().setMsg("当前退款状态不允许审核");
        }

        LocalDateTime now = LocalDateTime.now();
        Integer newStatus;
        boolean needReturn = false;

        if (req.getAuditResult() == 1) {
            // 同意
            if (req.getNeedReturn() == null) {
                throw new BusinessException("请选择是否需要退货");
            }
            needReturn = req.getNeedReturn();
            if (needReturn) {
                // 需要退货
                newStatus = RefundStatusEnum.WAIT_RETURN.getCode();
            } else {
                // 不需要退货，直接退款
                newStatus = RefundStatusEnum.REFUNDING.getCode();
            }
        } else {
            // 拒绝
            newStatus = RefundStatusEnum.AUDIT_REJECTED.getCode();
        }

        refundDto.setRefundStatus(newStatus);
        refundDto.setAuditRemark(req.getAuditRemark());
        refundDto.setAuditTime(now);
        orderRefundRepository.updateBySelective(refundDto);

        AuditRefundResp resp = new AuditRefundResp();
        resp.setOrderRefundId(refundDto.getOrderRefundId());
        resp.setOrderRefundNo(req.getOrderRefundNo());
        resp.setOldRefundStatus(oldStatus);
        resp.setNewRefundStatus(newStatus);
        resp.setAuditResult(req.getAuditResult());
        resp.setNeedReturn(needReturn);
        resp.setAuditTime(now);
        return BRBuilder.successResult(resp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult<SubmitReturnExpressResp> submitReturnExpress(SubmitReturnExpressReq req) {
        if (!StringUtils.hasText(req.getOrderRefundNo())) {
            throw new BusinessException("退款单号不能为空");
        }
        if (!StringUtils.hasText(req.getReturnExpressCompany())) {
            throw new BusinessException("物流公司不能为空");
        }
        if (!StringUtils.hasText(req.getReturnExpressNo())) {
            throw new BusinessException("物流单号不能为空");
        }

        // 查询退款单
        OrderRefundDto refundDto = orderRefundRepository.queryOneByField("orderRefundNo", req.getOrderRefundNo());
        if (refundDto == null) {
            throw new BusinessException("退款单不存在: " + req.getOrderRefundNo());
        }

        Integer oldStatus = refundDto.getRefundStatus();
        if (oldStatus == null || oldStatus != RefundStatusEnum.WAIT_RETURN.getCode()) {
            return BRBuilder.<SubmitReturnExpressResp>failResult().setMsg("当前退款状态不允许填写物流信息");
        }

        Integer newStatus = RefundStatusEnum.WAIT_RECEIVE.getCode();
        refundDto.setRefundStatus(newStatus);
        refundDto.setReturnExpressCompany(req.getReturnExpressCompany());
        refundDto.setReturnExpressNo(req.getReturnExpressNo());
        orderRefundRepository.updateBySelective(refundDto);

        SubmitReturnExpressResp resp = new SubmitReturnExpressResp();
        resp.setOrderRefundId(refundDto.getOrderRefundId());
        resp.setOrderRefundNo(req.getOrderRefundNo());
        resp.setOldRefundStatus(oldStatus);
        resp.setNewRefundStatus(newStatus);
        resp.setReturnExpressCompany(req.getReturnExpressCompany());
        resp.setReturnExpressNo(req.getReturnExpressNo());
        return BRBuilder.successResult(resp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult<ConfirmReceiveResp> confirmReceiveAndRefund(ConfirmReceiveReq req) {
        if (!StringUtils.hasText(req.getOrderRefundNo())) {
            throw new BusinessException("退款单号不能为空");
        }

        // 查询退款单
        OrderRefundDto refundDto = orderRefundRepository.queryOneByField("orderRefundNo", req.getOrderRefundNo());
        if (refundDto == null) {
            throw new BusinessException("退款单不存在: " + req.getOrderRefundNo());
        }

        Integer oldStatus = refundDto.getRefundStatus();
        if (oldStatus == null || oldStatus != RefundStatusEnum.WAIT_RECEIVE.getCode()) {
            return BRBuilder.<ConfirmReceiveResp>failResult().setMsg("当前退款状态不允许确认收货");
        }

        LocalDateTime now = LocalDateTime.now();
        Integer newStatus = RefundStatusEnum.REFUNDING.getCode();

        refundDto.setRefundStatus(newStatus);
        refundDto.setReceiveConfirmTime(now);
        refundDto.setHandleRemark(req.getHandleRemark());
        refundDto.setHandleTime(now);
        orderRefundRepository.updateBySelective(refundDto);

        ConfirmReceiveResp resp = new ConfirmReceiveResp();
        resp.setOrderRefundId(refundDto.getOrderRefundId());
        resp.setOrderRefundNo(req.getOrderRefundNo());
        resp.setOldRefundStatus(oldStatus);
        resp.setNewRefundStatus(newStatus);
        resp.setRefundAmount(refundDto.getRefundAmount());
        resp.setReceiveConfirmTime(now);
        return BRBuilder.successResult(resp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult<CancelRefundResp> cancelRefund(CancelRefundReq req) {
        if (!StringUtils.hasText(req.getOrderRefundNo())) {
            throw new BusinessException("退款单号不能为空");
        }

        // 查询退款单
        OrderRefundDto refundDto = orderRefundRepository.queryOneByField("orderRefundNo", req.getOrderRefundNo());
        if (refundDto == null) {
            throw new BusinessException("退款单不存在: " + req.getOrderRefundNo());
        }

        Integer oldStatus = refundDto.getRefundStatus();
        // 只有待审核、待退货状态可以取消
        if (oldStatus == null || (oldStatus != RefundStatusEnum.WAIT_AUDIT.getCode()
                && oldStatus != RefundStatusEnum.WAIT_RETURN.getCode())) {
            return BRBuilder.<CancelRefundResp>failResult().setMsg("当前退款状态不允许取消");
        }

        LocalDateTime now = LocalDateTime.now();
        Integer newStatus = RefundStatusEnum.CLOSED.getCode();

        refundDto.setRefundStatus(newStatus);
        orderRefundRepository.updateBySelective(refundDto);

        // 更新订单售后状态
        OrderInfoDto orderInfo = orderInfoRepository.queryOneByField("orderNo", refundDto.getOrderNo());
        if (orderInfo != null) {
            orderInfo.setRefundFlag(0);
            orderInfoRepository.updateBySelective(orderInfo);
        }

        CancelRefundResp resp = new CancelRefundResp();
        resp.setOrderRefundId(refundDto.getOrderRefundId());
        resp.setOrderRefundNo(req.getOrderRefundNo());
        resp.setOldRefundStatus(oldStatus);
        resp.setNewRefundStatus(newStatus);
        resp.setCancelTime(now);
        return BRBuilder.successResult(resp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult<RefundCallbackResp> refundCallback(RefundCallbackReq req) {
        if (!StringUtils.hasText(req.getOrderRefundNo())) {
            throw new BusinessException("退款单号不能为空");
        }

        // 查询退款单
        OrderRefundDto refundDto = orderRefundRepository.queryOneByField("orderRefundNo", req.getOrderRefundNo());
        if (refundDto == null) {
            throw new BusinessException("退款单不存在: " + req.getOrderRefundNo());
        }

        Integer oldStatus = refundDto.getRefundStatus();

        // 幂等性处理：已退款状态，直接返回成功
        if (oldStatus != null && oldStatus == RefundStatusEnum.REFUNDED.getCode()) {
            RefundCallbackResp resp = new RefundCallbackResp();
            resp.setOrderRefundId(refundDto.getOrderRefundId());
            resp.setOrderRefundNo(req.getOrderRefundNo());
            resp.setOrderNo(refundDto.getOrderNo());
            resp.setOldRefundStatus(oldStatus);
            resp.setNewRefundStatus(oldStatus);
            resp.setRefundAmount(refundDto.getRefundAmount());
            resp.setRefundCompleteTime(refundDto.getRefundCompleteTime());
            resp.setRepeated(true);
            return BRBuilder.successResult(resp);
        }

        // 校验状态：只有退款中状态可以回调
        if (oldStatus == null || oldStatus != RefundStatusEnum.REFUNDING.getCode()) {
            return BRBuilder.<RefundCallbackResp>failResult().setMsg("当前退款状态不允许回调");
        }

        LocalDateTime refundCompleteTime = req.getRefundCompleteTime() != null
                ? req.getRefundCompleteTime() : LocalDateTime.now();
        Integer newStatus = RefundStatusEnum.REFUNDED.getCode();

        refundDto.setRefundStatus(newStatus);
        refundDto.setRefundTradeNo(req.getRefundTradeNo());
        refundDto.setRefundCompleteTime(refundCompleteTime);
        orderRefundRepository.updateBySelective(refundDto);

        // 更新订单状态为已退款
        OrderInfoDto orderInfo = orderInfoRepository.queryOneByField("orderNo", refundDto.getOrderNo());
        if (orderInfo != null) {
            orderInfo.setOrderStatus(OrderStatusEnum.REFUNDED.getValue());
            orderInfo.setRefundStatus(1); // 全部退款
            orderInfo.setRefundAmount(refundDto.getRefundAmount());
            orderInfoRepository.updateBySelective(orderInfo);
        }

        RefundCallbackResp resp = new RefundCallbackResp();
        resp.setOrderRefundId(refundDto.getOrderRefundId());
        resp.setOrderRefundNo(req.getOrderRefundNo());
        resp.setOrderNo(refundDto.getOrderNo());
        resp.setOldRefundStatus(oldStatus);
        resp.setNewRefundStatus(newStatus);
        resp.setRefundAmount(refundDto.getRefundAmount());
        resp.setRefundCompleteTime(refundCompleteTime);
        resp.setRepeated(false);
        return BRBuilder.successResult(resp);
    }

    @Override
    public OrderRefundResp queryById(String id, String... selectColumns) {
        return TransformUtil.transformObj(this.orderRefundRepository.queryById(id, selectColumns),
                OrderRefundResp.class);
    }

    @Override
    public OrderRefundResp queryOneByField(String field, Object value, String... selectColumns) {
        return TransformUtil.transformObj(this.orderRefundRepository.queryOneByField(field, value, selectColumns),
                OrderRefundResp.class);
    }

    @Override
    public List<OrderRefundResp> queryList(SearchRequest<OrderRefundReq> param) {
        return TransformUtil.transformList(
                this.orderRefundRepository.queryByCondition(ConditionUtil.conditionByRequest(param)),
                OrderRefundResp.class);
    }

    @Override
    public OrderRefundResp queryOne(SearchRequest<OrderRefundReq> param) {
        return TransformUtil.transformObj(
                this.orderRefundRepository.queryOneByCondition(ConditionUtil.conditionByRequest(param)),
                OrderRefundResp.class);
    }

    @Override
    public long count(SearchRequest<OrderRefundReq> param) {
        return this.orderRefundRepository.countByCondition(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public boolean exists(SearchRequest<OrderRefundReq> param) {
        return this.orderRefundRepository.exists(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public PageResult<OrderRefundResp> queryByPage(SearchRequest<OrderRefundReq> param) {
        return TransformUtil.transformPageResult(
                this.orderRefundRepository.queryByPage(ConditionUtil.conditionByRequest(param)), OrderRefundResp.class);
    }

    @Override
    public BaseResult<?> save(ModifyRequest<OrderRefundReq> param) {
        return ServiceUtil.save(param, orderRefundRepository, OrderRefundDto.class);
    }

    @Override
    public BaseResult<?> delete(ModifyRequest<OrderRefundReq> param) {
        return ServiceUtil.delete(param, orderRefundRepository, OrderRefundDto.class);
    }

    @Override
    public String insertAndReturnId(OrderRefundReq param) {
        return ServiceUtil.insertAndReturnId(param, orderRefundRepository, OrderRefundDto.class);
    }

}
