package com.mcst.order.remote.impl;

import com.mcst.order.api.response.OrderContainerResp;
import com.mcst.order.api.request.OrderContainerReq;
import com.mcst.order.api.IOrderContainerApi;
import com.mcst.easyfk.remote.sc.BaseApiRemoteImpl;
import com.mcst.order.remote.IOrderContainerRemote;
import jakarta.annotation.Resource;
/**
* <p>
* 订单信息 Api接口SC层实现
* </p>
*
* @author liu yijun
* @since 2026-01-29
*/
public class OrderContainerApiScImpl extends BaseApiRemoteImpl<IOrderContainerRemote, OrderContainerResp,String,OrderContainerReq> implements IOrderContainerApi {

}
