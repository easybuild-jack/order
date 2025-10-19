package com.mcst.order.remote;

import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.easyfk.remote.dubbo.IDubboBaseRemote;

/**
* <p>
* 订单信息 Remote接口类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
public interface IOrderInfoRemote extends IDubboBaseRemote<OrderInfoResp,String,OrderInfoReq>{


}