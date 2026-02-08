package com.mcst.order.server.repository.impl;

import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.order.api.dto.OrderRefundDto;
import com.mcst.order.server.persistence.mapper.OrderRefundMapper;
import com.mcst.order.server.persistence.model.OrderRefund;
import com.mcst.order.server.repository.IOrderRefundRepository;

/**
 * <p>
 * 订单退款 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderRefundRepositoryImpl extends BaseMyBatisRepositoryImpl<OrderRefundMapper, OrderRefundDto, OrderRefund, String> implements IOrderRefundRepository {


}