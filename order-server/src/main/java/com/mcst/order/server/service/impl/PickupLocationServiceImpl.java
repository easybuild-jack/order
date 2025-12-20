package com.mcst.order.server.service.impl;

import com.mcst.order.api.response.PickupLocationResp;
import com.mcst.order.api.request.PickupLocationReq;
import com.mcst.order.api.dto.PickupLocationDto;
import com.mcst.order.server.service.IPickupLocationService;
import com.mcst.order.server.repository.IPickupLocationRepository;
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
* 提货点信息 服务实现类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/

public class PickupLocationServiceImpl  implements IPickupLocationService {
    @Resource
    private IPickupLocationRepository pickupLocationRepository;

    @Override
    public PickupLocationResp queryById(String id, String... selectColumns) {
        return TransformUtil.transformObj(this.pickupLocationRepository.queryById(id, selectColumns), PickupLocationResp.class);
    }

    @Override
    public PickupLocationResp queryOneByField(String field, Object value, String... selectColumns) {
        return TransformUtil.transformObj(this.pickupLocationRepository.queryOneByField(field, value, selectColumns), PickupLocationResp.class);
    }

    @Override
    public List<PickupLocationResp> queryList(SearchRequest<PickupLocationReq> param) {
        return TransformUtil.transformList(this.pickupLocationRepository.queryByCondition(ConditionUtil.conditionByRequest(param)), PickupLocationResp.class);
    }

    @Override
    public PickupLocationResp queryOne(SearchRequest<PickupLocationReq> param) {
        return TransformUtil.transformObj(this.pickupLocationRepository.queryOneByCondition(ConditionUtil.conditionByRequest(param)), PickupLocationResp.class);
    }

    @Override
    public long count(SearchRequest<PickupLocationReq> param) {
        return this.pickupLocationRepository.countByCondition(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public boolean exists(SearchRequest<PickupLocationReq> param) {
        return this.pickupLocationRepository.exists(ConditionUtil.conditionByRequest(param));
    }

    @Override
    public PageResult<PickupLocationResp> queryByPage(SearchRequest<PickupLocationReq> param) {
        return TransformUtil.transformPageResult(this.pickupLocationRepository.queryByPage(ConditionUtil.conditionByRequest(param)),PickupLocationResp.class);
    }

    @Override
    public BaseResult<?> save(ModifyRequest<PickupLocationReq> param) {
        return ServiceUtil.save(param, pickupLocationRepository, PickupLocationDto.class);
    }

    @Override
    public BaseResult<?> delete(ModifyRequest<PickupLocationReq> param) {
        return ServiceUtil.delete(param, pickupLocationRepository, PickupLocationDto.class);
    }

    @Override
    public String insertAndReturnId(PickupLocationReq param) {
        return ServiceUtil.insertAndReturnId(param, pickupLocationRepository, PickupLocationDto.class);
    }

}
