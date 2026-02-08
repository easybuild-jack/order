package com.mcst.order.server.service.impl;

import com.mcst.easyfk.core.dto.page.PageResult;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.dto.request.SearchRequest;
import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.core.utils.common.TransformUtil;
import com.mcst.easyfk.repository.util.ConditionUtil;
import com.mcst.easyfk.service.util.ServiceUtil;
import com.mcst.order.api.dto.OrderPickupDto;
import com.mcst.order.api.request.OrderPickupReq;
import com.mcst.order.api.response.OrderPickupResp;
import com.mcst.order.server.repository.IOrderPickupRepository;
import com.mcst.order.server.service.IOrderPickupService;
import jakarta.annotation.Resource;

import java.util.List;

/**
 * <p>
 * 订单提货 服务实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */

public class OrderPickupServiceImpl implements IOrderPickupService {
    @Resource
    private IOrderPickupRepository orderPickupRepository;

    @Override
    public OrderPickupResp queryById(String id, String... selectColumns) {
        return TransformUtil.transformObj(this.orderPickupRepository.queryById(id, selectColumns), OrderPickupResp.class);
    }

    @Override
    public OrderPickupResp queryOneByField(String field, Object value, String... selectColumns) {
        return TransformUtil.transformObj(this.orderPickupRepository.queryOneByField(field, value, selectColumns), OrderPickupResp.class);
    }

    @Override
    public List<OrderPickupResp> queryList(SearchRequest<OrderPickupReq> param) {
        return TransformUtil.transformList(this.orderPickupRepository.queryByCondition(ConditionUtil.conditionByRequest(param)), OrderPickupResp.class);
    }

    @Override
    public OrderPickupResp queryOne(SearchRequest<OrderPickupReq> param) {
        return TransformUtil.transformObj(this.orderPickupRepository.queryOneByCondition(ConditionUtil.conditionByRequest(param)), OrderPickupResp.class);
    }

    @Override
    public long count(SearchRequest<OrderPickupReq> param) {
        return this.orderPickupRepository.countByCondition(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public boolean exists(SearchRequest<OrderPickupReq> param) {
        return this.orderPickupRepository.exists(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public PageResult<OrderPickupResp> queryByPage(SearchRequest<OrderPickupReq> param) {
        return TransformUtil.transformPageResult(this.orderPickupRepository.queryByPage(ConditionUtil.conditionByRequest(param)), OrderPickupResp.class);
    }

    @Override
    public BaseResult<?> save(ModifyRequest<OrderPickupReq> param) {
        return ServiceUtil.save(param, orderPickupRepository, OrderPickupDto.class);
    }

    @Override
    public BaseResult<?> delete(ModifyRequest<OrderPickupReq> param) {
        return ServiceUtil.delete(param, orderPickupRepository, OrderPickupDto.class);
    }

    @Override
    public String insertAndReturnId(OrderPickupReq param) {
        return ServiceUtil.insertAndReturnId(param, orderPickupRepository, OrderPickupDto.class);
    }

}
