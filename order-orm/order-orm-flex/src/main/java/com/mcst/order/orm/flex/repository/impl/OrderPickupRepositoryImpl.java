package com.mcst.order.orm.flex.repository.impl;

import com.mcst.easyfk.service.flex.impl.BaseFlexRepositoryImpl;
import com.mcst.order.api.dto.OrderPickupDto;
import com.mcst.order.orm.flex.persistence.mapper.OrderPickupMapper;
import com.mcst.order.orm.flex.persistence.model.OrderPickup;
import com.mcst.order.orm.repository.IOrderPickupRepository;

/**
 * <p>
 * 订单提货 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderPickupRepositoryImpl extends BaseFlexRepositoryImpl<OrderPickupMapper, OrderPickupDto, OrderPickup, String> implements IOrderPickupRepository {


}
