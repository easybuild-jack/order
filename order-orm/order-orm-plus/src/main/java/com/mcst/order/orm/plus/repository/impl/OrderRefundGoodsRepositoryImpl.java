package com.mcst.order.orm.plus.repository.impl;

import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.order.api.dto.OrderRefundGoodsDto;
import com.mcst.order.orm.plus.persistence.mapper.OrderRefundGoodsMapper;
import com.mcst.order.orm.plus.persistence.model.OrderRefundGoods;
import com.mcst.order.orm.repository.IOrderRefundGoodsRepository;

/**
 * <p>
 * 订单退款商品 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderRefundGoodsRepositoryImpl extends BaseMyBatisRepositoryImpl<OrderRefundGoodsMapper, OrderRefundGoodsDto, OrderRefundGoods, String> implements IOrderRefundGoodsRepository {


}
