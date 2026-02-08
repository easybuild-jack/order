package com.mcst.order.remote.provider.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.sc.BaseRemoteImpl;
import com.mcst.order.api.request.*;
import com.mcst.order.api.response.*;
import com.mcst.order.remote.IOrderRefundRemote;
import com.mcst.order.server.service.IOrderRefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 订单退款 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
@ResponseBody
@RequestMapping("${easyfk.config.remote.order.base-path:/remote}/order/orderRefund")
public class OrderRefundRemoteImpl extends BaseRemoteImpl<IOrderRefundService, OrderRefundResp, String, OrderRefundReq> implements IOrderRefundRemote {

    @Autowired
    private IOrderRefundService orderRefundService;

    @Override
    public BaseResult<ApplyRefundResp> applyRefund(@RequestBody ApplyRefundReq req) {
        return this.orderRefundService.applyRefund(req);
    }

    @Override
    public BaseResult<AuditRefundResp> auditRefund(@RequestBody AuditRefundReq req) {
        return this.orderRefundService.auditRefund(req);
    }

    @Override
    public BaseResult<SubmitReturnExpressResp> submitReturnExpress(@RequestBody SubmitReturnExpressReq req) {
        return this.orderRefundService.submitReturnExpress(req);
    }

    @Override
    public BaseResult<ConfirmReceiveResp> confirmReceiveAndRefund(@RequestBody ConfirmReceiveReq req) {
        return this.orderRefundService.confirmReceiveAndRefund(req);
    }

    @Override
    public BaseResult<CancelRefundResp> cancelRefund(@RequestBody CancelRefundReq req) {
        return this.orderRefundService.cancelRefund(req);
    }

    @Override
    public BaseResult<RefundCallbackResp> refundCallback(@RequestBody RefundCallbackReq req) {
        return this.orderRefundService.refundCallback(req);
    }

}
