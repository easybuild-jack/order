package com.mcst.order.remote.provider.impl;

import com.mcst.easyfk.remote.sc.BaseRemoteImpl;
import com.mcst.order.api.request.OrderDeliverReq;
import com.mcst.order.api.response.OrderDeliverResp;
import com.mcst.order.remote.IOrderDeliverRemote;
import com.mcst.order.server.service.IOrderDeliverService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单发货 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
@RestController
@RequestMapping("${easyfk.config.remote.order.base-path:/remote}/order/orderDeliver")
public class OrderDeliverRemoteImpl extends BaseRemoteImpl<IOrderDeliverService, OrderDeliverResp, String, OrderDeliverReq> implements IOrderDeliverRemote {


}
