package com.mcst.order.remote.provider.impl;

import com.mcst.order.api.response.PickupLocationResp;
import com.mcst.order.api.request.PickupLocationReq;
import com.mcst.order.server.service.IPickupLocationService;
import com.mcst.order.remote.IPickupLocationRemote;
import com.mcst.easyfk.remote.dubbo.DubboBaseRemoteImpl;
import org.apache.dubbo.config.annotation.DubboService;

/**
* <p>
* 提货点信息 RemoteImpl
* </p>
*
* @author liu yijun
*/
@DubboService
public class PickupLocationRemoteImpl extends DubboBaseRemoteImpl<IPickupLocationService, PickupLocationResp,String,PickupLocationReq> implements IPickupLocationRemote {


}
