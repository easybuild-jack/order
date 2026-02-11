package com.mcst.order.remote;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.sc.IBaseRemote;
import com.mcst.order.api.dto.OrderGoodsDto;
import com.mcst.order.api.request.*;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderFullDetailResp;
import com.mcst.order.api.response.OrderInfoResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    BaseResult<?> cancelOrder(@RequestBody CancelOrderReq req);

    /**
     * <p>
     * 支付成功回调（供交易系统/支付网关调用）
     * </p>
     *
     * @param req 支付回调请求
     * @return 支付回调结果
     */
    @PostMapping("/payCallback")
    BaseResult<?> payCallback(@RequestBody PayCallbackReq req);


    /**
     * 下单失败后的回滚
     *
     * @param orderNo 订单号
     * @return 操作结果
     */
    @GetMapping("/rollbackOrder")
    BaseResult<?> rollbackOrder(@RequestParam("orderNo") String orderNo);

    /**
     * <p>
     * 根据订单ID查询订单商品信息
     * </p>
     *
     * @param orderId 订单ID
     * @return 订单商品列表
     */
    @GetMapping("/getOrderGoodsByOrderId")
    List<OrderGoodsDto> getOrderGoodsByOrderId(@RequestParam("orderId") String orderId);


    /**
     * <p>
     * 根据订单ID查询订单全量信息
     * </p>
     *
     * @param orderId 订单ID
     * @return 订单全量信息
     */
    @GetMapping("/getOrderFullDetailByOrderId")
    OrderFullDetailResp getOrderFullDetailByOrderId(@RequestParam("orderId") String orderId);


    /**
     * <p>
     * 我的订单列表
     * </p>
     *
     * @param req 我的订单列表请求
     * @return 订单列表
     */
    @PostMapping("/myOrder")
    List<OrderInfoResp> myOrder(@RequestBody MyOrderListReq req);

    /**
     * <p>
     * 订单详情
     * </p>
     *
     * @param orderId 订单ID
     * @return 订单详情
     */
    @GetMapping("/orderDetail")
    OrderInfoResp orderDetail(@RequestParam("orderId") String orderId);
}
