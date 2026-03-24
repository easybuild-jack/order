package com.mcst.order.orm.hibernate.repository.impl;

import com.mcst.easyfk.service.hibernate.impl.BaseHibernateRepositoryImpl;
import com.mcst.order.api.dto.OrderAmountDto;
import com.mcst.order.orm.hibernate.persistence.model.OrderAmount;
import com.mcst.order.orm.hibernate.persistence.mapper.OrderAmountMapper;
import com.mcst.order.orm.repository.IOrderAmountRepository;

/**
 * <p>
 * 订单金额 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderAmountRepositoryImpl extends BaseHibernateRepositoryImpl<OrderAmountMapper, OrderAmountDto, OrderAmount, String>
        implements IOrderAmountRepository {


}
