package com.mcst.order.server.repository.impl;

import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.order.api.dto.OrderPayDto;
import com.mcst.order.server.persistence.mapper.OrderPayMapper;
import com.mcst.order.server.persistence.model.OrderPay;
import com.mcst.order.server.repository.IOrderPayRepository;

/**
 * <p>
 * 订单支付 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderPayRepositoryImpl extends BaseMyBatisRepositoryImpl<OrderPayMapper, OrderPayDto, OrderPay, String> implements IOrderPayRepository {


}