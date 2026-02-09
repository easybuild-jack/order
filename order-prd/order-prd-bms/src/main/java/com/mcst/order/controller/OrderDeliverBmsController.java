package com.mcst.order.controller;

import com.mcst.easyfk.authority.annotation.AuthResource;
import com.mcst.easyfk.authority.enums.ResourceCategory;
import com.mcst.easyfk.core.builders.MRPBuilder;
import com.mcst.easyfk.core.builders.RRBuilder;
import com.mcst.easyfk.core.builders.SRPBuilder;
import com.mcst.easyfk.core.dto.request.BatchBasicReq;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.dto.response.ResponseResult;
import com.mcst.easyfk.core.utils.common.SplitUtil;
import com.mcst.order.api.IOrderDeliverApi;
import com.mcst.order.api.request.OrderDeliverEditReq;
import com.mcst.order.api.request.OrderDeliverReq;
import com.mcst.order.api.response.OrderDeliverResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 订单发货相关接口
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Tag(name = "订单发货相关接口", description = "订单发货相关接口")
@RestController
@RequestMapping("/api/bms/order/deliver")
//@ResourceController(group = "orderManage", id = "orderManage", name = "订单管理", sort = 71000, path = "/order")
public class OrderDeliverBmsController {
    @Resource
    private IOrderDeliverApi orderDeliverApi;

    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<OrderDeliverResp> detail(String id) {
        return RRBuilder.buildSuccessBody(this.orderDeliverApi.queryById(id));
    }

    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    @AuthResource(id = "orderDeliverManage", name = "发货管理", pId = "orderManage", pName = "订单管理", sort = 10500, path = "/order/deliver",
            category = ResourceCategory.menu)
    public ResponseResult<List<OrderDeliverResp>> queryPage(@Validated OrderDeliverReq orderDeliverReq) {
        SRPBuilder<OrderDeliverReq> builder = SRPBuilder.<OrderDeliverReq>builder().example(orderDeliverReq);
        return RRBuilder.buildBodyByPageResult(this.orderDeliverApi.queryByPage(builder.build()));
    }

    @Operation(summary = "新增/编辑", description = "新增/编辑")
    @PostMapping("/addOrEdit")
    @AuthResource(id = "orderDeliverAddOrEdit", name = "新增/编辑", title = "新增/编辑", pId = "orderDeliverManage", pName = "发货管理", sort = 10501, category = ResourceCategory.action,
            actionCode = "addOrEdit")
    public ResponseResult<?> addOrEdit(@RequestBody OrderDeliverEditReq orderDeliverEditReq) {
        ModifyRequest<OrderDeliverReq> requestParam = MRPBuilder.buildRequest(orderDeliverEditReq, OrderDeliverReq.class);
        return RRBuilder.buildBodyByBaseResult(this.orderDeliverApi.save(requestParam));
    }

    @Operation(summary = "批量删除", description = "批量删除")
    @PostMapping("/delete")
    @AuthResource(id = "orderDeliverDelete", name = "删除", title = "删除", pId = "orderDeliverManage", pName = "发货管理", sort = 10502, category = ResourceCategory.action,
            actionCode = "delete")
    public ResponseResult<?> delete(@Validated @RequestBody BatchBasicReq<String> batchBase) {
        List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<OrderDeliverReq> requestParam = MRPBuilder.<OrderDeliverReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.orderDeliverApi.delete(requestParam));
    }

}
