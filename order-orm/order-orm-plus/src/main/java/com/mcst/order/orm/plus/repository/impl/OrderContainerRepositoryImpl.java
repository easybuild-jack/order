package com.mcst.order.orm.plus.repository.impl;

import com.mcst.easyfk.service.mybatisplus.impl.BaseMyBatisRepositoryImpl;
import com.mcst.order.api.dto.OrderContainerDto;
import com.mcst.order.orm.plus.persistence.mapper.OrderContainerMapper;
import com.mcst.order.orm.plus.persistence.model.OrderContainer;
import com.mcst.order.orm.repository.IOrderContainerRepository;

/**
 * <p>
 * 订单货柜信息 Repository实现类
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-29
 */
public class OrderContainerRepositoryImpl extends BaseMyBatisRepositoryImpl<OrderContainerMapper, OrderContainerDto, OrderContainer, String> implements IOrderContainerRepository {

}
