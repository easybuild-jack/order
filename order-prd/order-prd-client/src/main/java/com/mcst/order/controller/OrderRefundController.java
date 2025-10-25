package com.mcst.order.controller;

import com.mcst.order.api.response.OrderRefundResp;
import com.mcst.order.api.request.OrderRefundReq;
import com.mcst.order.api.request.OrderRefundEditReq;
import com.mcst.order.api.IOrderRefundApi;
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
* 订单退款相关接口
* @author liu yijun
* @since 2025-10-17
*/
@Tag(name = "订单退款相关接口", description = "订单退款相关接口")
@RestController
@RequestMapping("/api/order/refund")
public class OrderRefundController {
    @Resource
    private IOrderRefundApi orderRefundApi;


    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<OrderRefundResp> detail(String id) {
        return RRBuilder.buildSuccessBody(this.orderRefundApi.queryById(id));
    }
    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    public ResponseResult<List<OrderRefundResp>> queryPage(@Validated OrderRefundReq orderRefundReq) {
        SearchRequest<OrderRefundReq> requestParam = SRPBuilder.buildRequest(orderRefundReq);
        return RRBuilder.buildBodyByPageResult(this.orderRefundApi.queryByPage(requestParam));
    }

    @Operation(summary = "新增/编辑", description = "新增/编辑")
    @PostMapping("/addOrEdit")
    public ResponseResult<?> addOrEdit(@RequestBody OrderRefundEditReq orderRefundEditReq) {
        ModifyRequest<OrderRefundReq> requestParam = MRPBuilder.buildRequest(orderRefundEditReq,OrderRefundReq.class);
        return RRBuilder.buildBodyByBaseResult(this.orderRefundApi.save(requestParam));
    }

    @Operation(summary = "批量删除", description = "批量删除")
    @PostMapping("/delete")
    public ResponseResult<?> delete(@Validated @RequestBody BatchBasicReq<String> batchBase) {
        List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<OrderRefundReq> requestParam = MRPBuilder.<OrderRefundReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.orderRefundApi.delete(requestParam));
    }

}
