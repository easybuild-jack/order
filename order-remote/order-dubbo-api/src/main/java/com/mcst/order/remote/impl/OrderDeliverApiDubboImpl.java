package com.mcst.order.remote.impl;

import com.mcst.easyfk.remote.dubbo.DubboBaseApiRemoteImpl;
import com.mcst.order.api.IOrderDeliverApi;
import com.mcst.order.api.request.OrderDeliverReq;
import com.mcst.order.api.response.OrderDeliverResp;
import com.mcst.order.remote.IOrderDeliverRemote;

/**
 * <p>
 * 订单发货 Api接口Dubbo层实现
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderDeliverApiDubboImpl extends DubboBaseApiRemoteImpl<IOrderDeliverRemote, OrderDeliverResp, String, OrderDeliverReq> implements IOrderDeliverApi {

}
