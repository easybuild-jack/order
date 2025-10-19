package com.mcst.order.remote.impl;

import com.mcst.order.api.response.OrderDeliverResp;
import com.mcst.order.api.request.OrderDeliverReq;
import com.mcst.order.api.IOrderDeliverApi;
import com.mcst.easyfk.remote.sc.BaseApiRemoteImpl;
import com.mcst.order.remote.IOrderDeliverRemote;
import jakarta.annotation.Resource;
/**
* <p>
* 订单发货 Api接口SC层实现
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
public class OrderDeliverApiScImpl extends BaseApiRemoteImpl<IOrderDeliverRemote, OrderDeliverResp,String,OrderDeliverReq> implements IOrderDeliverApi {

}
