package com.mcst.order.orm.hibernate.repository.impl;

import com.mcst.easyfk.service.hibernate.impl.BaseHibernateRepositoryImpl;
import com.mcst.order.api.dto.OrderRefundGoodsDto;
import com.mcst.order.orm.hibernate.persistence.model.OrderRefundGoods;
import com.mcst.order.orm.hibernate.persistence.repository.OrderRefundGoodsJpaRepository;
import com.mcst.order.orm.repository.IOrderRefundGoodsRepository;

/**
 * <p>
 * 订单退款商品 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderRefundGoodsRepositoryImpl extends BaseHibernateRepositoryImpl<OrderRefundGoodsJpaRepository, OrderRefundGoodsDto, OrderRefundGoods, String>
        implements IOrderRefundGoodsRepository {


}
