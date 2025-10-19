package com.mcst.order.remote;

import com.mcst.order.api.response.OrderRefundResp;
import com.mcst.order.api.request.OrderRefundReq;
import com.mcst.easyfk.remote.dubbo.IDubboBaseRemote;

/**
* <p>
* 订单退款 Remote接口类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
public interface IOrderRefundRemote extends IDubboBaseRemote<OrderRefundResp,String,OrderRefundReq>{


}