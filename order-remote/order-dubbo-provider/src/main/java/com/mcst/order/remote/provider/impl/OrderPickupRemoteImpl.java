package com.mcst.order.remote.provider.impl;

import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import com.mcst.order.api.request.OrderPickupReq;
import com.mcst.order.api.response.OrderPickupResp;
import com.mcst.order.remote.IOrderPickupRemote;
import com.mcst.order.server.service.IOrderPickupService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * <p>
 * 订单提货 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
@DubboService
public class OrderPickupRemoteImpl extends DubboBaseRemoteImpl<IOrderPickupService, OrderPickupResp, String, OrderPickupReq> implements IOrderPickupRemote {


}
