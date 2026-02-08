package com.mcst.order.remote;

import com.mcst.easyfk.remote.dubbo.IDubboBaseRemote;
import com.mcst.order.api.request.OrderDeliverReq;
import com.mcst.order.api.response.OrderDeliverResp;

/**
 * <p>
 * 订单发货 Remote接口类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public interface IOrderDeliverRemote extends IDubboBaseRemote<OrderDeliverResp, String, OrderDeliverReq> {


}