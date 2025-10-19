package com.mcst.order.server.repository.impl;

import com.mcst.order.api.dto.PickupLocationDto;
import com.mcst.order.server.repository.IPickupLocationRepository;
import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.order.server.persistence.mapper.PickupLocationMapper;
import com.mcst.order.server.persistence.model.PickupLocation;
/**
* <p>
* 提货点信息 Repository实现类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
public class PickupLocationRepositoryImpl extends BaseMyBatisRepositoryImpl<PickupLocationMapper,PickupLocationDto, PickupLocation,String> implements IPickupLocationRepository {


}