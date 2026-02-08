package com.mcst.order.remote;

import com.mcst.easyfk.remote.sc.IBaseRemote;
import com.mcst.order.api.request.OrderContainerReq;
import com.mcst.order.api.response.OrderContainerResp;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 订单信息 Remote接口类
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-29
 */
@FeignClient(value = "${easyfk.config.remote.order.service-id:server}", path = "${easyfk.config.remote.order.base-path:/remote}/order/container")
public interface IOrderContainerRemote extends IBaseRemote<OrderContainerResp, String, OrderContainerReq> {


}