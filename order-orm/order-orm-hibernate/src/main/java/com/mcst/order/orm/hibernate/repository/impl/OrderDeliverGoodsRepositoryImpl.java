package com.mcst.order.orm.hibernate.repository.impl;

import com.mcst.easyfk.service.hibernate.impl.BaseHibernateRepositoryImpl;
import com.mcst.order.api.dto.OrderDeliverGoodsDto;
import com.mcst.order.orm.hibernate.persistence.model.OrderDeliverGoods;
import com.mcst.order.orm.hibernate.persistence.repository.OrderDeliverGoodsJpaRepository;
import com.mcst.order.orm.repository.IOrderDeliverGoodsRepository;

/**
 * <p>
 * 订单发货商品 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderDeliverGoodsRepositoryImpl extends BaseHibernateRepositoryImpl<OrderDeliverGoodsJpaRepository, OrderDeliverGoodsDto, OrderDeliverGoods, String>
        implements IOrderDeliverGoodsRepository {


}
