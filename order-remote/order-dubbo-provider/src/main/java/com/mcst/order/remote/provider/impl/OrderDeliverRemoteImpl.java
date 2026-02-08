package com.mcst.order.remote.provider.impl;

import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import com.mcst.order.api.request.OrderDeliverReq;
import com.mcst.order.api.response.OrderDeliverResp;
import com.mcst.order.remote.IOrderDeliverRemote;
import com.mcst.order.server.service.IOrderDeliverService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * <p>
 * 订单发货 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
@DubboService
public class OrderDeliverRemoteImpl extends DubboBaseRemoteImpl<IOrderDeliverService, OrderDeliverResp, String, OrderDeliverReq> implements IOrderDeliverRemote {


}
