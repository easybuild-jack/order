package com.mcst.order.remote.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.dubbo.DubboBaseApiRemoteImpl;
import com.mcst.order.api.IOrderInfoApi;
import com.mcst.order.api.request.CancelOrderReq;
import com.mcst.order.api.request.CreateOrderReq;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.api.request.PayCallbackReq;
import com.mcst.order.api.response.CancelOrderResp;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.api.response.PayCallbackResp;
import com.mcst.order.remote.IOrderInfoRemote;
import org.apache.dubbo.config.annotation.DubboReference;

/**
 * <p>
 * 订单信息 Api接口Dubbo层实现
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderInfoApiDubboImpl extends DubboBaseApiRemoteImpl<IOrderInfoRemote, OrderInfoResp, String, OrderInfoReq> implements IOrderInfoApi {

    @DubboReference
    private IOrderInfoRemote orderInfoRemote;

    @Override
    public BaseResult<CreateOrderResp> createOrder(CreateOrderReq req) {
        return this.orderInfoRemote.createOrder(req);
    }

    @Override
    public BaseResult<CancelOrderResp> cancelOrder(CancelOrderReq req) {
        return this.orderInfoRemote.cancelOrder(req);
    }

    @Override
    public BaseResult<PayCallbackResp> payCallback(PayCallbackReq req) {
        return this.orderInfoRemote.payCallback(req);
    }

    @Override
    public BaseResult<?> rollbackOrder(String orderNo) {
        return this.orderInfoRemote.rollbackOrder(orderNo);
    }
}
