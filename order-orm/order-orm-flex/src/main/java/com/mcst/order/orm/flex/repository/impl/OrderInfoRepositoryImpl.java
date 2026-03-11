package com.mcst.order.orm.flex.repository.impl;

import com.mcst.easyfk.service.flex.impl.BaseFlexRepositoryImpl;
import com.mcst.order.api.dto.OrderInfoDto;
import com.mcst.order.orm.flex.persistence.mapper.OrderInfoMapper;
import com.mcst.order.orm.flex.persistence.model.OrderInfo;
import com.mcst.order.orm.repository.IOrderInfoRepository;

/**
 * <p>
 * 订单信息 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderInfoRepositoryImpl extends BaseFlexRepositoryImpl<OrderInfoMapper, OrderInfoDto, OrderInfo, String> implements IOrderInfoRepository {


}
