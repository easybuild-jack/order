package com.mcst.order.remote;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.sc.IBaseRemote;
import com.mcst.order.api.request.*;
import com.mcst.order.api.response.*;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 订单退款 Remote接口类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@FeignClient(value = "${easyfk.config.remote.order.service-id:order-server}", path = "${easyfk.config.remote.order.base-path:/remote}/order/orderRefund")
public interface IOrderRefundRemote extends IBaseRemote<OrderRefundResp, String, OrderRefundReq> {

    /**
     * <p>
     * 申请退款/退货
     * </p>
     *
     * @param req 申请退款请求
     * @return 申请结果
     */
    BaseResult<ApplyRefundResp> applyRefund(ApplyRefundReq req);

    /**
     * <p>
     * 审核退款申请
     * </p>
     *
     * @param req 审核退款请求
     * @return 审核结果
     */
    BaseResult<AuditRefundResp> auditRefund(AuditRefundReq req);

    /**
     * <p>
     * 填写退货物流
     * </p>
     *
     * @param req 填写退货物流请求
     * @return 提交结果
     */
    BaseResult<SubmitReturnExpressResp> submitReturnExpress(SubmitReturnExpressReq req);

    /**
     * <p>
     * 确认收货并退款
     * </p>
     *
     * @param req 确认收货请求
     * @return 确认结果
     */
    BaseResult<ConfirmReceiveResp> confirmReceiveAndRefund(ConfirmReceiveReq req);

    /**
     * <p>
     * 取消退款申请
     * </p>
     *
     * @param req 取消退款请求
     * @return 取消结果
     */
    BaseResult<CancelRefundResp> cancelRefund(CancelRefundReq req);

    /**
     * <p>
     * 退款完成回调（供交易系统调用）
     * </p>
     *
     * @param req 退款回调请求
     * @return 回调结果
     */
    BaseResult<RefundCallbackResp> refundCallback(RefundCallbackReq req);

}
