package com.mcst.order.remote.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.dubbo.DubboBaseApiRemoteImpl;
import com.mcst.order.api.IOrderRefundApi;
import com.mcst.order.api.request.*;
import com.mcst.order.api.response.*;
import com.mcst.order.remote.IOrderRefundRemote;
import org.apache.dubbo.config.annotation.DubboReference;

/**
 * <p>
 * 订单退款 Api接口Dubbo层实现
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderRefundApiDubboImpl extends DubboBaseApiRemoteImpl<IOrderRefundRemote, OrderRefundResp, String, OrderRefundReq> implements IOrderRefundApi {

    @DubboReference
    private IOrderRefundRemote orderRefundRemote;

    @Override
    public BaseResult<ApplyRefundResp> applyRefund(ApplyRefundReq req) {
        return this.orderRefundRemote.applyRefund(req);
    }

    @Override
    public BaseResult<AuditRefundResp> auditRefund(AuditRefundReq req) {
        return this.orderRefundRemote.auditRefund(req);
    }

    @Override
    public BaseResult<SubmitReturnExpressResp> submitReturnExpress(SubmitReturnExpressReq req) {
        return this.orderRefundRemote.submitReturnExpress(req);
    }

    @Override
    public BaseResult<ConfirmReceiveResp> confirmReceiveAndRefund(ConfirmReceiveReq req) {
        return this.orderRefundRemote.confirmReceiveAndRefund(req);
    }

    @Override
    public BaseResult<CancelRefundResp> cancelRefund(CancelRefundReq req) {
        return this.orderRefundRemote.cancelRefund(req);
    }

    @Override
    public BaseResult<RefundCallbackResp> refundCallback(RefundCallbackReq req) {
        return this.orderRefundRemote.refundCallback(req);
    }

}
