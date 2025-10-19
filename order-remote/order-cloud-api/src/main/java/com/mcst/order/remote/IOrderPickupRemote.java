package com.mcst.order.remote;

import com.mcst.order.api.response.OrderPickupResp;
import com.mcst.order.api.request.OrderPickupReq;
import com.mcst.easyfk.remote.sc.IBaseRemote;
import org.springframework.cloud.openfeign.FeignClient;

/**
* <p>
* 订单提货 Remote接口类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
@FeignClient(value = "${easyfk.config.remote.order.service-id:order-server}", path = "${easyfk.config.remote.order.base-path:/remote}/order/orderPickup")
public interface IOrderPickupRemote extends IBaseRemote<OrderPickupResp,String,OrderPickupReq>{


}