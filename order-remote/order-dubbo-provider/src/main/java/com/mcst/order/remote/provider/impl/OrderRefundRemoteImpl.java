package com.mcst.order.remote.provider.impl;

import com.mcst.order.api.response.OrderRefundResp;
import com.mcst.order.api.request.OrderRefundReq;
import com.mcst.order.server.service.IOrderRefundService;
import com.mcst.order.remote.IOrderRefundRemote;
import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import org.apache.dubbo.config.annotation.DubboService;

/**
* <p>
* 订单退款 RemoteImpl
* </p>
*
* @author liu yijun
*/
@DubboService
public class OrderRefundRemoteImpl extends DubboBaseRemoteImpl<IOrderRefundService, OrderRefundResp,String,OrderRefundReq> implements IOrderRefundRemote {


}
