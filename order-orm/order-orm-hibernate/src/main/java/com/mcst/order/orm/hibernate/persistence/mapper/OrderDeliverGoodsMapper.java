package com.mcst.order.orm.hibernate.persistence.mapper;

import com.mcst.order.orm.hibernate.persistence.model.OrderDeliverGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * 订单发货商品 Mapper 接口
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
public interface OrderDeliverGoodsMapper extends JpaRepository<OrderDeliverGoods, String>, JpaSpecificationExecutor<OrderDeliverGoods> {

}
