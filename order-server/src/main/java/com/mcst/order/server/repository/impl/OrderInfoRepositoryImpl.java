package com.mcst.order.server.repository.impl;

import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.order.api.dto.OrderInfoDto;
import com.mcst.order.server.persistence.mapper.OrderInfoMapper;
import com.mcst.order.server.persistence.model.OrderInfo;
import com.mcst.order.server.repository.IOrderInfoRepository;

/**
 * <p>
 * 订单信息 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderInfoRepositoryImpl extends BaseMyBatisRepositoryImpl<OrderInfoMapper, OrderInfoDto, OrderInfo, String> implements IOrderInfoRepository {


}