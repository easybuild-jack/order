package com.mcst.order.orm.hibernate.repository.impl;

import com.mcst.easyfk.service.hibernate.impl.BaseHibernateRepositoryImpl;
import com.mcst.order.api.dto.OrderContainerDto;
import com.mcst.order.orm.hibernate.persistence.model.OrderContainer;
import com.mcst.order.orm.hibernate.persistence.repository.OrderContainerJpaRepository;
import com.mcst.order.orm.repository.IOrderContainerRepository;

/**
 * <p>
 * 订单货柜信息 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-29
 */
public class OrderContainerRepositoryImpl extends BaseHibernateRepositoryImpl<OrderContainerJpaRepository, OrderContainerDto, OrderContainer, String>
        implements IOrderContainerRepository {


}
