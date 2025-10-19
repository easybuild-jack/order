package com.mcst.order.remote.impl;

import com.mcst.order.api.response.PickupLocationResp;
import com.mcst.order.api.request.PickupLocationReq;
import com.mcst.order.api.IPickupLocationApi;
import com.mcst.easyfk.remote.dubbo.DubboBaseApiRemoteImpl;
import com.mcst.order.remote.IPickupLocationRemote;
import jakarta.annotation.Resource;
/**
* <p>
* 提货点信息 Api接口Dubbo层实现
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
public class PickupLocationApiDubboImpl extends DubboBaseApiRemoteImpl<IPickupLocationRemote, PickupLocationResp,String,PickupLocationReq> implements IPickupLocationApi {

}
