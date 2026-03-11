package com.mcst.order.orm.plus.repository.impl;

import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.order.api.dto.OrderPickupDto;
import com.mcst.order.orm.plus.persistence.mapper.OrderPickupMapper;
import com.mcst.order.orm.plus.persistence.model.OrderPickup;
import com.mcst.order.orm.repository.IOrderPickupRepository;

/**
 * <p>
 * 订单提货 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderPickupRepositoryImpl extends BaseMyBatisRepositoryImpl<OrderPickupMapper, OrderPickupDto, OrderPickup, String> implements IOrderPickupRepository {


}
