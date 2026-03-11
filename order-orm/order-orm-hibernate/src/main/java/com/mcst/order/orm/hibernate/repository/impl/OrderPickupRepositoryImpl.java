package com.mcst.order.orm.hibernate.repository.impl;

import com.mcst.easyfk.service.hibernate.impl.BaseHibernateRepositoryImpl;
import com.mcst.order.api.dto.OrderPickupDto;
import com.mcst.order.orm.hibernate.persistence.model.OrderPickup;
import com.mcst.order.orm.hibernate.persistence.repository.OrderPickupJpaRepository;
import com.mcst.order.orm.repository.IOrderPickupRepository;

/**
 * <p>
 * 订单提货 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderPickupRepositoryImpl extends BaseHibernateRepositoryImpl<OrderPickupJpaRepository, OrderPickupDto, OrderPickup, String>
        implements IOrderPickupRepository {


}
