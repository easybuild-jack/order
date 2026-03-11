package com.mcst.order.orm.hibernate.persistence.repository;

import com.mcst.order.orm.hibernate.persistence.model.OrderPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * 订单支付 JPA Repository接口
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
public interface OrderPayJpaRepository extends JpaRepository<OrderPay, String>, JpaSpecificationExecutor<OrderPay> {

}
