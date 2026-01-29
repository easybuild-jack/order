package com.mcst.order.server.service.impl;

import com.mcst.order.api.response.OrderContainerResp;
import com.mcst.order.api.request.OrderContainerReq;
import com.mcst.order.api.dto.OrderContainerDto;
import com.mcst.order.server.service.IOrderContainerService;
import com.mcst.order.server.repository.IOrderContainerRepository;
import com.mcst.easyfk.core.dto.page.PageResult;
import com.mcst.easyfk.core.dto.request.SearchRequest;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.repository.util.ConditionUtil;
import java.util.List;
import jakarta.annotation.Resource;
import com.mcst.easyfk.service.util.ServiceUtil;
import com.mcst.easyfk.core.utils.common.TransformUtil;
/**
* <p>
* 订单信息 服务实现类
* </p>
*
* @author liu yijun
* @since 2026-01-29
*/

public class OrderContainerServiceImpl  implements IOrderContainerService {
    @Resource
    private IOrderContainerRepository orderContainerRepository;

    @Override
    public OrderContainerResp queryById(String id, String... selectColumns) {
        return TransformUtil.transformObj(this.orderContainerRepository.queryById(id, selectColumns), OrderContainerResp.class);
    }

    @Override
    public OrderContainerResp queryOneByField(String field, Object value, String... selectColumns) {
        return TransformUtil.transformObj(this.orderContainerRepository.queryOneByField(field, value, selectColumns), OrderContainerResp.class);
    }

    @Override
    public List<OrderContainerResp> queryList(SearchRequest<OrderContainerReq> param) {
        return TransformUtil.transformList(this.orderContainerRepository.queryByCondition(ConditionUtil.conditionByRequest(param)), OrderContainerResp.class);
    }

    @Override
    public OrderContainerResp queryOne(SearchRequest<OrderContainerReq> param) {
        return TransformUtil.transformObj(this.orderContainerRepository.queryOneByCondition(ConditionUtil.conditionByRequest(param)), OrderContainerResp.class);
    }

    @Override
    public long count(SearchRequest<OrderContainerReq> param) {
        return this.orderContainerRepository.countByCondition(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public boolean exists(SearchRequest<OrderContainerReq> param) {
        return this.orderContainerRepository.exists(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public PageResult<OrderContainerResp> queryByPage(SearchRequest<OrderContainerReq> param) {
        return TransformUtil.transformPageResult(this.orderContainerRepository.queryByPage(ConditionUtil.conditionByRequest(param)),OrderContainerResp.class);
    }

    @Override
    public BaseResult<?> save(ModifyRequest<OrderContainerReq> param) {
        return ServiceUtil.save(param, orderContainerRepository, OrderContainerDto.class);
    }

    @Override
    public BaseResult<?> delete(ModifyRequest<OrderContainerReq> param) {
        return ServiceUtil.delete(param, orderContainerRepository, OrderContainerDto.class);
    }

    @Override
    public String insertAndReturnId(OrderContainerReq param) {
        return ServiceUtil.insertAndReturnId(param, orderContainerRepository, OrderContainerDto.class);
    }

    @Override
    public BaseResult<?> batchDelivery(ModifyRequest<OrderContainerReq> param) {
        return null;
    }
}
