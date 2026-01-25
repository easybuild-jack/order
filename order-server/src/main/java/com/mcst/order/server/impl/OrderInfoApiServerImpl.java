package com.mcst.order.server.impl;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.service.base.BaseApiServiceImpl;
import com.mcst.order.api.IOrderInfoApi;
import com.mcst.order.api.request.CancelOrderReq;
import com.mcst.order.api.request.CreateOrderReq;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.api.request.PayCallbackReq;
import com.mcst.order.api.response.CancelOrderResp;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.api.response.PayCallbackResp;
import com.mcst.order.server.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;

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
    public BaseResult<CancelOrderResp> cancelOrder(CancelOrderReq req) {
        return this.orderInfoService.cancelOrder(req);
    }

    @Override
    public BaseResult<PayCallbackResp> payCallback(PayCallbackReq req) {
        return this.orderInfoService.payCallback(req);
    }

    @Override
    public BaseResult<?> rollbackOrder(String orderNo) {
        return this.orderInfoService.rollbackOrder(orderNo);
    }
}
