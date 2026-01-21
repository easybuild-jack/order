package com.mcst.order.remote.provider.impl;

import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import com.mcst.easyfk.service.api.response.BaseResult;
import com.mcst.order.api.request.CancelOrderReq;
import com.mcst.order.api.request.CreateOrderReq;
import com.mcst.order.api.response.CancelOrderResp;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.server.service.IOrderInfoService;
import com.mcst.order.remote.IOrderInfoRemote;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * <p>
 * 订单信息 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
@DubboService
public class OrderInfoRemoteImpl extends DubboBaseRemoteImpl<IOrderInfoService, OrderInfoResp,String,OrderInfoReq> implements IOrderInfoRemote {

    @Override
    public BaseResult<CreateOrderResp> createOrder(CreateOrderReq req) {
        return getService().createOrder(req);
    }

    @Override
    public BaseResult<CancelOrderResp> cancelOrder(CancelOrderReq req) {
        return getService().cancelOrder(req);
    }

}
