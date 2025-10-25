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
import com.mcst.easyfk.authority.annotation.AuthResource;
import com.mcst.easyfk.authority.annotation.ResourceController;
import com.mcst.easyfk.authority.enums.ResourceCategory;
import com.mcst.easyfk.core.utils.common.EmptyUtil;
import com.mcst.easyfk.core.dto.request.DisableFieldReq;
import com.mcst.easyfk.core.utils.common.DisableUtil;
import com.mcst.easyfk.core.dto.request.DisableActionParam;


/**
* 提货点信息相关接口
* @author liu yijun
* @since 2025-10-17
*/
@Tag(name = "提货点信息相关接口", description = "提货点信息相关接口")
@RestController
@RequestMapping("/api/bms/order/location")
@ResourceController(group = "orderManager", id = "orderManager", name = "订单管理", sort = 71000, path = "/order")
public class PickupLocationBmsController {
    @Resource
    private IPickupLocationApi pickupLocationApi;

    @Operation(summary = "详情")
    @GetMapping("/detail")
    public ResponseResult<PickupLocationResp> detail(String id) {
        return RRBuilder.buildSuccessBody(this.pickupLocationApi.queryById(id));
    }

    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/queryPage")
    @AuthResource(id = "pickupLocationManage", name = "提货点管理", pId = "orderManager", pName = "订单管理", sort = 10200, path = "/order/location",
        category = ResourceCategory.menu)
    public ResponseResult<List<PickupLocationResp>> queryPage(@Validated PickupLocationReq pickupLocationReq) {
        SRPBuilder<PickupLocationReq> builder = SRPBuilder.<PickupLocationReq>builder().example(pickupLocationReq);
        return RRBuilder.buildBodyByPageResult(this.pickupLocationApi.queryByPage(builder.build()));
    }

    @Operation(summary = "新增/编辑", description = "新增/编辑")
    @PostMapping("/addOrEdit")
    @AuthResource(id = "pickupLocationAddOrEdit", name = "新增/编辑", title = "新增/编辑", pId = "pickupLocationManage", pName = "提货点管理", sort = 10201, category = ResourceCategory.action,
        actionCode = "addOrEdit")
    public ResponseResult<?> addOrEdit(@RequestBody PickupLocationEditReq pickupLocationEditReq) {
        ModifyRequest<PickupLocationReq> requestParam = MRPBuilder.buildRequest(pickupLocationEditReq, PickupLocationReq.class);
        return RRBuilder.buildBodyByBaseResult(this.pickupLocationApi.save(requestParam));
    }

    @Operation(summary = "批量删除", description = "批量删除")
    @PostMapping("/delete")
    @AuthResource(id = "pickupLocationDelete", name = "删除", title = "删除", pId = "pickupLocationManage", pName = "提货点管理", sort = 10202, category = ResourceCategory.action,
        actionCode = "delete")
    public ResponseResult<?> delete(@Validated @RequestBody BatchBasicReq<String> batchBase) {
        List<String> idArray = SplitUtil.split(batchBase.getIds());
        ModifyRequest<PickupLocationReq> requestParam = MRPBuilder.<PickupLocationReq>builder().ids(idArray).build();
        return RRBuilder.buildBodyByBaseResult(this.pickupLocationApi.delete(requestParam));
    }

    @Operation(summary = "启用/禁用")
    @PostMapping("/disable")
    @AuthResource(id = "pickupLocationDisable", name = "启用/禁用", title = "启用/禁用", pId = "pickupLocationManage", pName = "提货点管理", sort = 10203, category = ResourceCategory.action,
       actionCode = "disable")
    public ResponseResult<?> disable(@RequestBody @Validated DisableFieldReq disableFieldVO) {
       DisableActionParam<PickupLocationReq> disableActionParam =
            new DisableActionParam<PickupLocationReq>(disableFieldVO).setIdField(PickupLocationReq::getPickupLocationId).setValueField(PickupLocationReq::getForbiddenFlag).setTClass(PickupLocationReq.class);
        List<PickupLocationReq> list = DisableUtil.createObjListByDisableAction(disableActionParam);
        if (EmptyUtil.isEmpty(list)) {
          return RRBuilder.buildFailedBody("参数错误");
        }
        ModifyRequest<PickupLocationReq> requestParam = MRPBuilder.<PickupLocationReq>builder().paramList(list).build();
        return RRBuilder.buildBodyByBaseResult(this.pickupLocationApi.save(requestParam));
    }
}
