package com.mcst.order.server.repository.impl;

import com.mcst.order.api.dto.OrderDeliverGoodsDto;
import com.mcst.order.server.repository.IOrderDeliverGoodsRepository;
import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.order.server.persistence.mapper.OrderDeliverGoodsMapper;
import com.mcst.order.server.persistence.model.OrderDeliverGoods;
/**
* <p>
* 订单发货商品 Repository实现类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
public class OrderDeliverGoodsRepositoryImpl extends BaseMyBatisRepositoryImpl<OrderDeliverGoodsMapper,OrderDeliverGoodsDto, OrderDeliverGoods,String> implements IOrderDeliverGoodsRepository {


}