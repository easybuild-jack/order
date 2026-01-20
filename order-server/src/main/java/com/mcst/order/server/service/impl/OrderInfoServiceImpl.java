package com.mcst.order.server.service.impl;

import com.mcst.easyfk.core.dto.login.UserData;
import com.mcst.easyfk.core.dto.page.PageResult;
import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.dto.request.SearchRequest;
import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.core.utils.common.TransformUtil;
import com.mcst.easyfk.repository.util.ConditionUtil;
import com.mcst.easyfk.service.util.ServiceUtil;
import com.mcst.easyfk.service.util.UserDataFiltrationUtil;
import com.mcst.order.api.dto.OrderInfoDto;
import com.mcst.order.api.request.OrderInfoReq;
import com.mcst.order.api.response.OrderInfoResp;
import com.mcst.order.server.repository.IOrderInfoRepository;
import com.mcst.order.server.service.IOrderInfoService;
import jakarta.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */

public class OrderInfoServiceImpl implements IOrderInfoService {
    @Resource
    private IOrderInfoRepository orderInfoRepository;

    @Override
    public OrderInfoResp queryById(String id, String... selectColumns) {
        return TransformUtil.transformObj(this.orderInfoRepository.queryById(id, selectColumns), OrderInfoResp.class);
    }

    @Override
    public OrderInfoResp queryOneByField(String field, Object value, String... selectColumns) {
        return TransformUtil.transformObj(this.orderInfoRepository.queryOneByField(field, value, selectColumns), OrderInfoResp.class);
    }

    @Override
    public List<OrderInfoResp> queryList(SearchRequest<OrderInfoReq> param) {
        UserDataFiltrationUtil.saasDataFiltration(param, OrderInfoReq.class, Map.of(OrderInfoReq::getAgentId, UserData::getAgentId, OrderInfoReq::getMerchantId, UserData::getMerchantId));
        return TransformUtil.transformList(this.orderInfoRepository.queryByCondition(ConditionUtil.conditionByRequest(param)), OrderInfoResp.class);
    }

    @Override
    public OrderInfoResp queryOne(SearchRequest<OrderInfoReq> param) {
        UserDataFiltrationUtil.saasDataFiltration(param, OrderInfoReq.class, Map.of(OrderInfoReq::getAgentId, UserData::getAgentId, OrderInfoReq::getMerchantId, UserData::getMerchantId));
        return TransformUtil.transformObj(this.orderInfoRepository.queryOneByCondition(ConditionUtil.conditionByRequest(param)), OrderInfoResp.class);
    }

    @Override
    public long count(SearchRequest<OrderInfoReq> param) {
        UserDataFiltrationUtil.saasDataFiltration(param, OrderInfoReq.class, Map.of(OrderInfoReq::getAgentId, UserData::getAgentId, OrderInfoReq::getMerchantId, UserData::getMerchantId));
        return this.orderInfoRepository.countByCondition(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public boolean exists(SearchRequest<OrderInfoReq> param) {
        UserDataFiltrationUtil.saasDataFiltration(param, OrderInfoReq.class, Map.of(OrderInfoReq::getAgentId, UserData::getAgentId, OrderInfoReq::getMerchantId, UserData::getMerchantId));
        return this.orderInfoRepository.exists(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public PageResult<OrderInfoResp> queryByPage(SearchRequest<OrderInfoReq> param) {
        UserDataFiltrationUtil.saasDataFiltration(param, OrderInfoReq.class, Map.of(OrderInfoReq::getAgentId, UserData::getAgentId, OrderInfoReq::getMerchantId, UserData::getMerchantId));
        return TransformUtil.transformPageResult(this.orderInfoRepository.queryByPage(ConditionUtil.conditionByRequest(param)), OrderInfoResp.class);
    }

    @Override
    public BaseResult<?> save(ModifyRequest<OrderInfoReq> param) {
        UserDataFiltrationUtil.setSaasData(param, Map.of(OrderInfoReq::getAgentId, UserData::getAgentId, OrderInfoReq::getAgentName, UserData::getAgentName, OrderInfoReq::getMerchantId, UserData::getMerchantId, OrderInfoReq::getMerchantName, UserData::getMerchantName));
        return ServiceUtil.save(param, orderInfoRepository, OrderInfoDto.class);
    }

    @Override
    public BaseResult<?> delete(ModifyRequest<OrderInfoReq> param) {
        return ServiceUtil.delete(param, orderInfoRepository, OrderInfoDto.class);
    }

    @Override
    public String insertAndReturnId(OrderInfoReq param) {
        return ServiceUtil.insertAndReturnId(param, orderInfoRepository, OrderInfoDto.class);
    }

}
