package com.mcst.order.remote.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.sc.BaseApiRemoteImpl;
import com.mcst.order.api.IOrderInfoApi;
import com.mcst.order.api.dto.OrderGoodsDto;
import com.mcst.order.api.request.CancelOrderReq;
import com.mcst.order.api.request.CreateOrderReq;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.api.request.PayCallbackReq;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderFullDetailResp;
import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.remote.IOrderInfoRemote;
import jakarta.annotation.Resource;

import java.util.List;

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
    public BaseResult<?> cancelOrder(CancelOrderReq req) {
        return orderInfoRemote.cancelOrder(req);
    }

    @Override
    public BaseResult<?> payCallback(PayCallbackReq req) {
        return orderInfoRemote.payCallback(req);
    }

    @Override
    public BaseResult<?> rollbackOrder(String orderNo) {
        return orderInfoRemote.rollbackOrder(orderNo);
    }

    @Override
    public List<OrderGoodsDto> getOrderGoodsByOrderNo(String orderNo) {
        return this.orderInfoRemote.getOrderGoodsByOrderNo(orderNo);
    }

    @Override
    public OrderFullDetailResp getOrderFullDetailByOrderNo(String orderNo) {
        return this.orderInfoRemote.getOrderFullDetailByOrderNo(orderNo);
    }
}
