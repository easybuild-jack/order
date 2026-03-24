package com.mcst.order.orm.hibernate.persistence.mapper;

import com.mcst.order.orm.hibernate.persistence.model.OrderRefund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * 订单退款 Mapper 接口
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
public interface OrderRefundMapper extends JpaRepository<OrderRefund, String>, JpaSpecificationExecutor<OrderRefund> {

}
