package com.mcst.order.orm.hibernate.repository.impl;

import com.mcst.easyfk.service.hibernate.impl.BaseHibernateRepositoryImpl;
import com.mcst.order.api.dto.OrderInfoDto;
import com.mcst.order.orm.hibernate.persistence.model.OrderInfo;
import com.mcst.order.orm.hibernate.persistence.repository.OrderInfoJpaRepository;
import com.mcst.order.orm.repository.IOrderInfoRepository;

/**
 * <p>
 * 订单信息 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderInfoRepositoryImpl extends BaseHibernateRepositoryImpl<OrderInfoJpaRepository, OrderInfoDto, OrderInfo, String>
        implements IOrderInfoRepository {


}
