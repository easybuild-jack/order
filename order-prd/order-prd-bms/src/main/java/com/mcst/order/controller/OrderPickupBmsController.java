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
import com.mcst.easyfk.authority.annotation.AuthResource;
import com.mcst.easyfk.authority.annotation.ResourceController;
import com.mcst.easyfk.authority.enums.ResourceCategory;


/**
* 订单提货相关接口
* @author liu yijun
* @since 2025-10-17
*/
@Tag(name = "订单提货相关接口", description = "订单提货相关接口")
@ResponseBody
@RequestMapping("/api/bms/order/pickup")
//@ResourceController(group = "orderManage", id = "orderManage", name = "订单管理", sort = 71000, path = "/order")
public class OrderPickupBmsController {
    @Resource
    private IOrderPickupApi orderPickupApi;

    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<OrderPickupResp> detail(String id) {
        return RRBuilder.buildSuccessBody(this.orderPickupApi.queryById(id));
    }

    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    @AuthResource(id = "orderPickupManage", name = "提货管理", pId = "orderManage", pName = "订单管理", sort = 10100, path = "/order/pickup",
        category = ResourceCategory.menu)
    public ResponseResult<List<OrderPickupResp>> queryPage(@Validated OrderPickupReq orderPickupReq) {
        SRPBuilder<OrderPickupReq> builder = SRPBuilder.<OrderPickupReq>builder().example(orderPickupReq);
        return RRBuilder.buildBodyByPageResult(this.orderPickupApi.queryByPage(builder.build()));
    }

    @Operation(summary = "新增/编辑", description = "新增/编辑")
    @PostMapping("/addOrEdit")
    @AuthResource(id = "orderPickupAddOrEdit", name = "新增/编辑", title = "新增/编辑", pId = "orderPickupManage", pName = "提货管理", sort = 10101, category = ResourceCategory.action,
        actionCode = "addOrEdit")
    public ResponseResult<?> addOrEdit(@RequestBody OrderPickupEditReq orderPickupEditReq) {
        ModifyRequest<OrderPickupReq> requestParam = MRPBuilder.buildRequest(orderPickupEditReq, OrderPickupReq.class);
        return RRBuilder.buildBodyByBaseResult(this.orderPickupApi.save(requestParam));
    }

    @Operation(summary = "批量删除", description = "批量删除")
    @PostMapping("/delete")
    @AuthResource(id = "orderPickupDelete", name = "删除", title = "删除", pId = "orderPickupManage", pName = "提货管理", sort = 10102, category = ResourceCategory.action,
        actionCode = "delete")
    public ResponseResult<?> delete(@Validated @RequestBody BatchBasicReq<String> batchBase) {
        List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<OrderPickupReq> requestParam = MRPBuilder.<OrderPickupReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.orderPickupApi.delete(requestParam));
    }

}
