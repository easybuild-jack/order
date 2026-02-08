package com.mcst.order.remote.impl;

import com.mcst.easyfk.remote.dubbo.DubboBaseApiRemoteImpl;
import com.mcst.order.api.IOrderPickupApi;
import com.mcst.order.api.request.OrderPickupReq;
import com.mcst.order.api.response.OrderPickupResp;
import com.mcst.order.remote.IOrderPickupRemote;

/**
 * <p>
 * 订单提货 Api接口Dubbo层实现
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderPickupApiDubboImpl extends DubboBaseApiRemoteImpl<IOrderPickupRemote, OrderPickupResp, String, OrderPickupReq> implements IOrderPickupApi {

}
