package com.mcst.order.remote.provider.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import com.mcst.order.api.request.*;
import com.mcst.order.api.response.*;
import com.mcst.order.remote.IOrderRefundRemote;
import com.mcst.order.server.service.IOrderRefundService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 订单退款 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
@DubboService
public class OrderRefundRemoteImpl extends DubboBaseRemoteImpl<IOrderRefundService, OrderRefundResp, String, OrderRefundReq> implements IOrderRefundRemote {

    @Autowired
    private IOrderRefundService orderRefundService;

    @Override
    public BaseResult<ApplyRefundResp> applyRefund(ApplyRefundReq req) {
        return this.orderRefundService.applyRefund(req);
    }

    @Override
    public BaseResult<AuditRefundResp> auditRefund(AuditRefundReq req) {
        return this.orderRefundService.auditRefund(req);
    }

    @Override
    public BaseResult<SubmitReturnExpressResp> submitReturnExpress(SubmitReturnExpressReq req) {
        return this.orderRefundService.submitReturnExpress(req);
    }

    @Override
    public BaseResult<ConfirmReceiveResp> confirmReceiveAndRefund(ConfirmReceiveReq req) {
        return this.orderRefundService.confirmReceiveAndRefund(req);
    }

    @Override
    public BaseResult<CancelRefundResp> cancelRefund(CancelRefundReq req) {
        return this.orderRefundService.cancelRefund(req);
    }

    @Override
    public BaseResult<RefundCallbackResp> refundCallback(RefundCallbackReq req) {
        return this.orderRefundService.refundCallback(req);
    }

}
