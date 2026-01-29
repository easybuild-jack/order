package com.mcst.order.remote.provider.impl;

import com.mcst.order.api.response.OrderContainerResp;
import com.mcst.order.api.request.OrderContainerReq;
import com.mcst.order.server.service.IOrderContainerService;
import com.mcst.order.remote.IOrderContainerRemote;
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
public class OrderContainerRemoteImpl extends DubboBaseRemoteImpl<IOrderContainerService, OrderContainerResp,String,OrderContainerReq> implements IOrderContainerRemote {


}
