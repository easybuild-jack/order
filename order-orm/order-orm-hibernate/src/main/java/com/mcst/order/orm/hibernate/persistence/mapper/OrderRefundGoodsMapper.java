package com.mcst.order.orm.hibernate.persistence.mapper;

import com.mcst.order.orm.hibernate.persistence.model.OrderRefundGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * 订单退款商品 Mapper 接口
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
public interface OrderRefundGoodsMapper extends JpaRepository<OrderRefundGoods, String>, JpaSpecificationExecutor<OrderRefundGoods> {

}
