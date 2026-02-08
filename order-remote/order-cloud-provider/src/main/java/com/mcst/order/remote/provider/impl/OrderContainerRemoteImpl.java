package com.mcst.order.remote.provider.impl;

import com.mcst.easyfk.remote.sc.BaseRemoteImpl;
import com.mcst.order.api.request.OrderContainerReq;
import com.mcst.order.api.response.OrderContainerResp;
import com.mcst.order.remote.IOrderContainerRemote;
import com.mcst.order.server.service.IOrderContainerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 订单信息 RemoteImpl
 * </p>
 *
 * @author liu yijun
 */
@ResponseBody
@RequestMapping("${easyfk.config.remote.order.base-path:/remote}/order/container")
public class OrderContainerRemoteImpl extends BaseRemoteImpl<IOrderContainerService, OrderContainerResp, String, OrderContainerReq> implements IOrderContainerRemote {


}
