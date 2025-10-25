package com.mcst.order.controller;

import com.mcst.order.api.response.PickupLocationResp;
import com.mcst.order.api.request.PickupLocationReq;
import com.mcst.order.api.request.PickupLocationEditReq;
import com.mcst.order.api.IPickupLocationApi;
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
* 提货点信息相关接口
* @author liu yijun
* @since 2025-10-17
*/
@Tag(name = "提货点信息相关接口", description = "提货点信息相关接口")
@RestController
@RequestMapping("/api/order/location")
public class PickupLocationController {
    @Resource
    private IPickupLocationApi pickupLocationApi;


    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<PickupLocationResp> detail(String id) {
        return RRBuilder.buildSuccessBody(this.pickupLocationApi.queryById(id));
    }
    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    public ResponseResult<List<PickupLocationResp>> queryPage(@Validated PickupLocationReq pickupLocationReq) {
        SearchRequest<PickupLocationReq> requestParam = SRPBuilder.buildRequest(pickupLocationReq);
        return RRBuilder.buildBodyByPageResult(this.pickupLocationApi.queryByPage(requestParam));
    }

    @Operation(summary = "新增/编辑", description = "新增/编辑")
    @PostMapping("/addOrEdit")
    public ResponseResult<?> addOrEdit(@RequestBody PickupLocationEditReq pickupLocationEditReq) {
        ModifyRequest<PickupLocationReq> requestParam = MRPBuilder.buildRequest(pickupLocationEditReq,PickupLocationReq.class);
        return RRBuilder.buildBodyByBaseResult(this.pickupLocationApi.save(requestParam));
    }

    @Operation(summary = "批量删除", description = "批量删除")
    @PostMapping("/delete")
    public ResponseResult<?> delete(@Validated @RequestBody BatchBasicReq<String> batchBase) {
        List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<PickupLocationReq> requestParam = MRPBuilder.<PickupLocationReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.pickupLocationApi.delete(requestParam));
    }

}
