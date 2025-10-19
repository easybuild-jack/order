package com.mcst.order.server.service.impl;

import com.mcst.order.api.response.OrderRefundResp;
import com.mcst.order.api.request.OrderRefundReq;
import com.mcst.order.api.dto.OrderRefundDto;
import com.mcst.order.server.service.IOrderRefundService;
import com.mcst.order.server.repository.IOrderRefundRepository;
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
* 订单退款 服务实现类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/

public class OrderRefundServiceImpl  implements IOrderRefundService {
    @Resource
    private IOrderRefundRepository orderRefundRepository;

    @Override
    public OrderRefundResp queryById(String id, String... selectColumns) {
        return TransformUtil.transformObj(this.orderRefundRepository.queryById(id, selectColumns), OrderRefundResp.class);
    }

    @Override
    public OrderRefundResp queryOneByField(String field, Object value, String... selectColumns) {
        return TransformUtil.transformObj(this.orderRefundRepository.queryOneByField(field, value, selectColumns), OrderRefundResp.class);
    }

    @Override
    public List<OrderRefundResp> queryList(SearchRequest<OrderRefundReq> param) {
        return TransformUtil.transformListByStream(this.orderRefundRepository.queryByCondition(ConditionUtil.conditionByRequest(param)), OrderRefundResp.class);
    }

    @Override
    public OrderRefundResp queryOne(SearchRequest<OrderRefundReq> param) {
        return TransformUtil.transformObj(this.orderRefundRepository.queryOneByCondition(ConditionUtil.conditionByRequest(param)), OrderRefundResp.class);
    }

    @Override
    public long count(SearchRequest<OrderRefundReq> param) {
        return this.orderRefundRepository.countByCondition(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public boolean exists(SearchRequest<OrderRefundReq> param) {
        return this.orderRefundRepository.exists(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public PageResult<OrderRefundResp> queryByPage(SearchRequest<OrderRefundReq> param) {
        return TransformUtil.transformPageResult(this.orderRefundRepository.queryByPage(ConditionUtil.conditionByRequest(param)),OrderRefundResp.class);
    }

    @Override
    public BaseResult<?> save(ModifyRequest<OrderRefundReq> param) {
        return ServiceUtil.save(param, orderRefundRepository, OrderRefundDto.class);
    }

    @Override
    public BaseResult<?> delete(ModifyRequest<OrderRefundReq> param) {
        return ServiceUtil.delete(param, orderRefundRepository, OrderRefundDto.class);
    }

    @Override
    public String insertAndReturnId(OrderRefundReq param) {
        return ServiceUtil.insertAndReturnId(param, orderRefundRepository, OrderRefundDto.class);
    }

}
