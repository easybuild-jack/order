package com.mcst.order.orm.hibernate.persistence.mapper;

import com.mcst.order.orm.hibernate.persistence.model.OrderContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * 订单货柜信息 Mapper 接口
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-29
 */
public interface OrderContainerMapper extends JpaRepository<OrderContainer, String>, JpaSpecificationExecutor<OrderContainer> {

}
