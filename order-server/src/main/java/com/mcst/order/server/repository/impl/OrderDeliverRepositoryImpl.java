package com.mcst.order.server.repository.impl;

import com.mcst.order.api.dto.OrderDeliverDto;
import com.mcst.order.server.repository.IOrderDeliverRepository;
import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.order.server.persistence.mapper.OrderDeliverMapper;
import com.mcst.order.server.persistence.model.OrderDeliver;
/**
* <p>
* 订单发货 Repository实现类
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
public class OrderDeliverRepositoryImpl extends BaseMyBatisRepositoryImpl<OrderDeliverMapper,OrderDeliverDto, OrderDeliver,String> implements IOrderDeliverRepository {


}