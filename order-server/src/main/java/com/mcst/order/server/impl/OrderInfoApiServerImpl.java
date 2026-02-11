package com.mcst.order.server.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.service.base.BaseApiServiceImpl;
import com.mcst.order.api.IOrderInfoApi;
import com.mcst.order.api.dto.OrderGoodsDto;
import com.mcst.order.api.request.*;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderFullDetailResp;
import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.server.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 订单信息!} Api接口Server层实现
 * </p>
 *
 * @author liu yijun
 */
public class OrderInfoApiServerImpl extends BaseApiServiceImpl<IOrderInfoService, OrderInfoResp, String, OrderInfoReq> implements IOrderInfoApi {

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

    @Override
    public List<OrderInfoResp> myOrder(MyOrderListReq req) {
        return this.orderInfoService.myOrder(req);
    }

    @Override
    public OrderInfoResp orderDetail(String orderId) {
        return this.orderInfoService.orderDetail(orderId);
    }
}
