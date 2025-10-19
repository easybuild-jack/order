package com.mcst.order.controller;

import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.api.request.OrderInfoEditReq;
import com.mcst.order.api.IOrderInfoApi;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.builders.MRPBuilder;
import com.mcst.easyfk.core.dto.request.SearchRequest;
import com.mcst.easyfk.core.builders.SRPBuilder;
import com.mcst.easyfk.core.dto.response.ResponseResult;
import com.mcst.easyfk.core.builders.RRBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.mcst.easyfk.core.dto.request.BatchBasicReq;
import com.mcst.easyfk.core.utils.common.SplitUtil;
import jakarta.annotation.Resource;
import java.util.List;
import com.mcst.easyfk.authority.annotation.AuthResource;
import com.mcst.easyfk.authority.annotation.ResourceController;
import com.mcst.easyfk.authority.enums.ResourceCategory;


/**
* 订单信息相关接口
* @author liu yijun
* @since 2025-10-17
*/
@Tag(name = "订单信息相关接口", description = "订单信息相关接口")
@RestController
@RequestMapping("/api/bms/order/orderInfo")
@ResourceController(group = "operationSetting", id = "operationSetting", name = "运营管理", sort = 71000, path = "/operation")
public class OrderInfoBmsController {
    @Resource
    private IOrderInfoApi orderInfoApi;

    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<OrderInfoResp> detail(String id) {
        return RRBuilder.buildSuccessBody(this.orderInfoApi.queryById(id));
    }

    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    @AuthResource(id = "orderInfoManage", name = "订单信息管理", pId = "operationSetting", pName = "运营管理", sort = 10100, path = "/operation/orderInfo",
        category = ResourceCategory.menu)
    public ResponseResult<List<OrderInfoResp>> queryPage(@Validated OrderInfoReq orderInfoReq) {
        SRPBuilder<OrderInfoReq> builder = SRPBuilder.<OrderInfoReq>builder().example(orderInfoReq);
        return RRBuilder.buildBodyByPageResult(this.orderInfoApi.queryByPage(builder.build()));
    }

    @Operation(summary = "新增/编辑", description = "新增/编辑")
    @PostMapping("/addOrEdit")
    @AuthResource(id = "orderInfoAddOrEdit", name = "新增/编辑", title = "新增/编辑", pId = "orderInfoManage", pName = "订单信息管理", sort = 10101, category = ResourceCategory.action,
        actionCode = "addOrEdit")
    public ResponseResult<?> addOrEdit(@RequestBody OrderInfoEditReq orderInfoEditReq) {
        ModifyRequest<OrderInfoReq> requestParam = MRPBuilder.buildRequest(orderInfoEditReq, OrderInfoReq.class);
        return RRBuilder.buildBodyByBaseResult(this.orderInfoApi.save(requestParam));
    }

    @Operation(summary = "批量删除", description = "批量删除")
    @PostMapping("/delete")
    @AuthResource(id = "orderInfoDelete", name = "删除", title = "删除", pId = "orderInfoManage", pName = "订单信息管理", sort = 10102, category = ResourceCategory.action,
        actionCode = "delete")
    public ResponseResult<?> delete(@Validated @RequestBody BatchBasicReq<String> batchBase) {
        List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<OrderInfoReq> requestParam = MRPBuilder.<OrderInfoReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.orderInfoApi.delete(requestParam));
    }

}
