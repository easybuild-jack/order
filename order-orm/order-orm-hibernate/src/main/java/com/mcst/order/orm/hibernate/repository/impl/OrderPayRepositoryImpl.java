package com.mcst.order.orm.hibernate.repository.impl;

import com.mcst.easyfk.service.hibernate.impl.BaseHibernateRepositoryImpl;
import com.mcst.order.api.dto.OrderPayDto;
import com.mcst.order.orm.hibernate.persistence.model.OrderPay;
import com.mcst.order.orm.hibernate.persistence.repository.OrderPayJpaRepository;
import com.mcst.order.orm.repository.IOrderPayRepository;

/**
 * <p>
 * 订单支付 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderPayRepositoryImpl extends BaseHibernateRepositoryImpl<OrderPayJpaRepository, OrderPayDto, OrderPay, String>
        implements IOrderPayRepository {


}
