package com.mcst.order.orm.hibernate.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.hibernate.persistence.BaseHibernateEntity;
import com.mcst.order.api.dto.OrderContainerDto;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

/**
 * <p>
 * 订单货柜
 * 记录订单与货柜的存放关系
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Table(name = "order_container")
@AutoMapper(target = OrderContainerDto.class)
public class OrderContainer extends BaseHibernateEntity {

    /**
     * 订单提货ID
     */
    @PrimaryKey
    @Id
    @UuidGenerator
    @Column(name = "order_id")
    private String orderId;

    /**
     * 订单编号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 货柜ID
     */
    @Column(name = "container_id")
    private String containerId;

    /**
     * 货柜名称
     */
    @Column(name = "container_name")
    private String containerName;

    /**
     * 货柜编号
     */
    @Column(name = "container_code")
    private String containerCode;

    /**
     * 具体货柜格子编号
     */
    @Column(name = "grid_nos")
    private String gridNos;

    /**
     * 状态 0待送货 1待取货 2已取货
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 送货时间
     */
    @Column(name = "delivery_time")
    private LocalDateTime deliveryTime;

    /**
     * 取货时间
     */
    @Column(name = "pickup_time")
    private LocalDateTime pickupTime;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

}
