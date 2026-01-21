package com.mcst.order.remote;

import com.mcst.easyfk.remote.sc.IBaseRemote;
import com.mcst.easyfk.service.api.response.BaseResult;
import com.mcst.order.api.request.CancelOrderReq;
import com.mcst.order.api.request.CreateOrderReq;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.api.response.CancelOrderResp;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderInfoResp;
import org.springframework.cloud.openfeign.FeignClient;

/**
* <p>
* 订单信息 Remote接口类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
@FeignClient(value = "${easyfk.config.remote.order.service-id:order-server}", path = "${easyfk.config.remote.order.base-path:/remote}/order/orderInfo")
public interface IOrderInfoRemote extends IBaseRemote<OrderInfoResp,String,OrderInfoReq>{

    /**
     * <p>
     * 创建订单（供交易系统调用）
     * </p>
     *
     * @param req 创建订单请求
     * @return 创建结果
     */
    BaseResult<CreateOrderResp> createOrder(CreateOrderReq req);

    /**
     * <p>
     * 取消订单（供交易系统调用）
     * </p>
     *
     * @param req 取消订单请求
     * @return 取消结果
     */
    BaseResult<CancelOrderResp> cancelOrder(CancelOrderReq req);

}
