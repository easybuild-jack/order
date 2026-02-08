package com.mcst.order.remote.provider.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.sc.BaseRemoteImpl;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 订单信息 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
@ResponseBody
@RequestMapping("${easyfk.config.remote.order.base-path:/remote}/order/orderInfo")
public class OrderInfoRemoteImpl extends BaseRemoteImpl<IOrderInfoService, OrderInfoResp, String, OrderInfoReq> implements IOrderInfoRemote {

    @Autowired
    private IOrderInfoService orderInfoService;

    @Override
    public BaseResult<CreateOrderResp> createOrder(@RequestBody CreateOrderReq req) {
        return this.orderInfoService.createOrder(req);
    }

    @Override
    public BaseResult<?> cancelOrder(@RequestBody CancelOrderReq req) {
        return this.orderInfoService.cancelOrder(req);
    }

    @Override
    public BaseResult<?> payCallback(@RequestBody PayCallbackReq req) {
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
