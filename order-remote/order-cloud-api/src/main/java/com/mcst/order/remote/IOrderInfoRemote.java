package com.mcst.order.remote;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.sc.IBaseRemote;
import com.mcst.order.api.request.CancelOrderReq;
import com.mcst.order.api.request.CreateOrderReq;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.api.request.PayCallbackReq;
import com.mcst.order.api.response.CancelOrderResp;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.api.response.PayCallbackResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 订单信息 Remote接口类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@FeignClient(value = "${easyfk.config.remote.order.service-id:server}", path = "${easyfk.config.remote.order.base-path:/remote}/order/orderInfo")
public interface IOrderInfoRemote extends IBaseRemote<OrderInfoResp, String, OrderInfoReq> {

    /**
     * <p>
     * 创建订单（供交易系统调用）
     * </p>
     *
     * @param req 创建订单请求
     * @return 创建结果
     */
    @PostMapping("/createOrder")
    BaseResult<CreateOrderResp> createOrder(@RequestBody CreateOrderReq req);

    /**
     * <p>
     * 取消订单（供交易系统调用）
     * </p>
     *
     * @param req 取消订单请求
     * @return 取消结果
     */
    @PostMapping("/cancelOrder")
    BaseResult<CancelOrderResp> cancelOrder(@RequestBody CancelOrderReq req);

    /**
     * <p>
     * 支付成功回调（供交易系统/支付网关调用）
     * </p>
     *
     * @param req 支付回调请求
     * @return 支付回调结果
     */
    @PostMapping("/payCallback")
    BaseResult<PayCallbackResp> payCallback(@RequestBody PayCallbackReq req);


    /**
     * 下单失败后的回滚
     *
     * @param orderNo 订单号
     * @return 操作结果
     */
    @GetMapping("/rollbackOrder")
    BaseResult<?> rollbackOrder(@RequestParam("orderNo") String orderNo);

}
