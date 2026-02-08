package com.mcst.order.server.repository.impl;

import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.order.api.dto.OrderGoodsDto;
import com.mcst.order.server.persistence.mapper.OrderGoodsMapper;
import com.mcst.order.server.persistence.model.OrderGoods;
import com.mcst.order.server.repository.IOrderGoodsRepository;

/**
 * <p>
 * 订单商品 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderGoodsRepositoryImpl extends BaseMyBatisRepositoryImpl<OrderGoodsMapper, OrderGoodsDto, OrderGoods, String> implements IOrderGoodsRepository {


}