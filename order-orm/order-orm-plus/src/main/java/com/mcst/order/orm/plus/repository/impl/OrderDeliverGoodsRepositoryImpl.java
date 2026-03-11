package com.mcst.order.orm.plus.repository.impl;

import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.order.api.dto.OrderDeliverGoodsDto;
import com.mcst.order.orm.plus.persistence.mapper.OrderDeliverGoodsMapper;
import com.mcst.order.orm.plus.persistence.model.OrderDeliverGoods;
import com.mcst.order.orm.repository.IOrderDeliverGoodsRepository;

/**
 * <p>
 * 订单发货商品 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderDeliverGoodsRepositoryImpl extends BaseMyBatisRepositoryImpl<OrderDeliverGoodsMapper, OrderDeliverGoodsDto, OrderDeliverGoods, String> implements IOrderDeliverGoodsRepository {


}
