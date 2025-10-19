package com.mcst.order.remote.provider.impl;

import com.mcst.order.api.response.PickupLocationResp;
import com.mcst.order.api.request.PickupLocationReq;
import com.mcst.order.server.service.IPickupLocationService;
import com.mcst.order.remote.IPickupLocationRemote;
import com.mcst.easyfk.remote.sc.BaseRemoteImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 提货点信息 RemoteImpl
* </p>
*
* @author liu yijun
*/
@RestController
@RequestMapping("${easyfk.config.remote.order.base-path:/remote}/order/pickupLocation")
public class PickupLocationRemoteImpl extends BaseRemoteImpl<IPickupLocationService, PickupLocationResp,String,PickupLocationReq> implements IPickupLocationRemote {


}
