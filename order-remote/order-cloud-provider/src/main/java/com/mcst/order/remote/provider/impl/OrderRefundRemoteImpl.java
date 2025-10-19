package com.mcst.order.remote.provider.impl;

import com.mcst.order.api.response.OrderRefundResp;
import com.mcst.order.api.request.OrderRefundReq;
import com.mcst.order.server.service.IOrderRefundService;
import com.mcst.order.remote.IOrderRefundRemote;
import com.mcst.easyfk.remote.sc.BaseRemoteImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 订单退款 RemoteImpl
* </p>
*
* @author liu yijun
*/
@RestController
@RequestMapping("${easyfk.config.remote.order.base-path:/remote}/order/orderRefund")
public class OrderRefundRemoteImpl extends BaseRemoteImpl<IOrderRefundService, OrderRefundResp,String,OrderRefundReq> implements IOrderRefundRemote {


}
