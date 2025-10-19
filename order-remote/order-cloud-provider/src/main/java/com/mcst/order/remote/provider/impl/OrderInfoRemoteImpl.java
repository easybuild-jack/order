package com.mcst.order.remote.provider.impl;

import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.server.service.IOrderInfoService;
import com.mcst.order.remote.IOrderInfoRemote;
import com.mcst.easyfk.remote.sc.BaseRemoteImpl;
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


}
