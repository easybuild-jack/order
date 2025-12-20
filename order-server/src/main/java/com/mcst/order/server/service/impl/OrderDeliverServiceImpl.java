package com.mcst.order.server.service.impl;

import com.mcst.order.api.response.OrderDeliverResp;
import com.mcst.order.api.request.OrderDeliverReq;
import com.mcst.order.api.dto.OrderDeliverDto;
import com.mcst.order.server.service.IOrderDeliverService;
import com.mcst.order.server.repository.IOrderDeliverRepository;
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
* 订单发货 服务实现类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/

public class OrderDeliverServiceImpl  implements IOrderDeliverService {
    @Resource
    private IOrderDeliverRepository orderDeliverRepository;

    @Override
    public OrderDeliverResp queryById(String id, String... selectColumns) {
        return TransformUtil.transformObj(this.orderDeliverRepository.queryById(id, selectColumns), OrderDeliverResp.class);
    }

    @Override
    public OrderDeliverResp queryOneByField(String field, Object value, String... selectColumns) {
        return TransformUtil.transformObj(this.orderDeliverRepository.queryOneByField(field, value, selectColumns), OrderDeliverResp.class);
    }

    @Override
    public List<OrderDeliverResp> queryList(SearchRequest<OrderDeliverReq> param) {
        return TransformUtil.transformList(this.orderDeliverRepository.queryByCondition(ConditionUtil.conditionByRequest(param)), OrderDeliverResp.class);
    }

    @Override
    public OrderDeliverResp queryOne(SearchRequest<OrderDeliverReq> param) {
        return TransformUtil.transformObj(this.orderDeliverRepository.queryOneByCondition(ConditionUtil.conditionByRequest(param)), OrderDeliverResp.class);
    }

    @Override
    public long count(SearchRequest<OrderDeliverReq> param) {
        return this.orderDeliverRepository.countByCondition(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public boolean exists(SearchRequest<OrderDeliverReq> param) {
        return this.orderDeliverRepository.exists(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public PageResult<OrderDeliverResp> queryByPage(SearchRequest<OrderDeliverReq> param) {
        return TransformUtil.transformPageResult(this.orderDeliverRepository.queryByPage(ConditionUtil.conditionByRequest(param)),OrderDeliverResp.class);
    }

    @Override
    public BaseResult<?> save(ModifyRequest<OrderDeliverReq> param) {
        return ServiceUtil.save(param, orderDeliverRepository, OrderDeliverDto.class);
    }

    @Override
    public BaseResult<?> delete(ModifyRequest<OrderDeliverReq> param) {
        return ServiceUtil.delete(param, orderDeliverRepository, OrderDeliverDto.class);
    }

    @Override
    public String insertAndReturnId(OrderDeliverReq param) {
        return ServiceUtil.insertAndReturnId(param, orderDeliverRepository, OrderDeliverDto.class);
    }

}
