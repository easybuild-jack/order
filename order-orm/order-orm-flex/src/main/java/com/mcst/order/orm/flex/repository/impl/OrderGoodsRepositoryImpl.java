package com.mcst.order.orm.flex.repository.impl;

import com.mcst.easyfk.service.flex.impl.BaseFlexRepositoryImpl;
import com.mcst.order.api.dto.OrderGoodsDto;
import com.mcst.order.orm.flex.persistence.mapper.OrderGoodsMapper;
import com.mcst.order.orm.flex.persistence.model.OrderGoods;
import com.mcst.order.orm.repository.IOrderGoodsRepository;

/**
 * <p>
 * 订单商品 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderGoodsRepositoryImpl extends BaseFlexRepositoryImpl<OrderGoodsMapper, OrderGoodsDto, OrderGoods, String> implements IOrderGoodsRepository {


}
