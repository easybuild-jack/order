package com.mcst.order.orm.plus.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.repository.persistence.annotation.EntityColumn;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.order.api.dto.OrderContainerDto;
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
@TableName("order_container")
@AutoMapper(target = OrderContainerDto.class)
public class OrderContainer extends BaseMyBatisPlusEntity<OrderContainer> {

    /**
     * 订单提货ID
     */
    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @EntityColumn(comment = "订单ID")
    private String orderId;

    /**
     * 订单编号
     */
    @EntityColumn(comment = "订单编号")
    private String orderNo;

    /**
     * 货柜ID
     */
    @EntityColumn(comment = "货柜ID")
    private String containerId;

    /**
     * 货柜名称
     */
    @EntityColumn(comment = "货柜名称")
    private String containerName;

    /**
     * 货柜编号
     */
    @EntityColumn(comment = "货柜编号")
    private String containerCode;

    /**
     * 具体货柜格子编号
     */
    @EntityColumn(comment = "具体货柜格子编号，多个格子用逗号分隔")
    private String gridNos;

    /**
     * 状态 0待送货 1待取货 2已取货
     */
    @EntityColumn(comment = "状态 0待送货 1待取货 2已取货")
    private Integer status;

    /**
     * 送货时间
     */
    @EntityColumn(comment = "送货时间")
    private LocalDateTime deliveryTime;

    /**
     * 取货时间
     */
    @EntityColumn(comment = "取货时间")
    private LocalDateTime pickupTime;

    /**
     * 备注
     */
    @EntityColumn(comment = "备注")
    private String remark;

}
