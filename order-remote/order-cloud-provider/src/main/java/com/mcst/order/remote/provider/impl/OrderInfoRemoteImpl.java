package com.mcst.order.remote.provider.impl;

import com.mcst.easyfk.remote.sc.BaseRemoteImpl;
import com.mcst.easyfk.service.api.response.BaseResult;
import com.mcst.order.api.request.CancelOrderReq;
import com.mcst.order.api.request.CreateOrderReq;
import com.mcst.order.api.response.CancelOrderResp;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.server.service.IOrderInfoService;
import com.mcst.order.remote.IOrderInfoRemote;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单信息 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
@RestController
@RequestMapping("${easyfk.config.remote.order.base-path:/remote}/order/orderInfo")
public class OrderInfoRemoteImpl extends BaseRemoteImpl<IOrderInfoService, OrderInfoResp,String,OrderInfoReq> implements IOrderInfoRemote {

    @PostMapping("/createOrder")
    @Override
    public BaseResult<CreateOrderResp> createOrder(@RequestBody CreateOrderReq req) {
        return getService().createOrder(req);
    }

    @PostMapping("/cancelOrder")
    @Override
    public BaseResult<CancelOrderResp> cancelOrder(@RequestBody CancelOrderReq req) {
        return getService().cancelOrder(req);
    }

}
