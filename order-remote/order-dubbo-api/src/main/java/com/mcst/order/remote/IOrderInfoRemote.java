package com.mcst.order.remote;

import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.remote.dubbo.IDubboBaseRemote;
import com.mcst.order.api.dto.OrderGoodsDto;
import com.mcst.order.api.request.*;
import com.mcst.order.api.response.CreateOrderResp;
import com.mcst.order.api.response.OrderFullDetailResp;
import com.mcst.order.api.response.OrderInfoResp;

import java.util.List;

/**
 * <p>
 * 订单信息 Remote接口类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public interface IOrderInfoRemote extends IDubboBaseRemote<OrderInfoResp, String, OrderInfoReq> {

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
    BaseResult<?> cancelOrder(CancelOrderReq req);

    /**
     * <p>
     * 支付成功回调（供交易系统/支付网关调用）
     * </p>
     *
     * @param req 支付回调请求
     * @return 支付回调结果
     */
    BaseResult<?> payCallback(PayCallbackReq req);


    /**
     * 下单失败后的回滚
     *
     * @param orderNo 订单号
     * @return 操作结果
     */
    BaseResult<?> rollbackOrder(String orderNo);

    /**
     * <p>
     * 根据订单ID查询订单商品信息
     * </p>
     *
     * @param orderId 订单ID
     * @return 订单商品列表
     */
    List<OrderGoodsDto> getOrderGoodsByOrderId(String orderId);


    /**
     * <p>
     * 根据订单ID查询订单全量信息
     * </p>
     *
     * @param orderId 订单ID
     * @return 订单全量信息
     */
    OrderFullDetailResp getOrderFullDetailByOrderId(String orderId);

    /**
     * <p>
     * 我的订单列表
     * </p>
     *
     * @param req 我的订单列表请求
     * @return 订单列表
     */
    List<OrderInfoResp> myOrder(MyOrderListReq req);


    /**
     * <p>
     * 订单详情
     * </p>
     *
     * @param orderId 订单ID
     * @return 订单详情
     */
    OrderInfoResp orderDetail(String orderId);

}
