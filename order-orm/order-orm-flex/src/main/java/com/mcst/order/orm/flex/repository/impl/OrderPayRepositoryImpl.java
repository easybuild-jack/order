package com.mcst.order.orm.flex.repository.impl;

import com.mcst.easyfk.service.flex.impl.BaseFlexRepositoryImpl;
import com.mcst.order.api.dto.OrderPayDto;
import com.mcst.order.orm.flex.persistence.mapper.OrderPayMapper;
import com.mcst.order.orm.flex.persistence.model.OrderPay;
import com.mcst.order.orm.repository.IOrderPayRepository;

/**
 * <p>
 * 订单支付 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderPayRepositoryImpl extends BaseFlexRepositoryImpl<OrderPayMapper, OrderPayDto, OrderPay, String> implements IOrderPayRepository {


}
