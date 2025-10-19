package com.mcst.order.remote;

import com.mcst.order.api.response.PickupLocationResp;
import com.mcst.order.api.request.PickupLocationReq;
import com.mcst.easyfk.remote.sc.IBaseRemote;
import org.springframework.cloud.openfeign.FeignClient;

/**
* <p>
* 提货点信息 Remote接口类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
@FeignClient(value = "${easyfk.config.remote.order.service-id:order-server}", path = "${easyfk.config.remote.order.base-path:/remote}/order/pickupLocation")
public interface IPickupLocationRemote extends IBaseRemote<PickupLocationResp,String,PickupLocationReq>{


}