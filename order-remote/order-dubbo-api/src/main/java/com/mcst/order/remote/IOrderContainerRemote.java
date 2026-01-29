package com.mcst.order.remote;

import com.mcst.order.api.response.OrderContainerResp;
import com.mcst.order.api.request.OrderContainerReq;
import com.mcst.easyfk.remote.dubbo.IDubboBaseRemote;

/**
* <p>
* 订单信息 Remote接口类
* </p>
*
* @author liu yijun
* @since 2026-01-29
*/
public interface IOrderContainerRemote extends IDubboBaseRemote<OrderContainerResp,String,OrderContainerReq>{


}