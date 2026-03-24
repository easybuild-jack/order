package com.mcst.order.orm.hibernate.repository.impl;

import com.mcst.easyfk.service.hibernate.impl.BaseHibernateRepositoryImpl;
import com.mcst.order.api.dto.OrderDeliverDto;
import com.mcst.order.orm.hibernate.persistence.model.OrderDeliver;
import com.mcst.order.orm.hibernate.persistence.mapper.OrderDeliverMapper;
import com.mcst.order.orm.repository.IOrderDeliverRepository;

/**
 * <p>
 * 订单发货 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderDeliverRepositoryImpl extends BaseHibernateRepositoryImpl<OrderDeliverMapper, OrderDeliverDto, OrderDeliver, String>
        implements IOrderDeliverRepository {


}
