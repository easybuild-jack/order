package com.mcst.order.orm.plus.repository.impl;

import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.order.api.dto.OrderAmountDto;
import com.mcst.order.orm.plus.persistence.mapper.OrderAmountMapper;
import com.mcst.order.orm.plus.persistence.model.OrderAmount;
import com.mcst.order.orm.repository.IOrderAmountRepository;

/**
 * <p>
 * 订单金额 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
public class OrderAmountRepositoryImpl extends BaseMyBatisRepositoryImpl<OrderAmountMapper, OrderAmountDto, OrderAmount, String> implements IOrderAmountRepository {


}
