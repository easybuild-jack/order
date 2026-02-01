package com.mcst.order.remote.provider.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import com.mcst.order.api.dto.OrderGoodsDto;
import com.mcst.order.api.request.CancelOrderReq;
import com.mcst.order.api.request.CreateOrderReq;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.api.request.PayCallbackReq;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderFullDetailResp;
import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.remote.IOrderInfoRemote;
import com.mcst.order.server.service.IOrderInfoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 订单信息 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
@DubboService
public class OrderInfoRemoteImpl extends DubboBaseRemoteImpl<IOrderInfoService, OrderInfoResp, String, OrderInfoReq> implements IOrderInfoRemote {

    @Autowired
    private IOrderInfoService orderInfoService;

    @Override
    public BaseResult<CreateOrderResp> createOrder(CreateOrderReq req) {
        return this.orderInfoService.createOrder(req);
    }

    @Override
    public BaseResult<?> cancelOrder(CancelOrderReq req) {
        return this.orderInfoService.cancelOrder(req);
    }

    @Override
    public BaseResult<?> payCallback(PayCallbackReq req) {
        return this.orderInfoService.payCallback(req);
    }

    @Override
    public BaseResult<?> rollbackOrder(String orderNo) {
        return this.orderInfoService.rollbackOrder(orderNo);
    }

    @Override
    public List<OrderGoodsDto> getOrderGoodsByOrderId(String orderId) {
        return this.orderInfoService.getOrderGoodsByOrderId(orderId);
    }

    @Override
    public OrderFullDetailResp getOrderFullDetailByOrderId(String orderId) {
        return this.orderInfoService.getOrderFullDetailByOrderId(orderId);
    }
}
