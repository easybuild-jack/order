package com.mcst.order.server.repository.impl;

import com.mcst.order.api.dto.OrderRefundGoodsDto;
import com.mcst.order.server.repository.IOrderRefundGoodsRepository;
import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.order.server.persistence.mapper.OrderRefundGoodsMapper;
import com.mcst.order.server.persistence.model.OrderRefundGoods;
/**
* <p>
* 订单退款商品 Repository实现类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
public class OrderRefundGoodsRepositoryImpl extends BaseMyBatisRepositoryImpl<OrderRefundGoodsMapper,OrderRefundGoodsDto, OrderRefundGoods,String> implements IOrderRefundGoodsRepository {


}