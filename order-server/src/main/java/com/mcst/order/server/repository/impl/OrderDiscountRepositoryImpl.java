package com.mcst.order.server.repository.impl;

import com.mcst.order.api.dto.OrderDiscountDto;
import com.mcst.order.server.repository.IOrderDiscountRepository;
import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.order.server.persistence.mapper.OrderDiscountMapper;
import com.mcst.order.server.persistence.model.OrderDiscount;
/**
* <p>
* 订单优惠 Repository实现类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
public class OrderDiscountRepositoryImpl extends BaseMyBatisRepositoryImpl<OrderDiscountMapper,OrderDiscountDto, OrderDiscount,String> implements IOrderDiscountRepository {


}