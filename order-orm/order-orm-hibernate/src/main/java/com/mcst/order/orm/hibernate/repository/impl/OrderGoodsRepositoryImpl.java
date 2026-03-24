package com.mcst.order.orm.hibernate.repository.impl;

import com.mcst.easyfk.service.hibernate.impl.BaseHibernateRepositoryImpl;
import com.mcst.order.api.dto.OrderGoodsDto;
import com.mcst.order.orm.hibernate.persistence.model.OrderGoods;
import com.mcst.order.orm.hibernate.persistence.mapper.OrderGoodsMapper;
import com.mcst.order.orm.repository.IOrderGoodsRepository;

/**
 * <p>
 * 订单商品 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderGoodsRepositoryImpl extends BaseHibernateRepositoryImpl<OrderGoodsMapper, OrderGoodsDto, OrderGoods, String>
        implements IOrderGoodsRepository {


}
