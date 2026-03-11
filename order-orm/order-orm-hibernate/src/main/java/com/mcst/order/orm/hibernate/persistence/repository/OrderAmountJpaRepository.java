package com.mcst.order.orm.hibernate.persistence.repository;

import com.mcst.order.orm.hibernate.persistence.model.OrderAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * 订单金额 JPA Repository接口
 * </p>
 *
 * @author liu yijun
 * @since 2025-02-20
 */
public interface OrderAmountJpaRepository extends JpaRepository<OrderAmount, String>, JpaSpecificationExecutor<OrderAmount> {

}
