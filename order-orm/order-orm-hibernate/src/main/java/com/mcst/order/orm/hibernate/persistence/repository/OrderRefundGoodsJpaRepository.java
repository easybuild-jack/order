package com.mcst.order.orm.hibernate.persistence.repository;

import com.mcst.order.orm.hibernate.persistence.model.OrderRefundGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * 订单退款商品 JPA Repository接口
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
public interface OrderRefundGoodsJpaRepository extends JpaRepository<OrderRefundGoods, String>, JpaSpecificationExecutor<OrderRefundGoods> {

}
