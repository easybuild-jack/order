package com.mcst.order.controller;

import com.mcst.order.api.response.OrderDeliverResp;
import com.mcst.order.api.request.OrderDeliverReq;
import com.mcst.order.api.request.OrderDeliverEditReq;
import com.mcst.order.api.IOrderDeliverApi;
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

/**
* 订单发货相关接口
* @author liu yijun
* @since 2025-10-17
*/
@Tag(name = "订单发货相关接口", description = "订单发货相关接口")
@ResponseBody
@RequestMapping("/api/order/deliver")
public class OrderDeliverController {
    @Resource
    private IOrderDeliverApi orderDeliverApi;


    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<OrderDeliverResp> detail(String id) {
        return RRBuilder.buildSuccessBody(this.orderDeliverApi.queryById(id));
    }
    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    public ResponseResult<List<OrderDeliverResp>> queryPage(@Validated OrderDeliverReq orderDeliverReq) {
        SearchRequest<OrderDeliverReq> requestParam = SRPBuilder.buildRequest(orderDeliverReq);
        return RRBuilder.buildBodyByPageResult(this.orderDeliverApi.queryByPage(requestParam));
    }

    @Operation(summary = "新增/编辑", description = "新增/编辑")
    @PostMapping("/addOrEdit")
    public ResponseResult<?> addOrEdit(@RequestBody OrderDeliverEditReq orderDeliverEditReq) {
        ModifyRequest<OrderDeliverReq> requestParam = MRPBuilder.buildRequest(orderDeliverEditReq,OrderDeliverReq.class);
        return RRBuilder.buildBodyByBaseResult(this.orderDeliverApi.save(requestParam));
    }

    @Operation(summary = "批量删除", description = "批量删除")
    @PostMapping("/delete")
    public ResponseResult<?> delete(@Validated @RequestBody BatchBasicReq<String> batchBase) {
        List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<OrderDeliverReq> requestParam = MRPBuilder.<OrderDeliverReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.orderDeliverApi.delete(requestParam));
    }

}
