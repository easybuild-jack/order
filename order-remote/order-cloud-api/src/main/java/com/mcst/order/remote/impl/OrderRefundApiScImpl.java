package com.mcst.order.remote.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.sc.BaseApiRemoteImpl;
import com.mcst.order.api.IOrderRefundApi;
import com.mcst.order.api.request.*;
import com.mcst.order.api.response.*;
import com.mcst.order.remote.IOrderRefundRemote;
import jakarta.annotation.Resource;

/**
 * <p>
 * 订单退款 Api接口SC层实现
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderRefundApiScImpl extends BaseApiRemoteImpl<IOrderRefundRemote, OrderRefundResp, String, OrderRefundReq> implements IOrderRefundApi {

    @Resource
    private IOrderRefundRemote orderRefundRemote;

    @Override
    public BaseResult<ApplyRefundResp> applyRefund(ApplyRefundReq req) {
        return orderRefundRemote.applyRefund(req);
    }

    @Override
    public BaseResult<AuditRefundResp> auditRefund(AuditRefundReq req) {
        return orderRefundRemote.auditRefund(req);
    }

    @Override
    public BaseResult<SubmitReturnExpressResp> submitReturnExpress(SubmitReturnExpressReq req) {
        return orderRefundRemote.submitReturnExpress(req);
    }

    @Override
    public BaseResult<ConfirmReceiveResp> confirmReceiveAndRefund(ConfirmReceiveReq req) {
        return orderRefundRemote.confirmReceiveAndRefund(req);
    }

    @Override
    public BaseResult<CancelRefundResp> cancelRefund(CancelRefundReq req) {
        return orderRefundRemote.cancelRefund(req);
    }

    @Override
    public BaseResult<RefundCallbackResp> refundCallback(RefundCallbackReq req) {
        return orderRefundRemote.refundCallback(req);
    }

}
