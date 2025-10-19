package com.mcst.order.remote.impl;

import com.mcst.order.api.response.OrderRefundResp;
import com.mcst.order.api.request.OrderRefundReq;
import com.mcst.order.api.IOrderRefundApi;
import com.mcst.easyfk.remote.sc.BaseApiRemoteImpl;
import com.mcst.order.remote.IOrderRefundRemote;
import jakarta.annotation.Resource;
/**
* <p>
* 订单退款 Api接口SC层实现
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
public class OrderRefundApiScImpl extends BaseApiRemoteImpl<IOrderRefundRemote, OrderRefundResp,String,OrderRefundReq> implements IOrderRefundApi {

}
