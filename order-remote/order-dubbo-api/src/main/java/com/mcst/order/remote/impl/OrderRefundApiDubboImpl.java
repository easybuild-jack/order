package com.mcst.order.remote.impl;

import com.mcst.order.api.response.OrderRefundResp;
import com.mcst.order.api.request.OrderRefundReq;
import com.mcst.order.api.IOrderRefundApi;
import com.mcst.easyfk.remote.dubbo.DubboBaseApiRemoteImpl;
import com.mcst.order.remote.IOrderRefundRemote;
import jakarta.annotation.Resource;
/**
* <p>
* 订单退款 Api接口Dubbo层实现
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
public class OrderRefundApiDubboImpl extends DubboBaseApiRemoteImpl<IOrderRefundRemote, OrderRefundResp,String,OrderRefundReq> implements IOrderRefundApi {

}
