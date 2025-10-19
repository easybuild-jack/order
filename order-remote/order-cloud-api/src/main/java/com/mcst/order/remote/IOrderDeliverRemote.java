package com.mcst.order.remote;

import com.mcst.order.api.response.OrderDeliverResp;
import com.mcst.order.api.request.OrderDeliverReq;
import com.mcst.easyfk.remote.sc.IBaseRemote;
import org.springframework.cloud.openfeign.FeignClient;

/**
* <p>
* 订单发货 Remote接口类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
@FeignClient(value = "${easyfk.config.remote.order.service-id:order-server}", path = "${easyfk.config.remote.order.base-path:/remote}/order/orderDeliver")
public interface IOrderDeliverRemote extends IBaseRemote<OrderDeliverResp,String,OrderDeliverReq>{


}