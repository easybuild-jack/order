package com.mcst.order.controller;

import com.mcst.easyfk.authority.annotation.AuthResource;
import com.mcst.easyfk.authority.enums.ResourceCategory;
import com.mcst.easyfk.core.builders.RRBuilder;
import com.mcst.easyfk.core.builders.SRPBuilder;
import com.mcst.easyfk.core.dto.request.BatchBasicReq;
import com.mcst.easyfk.core.dto.response.ResponseResult;
import com.mcst.order.api.IOrderContainerApi;
import com.mcst.order.api.request.OrderContainerReq;
import com.mcst.order.api.response.OrderContainerResp;
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
 * @since 2026-01-29
 */
@Tag(name = "订单信息相关接口", description = "订单信息相关接口")
@RestController
@RequestMapping("/api/bms/order/orderContainer")
//@ResourceController(group = "orderManage", id = "orderManage", name = "订单管理", sort = 71000, path = "/order")
public class OrderContainerBmsController {
    @Resource
    private IOrderContainerApi orderContainerApi;

    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<OrderContainerResp> detail(String id) {
        return RRBuilder.buildSuccessBody(this.orderContainerApi.queryById(id));
    }

    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    @AuthResource(id = "orderDeliverManage", name = "发货管理", pId = "orderManage", pName = "订单管理", sort = 10500, path = "/order/container",
            category = ResourceCategory.menu)
    public ResponseResult<List<OrderContainerResp>> queryPage(@Validated OrderContainerReq orderContainerReq) {
        SRPBuilder<OrderContainerReq> builder = SRPBuilder.<OrderContainerReq>builder().example(orderContainerReq);
        return RRBuilder.buildBodyByPageResult(this.orderContainerApi.queryByPage(builder.build()));
    }


    @Operation(summary = "批量发货", description = "批量发货")
    @PostMapping("/batchDeliver")
    public ResponseResult<?> batchDeliver(@Validated @RequestBody BatchBasicReq<String> batchBase) {
       /* List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<OrderContainerReq> requestParam = MRPBuilder.<OrderContainerReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.orderContainerApi.batchDelivery(requestParam));*/
        return null;
    }


}
