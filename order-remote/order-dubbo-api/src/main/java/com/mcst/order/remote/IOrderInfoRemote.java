package com.mcst.order.remote;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.dubbo.IDubboBaseRemote;
import com.mcst.order.api.request.CancelOrderReq;
import com.mcst.order.api.request.CreateOrderReq;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.api.request.PayCallbackReq;
import com.mcst.order.api.response.CancelOrderResp;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.api.response.PayCallbackResp;

/**
 * <p>
 * 订单信息 Remote接口类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public interface IOrderInfoRemote extends IDubboBaseRemote<OrderInfoResp, String, OrderInfoReq> {

    /**
     * <p>
     * 创建订单（供交易系统调用）
     * </p>
     *
     * @param req 创建订单请求
     * @return 创建结果
     */
    BaseResult<CreateOrderResp> createOrder(CreateOrderReq req);

    /**
     * <p>
     * 取消订单（供交易系统调用）
     * </p>
     *
     * @param req 取消订单请求
     * @return 取消结果
     */
    BaseResult<CancelOrderResp> cancelOrder(CancelOrderReq req);

    /**
     * <p>
     * 支付成功回调（供交易系统/支付网关调用）
     * </p>
     *
     * @param req 支付回调请求
     * @return 支付回调结果
     */
    BaseResult<PayCallbackResp> payCallback(PayCallbackReq req);


    /**
     * 下单失败后的回滚
     *
     * @param orderNo 订单号
     * @return 操作结果
     */
    BaseResult<?> rollbackOrder(String orderNo);

}
