package com.mcst.order.remote.provider.impl;

import com.mcst.easyfk.remote.sc.BaseRemoteImpl;
import com.mcst.order.api.request.OrderPickupReq;
import com.mcst.order.api.response.OrderPickupResp;
import com.mcst.order.remote.IOrderPickupRemote;
import com.mcst.order.server.service.IOrderPickupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 订单提货 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
@ResponseBody
@RequestMapping("${easyfk.config.remote.order.base-path:/remote}/order/orderPickup")
public class OrderPickupRemoteImpl extends BaseRemoteImpl<IOrderPickupService, OrderPickupResp, String, OrderPickupReq> implements IOrderPickupRemote {


}
