package com.mcst.order.remote;

import com.mcst.order.api.response.PickupLocationResp;
import com.mcst.order.api.request.PickupLocationReq;
import com.mcst.easyfk.remote.dubbo.IDubboBaseRemote;

/**
* <p>
* 提货点信息 Remote接口类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
public interface IPickupLocationRemote extends IDubboBaseRemote<PickupLocationResp,String,PickupLocationReq>{


}