package com.mcst.order.orm.hibernate.repository.impl;

import com.mcst.easyfk.service.hibernate.impl.BaseHibernateRepositoryImpl;
import com.mcst.order.api.dto.OrderRefundDto;
import com.mcst.order.orm.hibernate.persistence.model.OrderRefund;
import com.mcst.order.orm.hibernate.persistence.mapper.OrderRefundMapper;
import com.mcst.order.orm.repository.IOrderRefundRepository;

/**
 * <p>
 * 订单退款 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderRefundRepositoryImpl extends BaseHibernateRepositoryImpl<OrderRefundMapper, OrderRefundDto, OrderRefund, String>
        implements IOrderRefundRepository {


}
