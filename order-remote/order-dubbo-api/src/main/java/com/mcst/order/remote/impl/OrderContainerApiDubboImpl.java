package com.mcst.order.remote.impl;

import com.mcst.easyfk.remote.dubbo.DubboBaseApiRemoteImpl;
import com.mcst.order.api.IOrderContainerApi;
import com.mcst.order.api.request.OrderContainerReq;
import com.mcst.order.api.response.OrderContainerResp;
import com.mcst.order.remote.IOrderContainerRemote;

/**
 * <p>
 * 订单信息 Api接口Dubbo层实现
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-29
 */
public class OrderContainerApiDubboImpl extends DubboBaseApiRemoteImpl<IOrderContainerRemote, OrderContainerResp, String, OrderContainerReq> implements IOrderContainerApi {

}
