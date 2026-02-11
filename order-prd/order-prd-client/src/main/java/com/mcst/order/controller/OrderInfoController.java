package com.mcst.order.controller;

import com.mcst.easyfk.authority.annotation.LoginResource;
import com.mcst.easyfk.core.builders.RRBuilder;
import com.mcst.easyfk.core.context.UserDataContext;
import com.mcst.easyfk.core.dto.response.ResponseResult;
import com.mcst.order.api.IOrderInfoApi;
import com.mcst.order.api.request.MyOrderListReq;
import com.mcst.order.api.response.OrderFullDetailResp;
import com.mcst.order.api.response.OrderInfoResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单信息相关接口
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Tag(name = "订单信息相关接口", description = "订单信息相关接口")
@RestController
@RequestMapping("/api/order/info")
public class OrderInfoController {
    @Resource
    private IOrderInfoApi orderInfoApi;


    @Operation(summary = "全量详情")
    @GetMapping("/fullDetail")
    public ResponseResult<OrderFullDetailResp> fullDetail(@RequestParam("orderId") String orderId) {
        return RRBuilder.buildSuccessBody(this.orderInfoApi.getOrderFullDetailByOrderId(orderId));
    }

    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<OrderInfoResp> detail(@RequestParam("orderId") String orderId) {
        return RRBuilder.buildSuccessBody(this.orderInfoApi.orderDetail(orderId));
    }

    @LoginResource
    @Operation(summary = "我的订单", description = "我的订单")
    @GetMapping("/myOrderList")
    public ResponseResult<List<OrderInfoResp>> myOrderList(@Validated MyOrderListReq myOrderListReq) {
        myOrderListReq.setUserId(UserDataContext.getUserData().getUserId());
        return RRBuilder.buildSuccessBody(this.orderInfoApi.myOrder(myOrderListReq));
    }


}
