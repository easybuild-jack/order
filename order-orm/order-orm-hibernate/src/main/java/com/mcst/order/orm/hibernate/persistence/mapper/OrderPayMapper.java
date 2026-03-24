package com.mcst.order.orm.hibernate.persistence.mapper;

import com.mcst.order.orm.hibernate.persistence.model.OrderPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * 订单支付 Mapper 接口
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
public interface OrderPayMapper extends JpaRepository<OrderPay, String>, JpaSpecificationExecutor<OrderPay> {

}
