package com.mcst.order.orm.flex.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.flex.persistence.BaseFlexEntity;
import com.mcst.order.api.dto.OrderContainerDto;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@Table("order_container")
@AutoMapper(target = OrderContainerDto.class)
public class OrderContainer extends BaseFlexEntity<OrderContainer> {

    /**
     * 订单提货ID
     */
    @PrimaryKey
    @Id(keyType = KeyType.Generator, value = "uuid")
    private String orderId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 货柜ID
     */
    private String containerId;

    /**
     * 货柜名称
     */
    private String containerName;

    /**
     * 货柜编号
     */
    private String containerCode;

    /**
     * 具体货柜格子编号
     */
    private String gridNos;

    /**
     * 状态 0待送货 1待取货 2已取货
     */
    private Integer status;

    /**
     * 送货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 取货时间
     */
    private LocalDateTime pickupTime;

    /**
     * 备注
     */
    private String remark;

}
