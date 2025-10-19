package com.mcst.order.remote.impl;

import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.api.IOrderInfoApi;
import com.mcst.easyfk.remote.dubbo.DubboBaseApiRemoteImpl;
import com.mcst.order.remote.IOrderInfoRemote;
import jakarta.annotation.Resource;
/**
* <p>
* 订单信息 Api接口Dubbo层实现
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
public class OrderInfoApiDubboImpl extends DubboBaseApiRemoteImpl<IOrderInfoRemote, OrderInfoResp,String,OrderInfoReq> implements IOrderInfoApi {

}
