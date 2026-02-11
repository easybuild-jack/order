package com.mcst.order.controller;

import com.mcst.easyfk.authority.annotation.AuthResource;
import com.mcst.easyfk.authority.annotation.ResourceController;
import com.mcst.easyfk.authority.enums.ResourceCategory;
import com.mcst.easyfk.core.builders.MRPBuilder;
import com.mcst.easyfk.core.builders.RRBuilder;
import com.mcst.easyfk.core.builders.SRPBuilder;
import com.mcst.easyfk.core.dto.request.BatchBasicReq;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.dto.response.ResponseResult;
import com.mcst.easyfk.core.utils.common.SplitUtil;
import com.mcst.order.api.IOrderInfoApi;
import com.mcst.order.api.dto.OrderGoodsDto;
import com.mcst.order.api.request.OrderInfoEditReq;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.api.response.OrderFullDetailResp;
import com.mcst.order.api.response.OrderInfoResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单信息相关接口
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Tag(name = "订单信息相关接口", description = "订单信息相关接口")
@RestController
@RequestMapping("/api/bms/order/info")
@ResourceController(group = "orderManage", id = "orderManage", name = "订单管理", sort = 71000, path = "/order")
public class OrderInfoBmsController {
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

    @Operation(summary = "订单商品")
    @GetMapping("/orderGoods")
    public ResponseResult<List<OrderGoodsDto>> orderGoods(@RequestParam("orderId") String orderId) {
        return RRBuilder.buildSuccessBody(this.orderInfoApi.getOrderGoodsByOrderId(orderId));
    }

    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    @AuthResource(id = "orderInfoManage", name = "订单管理", pId = "orderManage", pName = "订单管理", sort = 10100, path = "/order/order", category = ResourceCategory.menu)
    public ResponseResult<List<OrderInfoResp>> queryPage(@Validated OrderInfoReq orderInfoReq) {
        SRPBuilder<OrderInfoReq> builder = SRPBuilder.<OrderInfoReq>builder().example(orderInfoReq);
        return RRBuilder.buildBodyByPageResult(this.orderInfoApi.queryByPage(builder.build()));
    }

    @Operation(summary = "新增/编辑", description = "新增/编辑")
    @PostMapping("/addOrEdit")
    @AuthResource(id = "orderInfoAddOrEdit", name = "新增/编辑", title = "新增/编辑", pId = "orderInfoManage", pName = "订单管理", sort = 10101, category = ResourceCategory.action, actionCode = "addOrEdit")
    public ResponseResult<?> addOrEdit(@RequestBody OrderInfoEditReq orderInfoEditReq) {
        ModifyRequest<OrderInfoReq> requestParam = MRPBuilder.buildRequest(orderInfoEditReq, OrderInfoReq.class);
        return RRBuilder.buildBodyByBaseResult(this.orderInfoApi.save(requestParam));
    }

    @Operation(summary = "批量删除", description = "批量删除")
    @PostMapping("/delete")
    @AuthResource(id = "orderInfoDelete", name = "删除", title = "删除", pId = "orderInfoManage", pName = "订单管理", sort = 10102, category = ResourceCategory.action, actionCode = "delete")
    public ResponseResult<?> delete(@Validated @RequestBody BatchBasicReq<String> batchBase) {
        List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<OrderInfoReq> requestParam = MRPBuilder.<OrderInfoReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.orderInfoApi.delete(requestParam));
    }

}
