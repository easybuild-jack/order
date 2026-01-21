package com.mcst.order.remote.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.sc.BaseApiRemoteImpl;
import com.mcst.order.api.IOrderInfoApi;
import com.mcst.order.api.request.CancelOrderReq;
import com.mcst.order.api.request.CreateOrderReq;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.api.response.CancelOrderResp;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.remote.IOrderInfoRemote;
import jakarta.annotation.Resource;

/**
 * <p>
 * 订单信息 Api接口SC层实现
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderInfoApiScImpl extends BaseApiRemoteImpl<IOrderInfoRemote, OrderInfoResp, String, OrderInfoReq> implements IOrderInfoApi {

    @Resource
    private IOrderInfoRemote orderInfoRemote;

    @Override
    public BaseResult<CreateOrderResp> createOrder(CreateOrderReq req) {
        return orderInfoRemote.createOrder(req);
    }

    @Override
    public BaseResult<CancelOrderResp> cancelOrder(CancelOrderReq req) {
        return orderInfoRemote.cancelOrder(req);
    }

}
