package com.mcst.order.remote.provider.impl;

import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.server.service.IOrderInfoService;
import com.mcst.order.remote.IOrderInfoRemote;
import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import org.apache.dubbo.config.annotation.DubboService;

/**
* <p>
* 订单信息 RemoteImpl
* </p>
*
* @author liu yijun
*/
@DubboService
public class OrderInfoRemoteImpl extends DubboBaseRemoteImpl<IOrderInfoService, OrderInfoResp,String,OrderInfoReq> implements IOrderInfoRemote {


}
