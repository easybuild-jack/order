package com.mcst.order.controller;

import com.mcst.order.api.response.OrderPickupResp;
import com.mcst.order.api.request.OrderPickupReq;
import com.mcst.order.api.request.OrderPickupEditReq;
import com.mcst.order.api.IOrderPickupApi;
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
* 订单提货相关接口
* @author liu yijun
* @since 2025-10-17
*/
@Tag(name = "订单提货相关接口", description = "订单提货相关接口")
@ResponseBody
@RequestMapping("/api/order/pickup")
public class OrderPickupController {
    @Resource
    private IOrderPickupApi orderPickupApi;


    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<OrderPickupResp> detail(String id) {
        return RRBuilder.buildSuccessBody(this.orderPickupApi.queryById(id));
    }
    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    public ResponseResult<List<OrderPickupResp>> queryPage(@Validated OrderPickupReq orderPickupReq) {
        SearchRequest<OrderPickupReq> requestParam = SRPBuilder.buildRequest(orderPickupReq);
        return RRBuilder.buildBodyByPageResult(this.orderPickupApi.queryByPage(requestParam));
    }

    @Operation(summary = "新增/编辑", description = "新增/编辑")
    @PostMapping("/addOrEdit")
    public ResponseResult<?> addOrEdit(@RequestBody OrderPickupEditReq orderPickupEditReq) {
        ModifyRequest<OrderPickupReq> requestParam = MRPBuilder.buildRequest(orderPickupEditReq,OrderPickupReq.class);
        return RRBuilder.buildBodyByBaseResult(this.orderPickupApi.save(requestParam));
    }

    @Operation(summary = "批量删除", description = "批量删除")
    @PostMapping("/delete")
    public ResponseResult<?> delete(@Validated @RequestBody BatchBasicReq<String> batchBase) {
        List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<OrderPickupReq> requestParam = MRPBuilder.<OrderPickupReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.orderPickupApi.delete(requestParam));
    }

}
