package com.mcst.order.remote;

import com.mcst.easyfk.remote.dubbo.IDubboBaseRemote;
import com.mcst.order.api.request.OrderPickupReq;
import com.mcst.order.api.response.OrderPickupResp;

/**
 * <p>
 * 订单提货 Remote接口类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public interface IOrderPickupRemote extends IDubboBaseRemote<OrderPickupResp, String, OrderPickupReq> {


}