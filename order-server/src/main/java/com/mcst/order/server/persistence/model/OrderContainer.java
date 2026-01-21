package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.annotation.Column;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 订单货柜信息
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
//@AutoMapper(target = OrderContainerDto.class)
public class OrderContainer extends BaseMyBatisPlusEntity<OrderContainer> {

    /**
     * 订单提货ID
     */
    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "订单货柜信息ID")
    private String orderContainerId;

    /**
     * 订单ID
     */
    @Column(comment = "订单ID")
    private String orderInfoId;

    /**
     * 订单编号
     */
    @Column(comment = "订单编号")
    private String orderNo;

    /**
     * 货柜信息ID
     */
    @Column(comment = "货柜信息ID")
    private String containerInfoId;

    /**
     * 货柜名称
     */
    @Column(comment = "货柜名称")
    private String containerName;

    /**
     * 货柜编号
     */
    @Column(comment = "货柜编号")
    private String containerCode;

    /**
     * 具体货柜格子编号
     */
    @Column(comment = "具体货柜格子编号，多个格子用逗号分隔")
    private String gridNos;

    /**
     * 状态 0待送货 1待取货 2已取货
     */
    @Column(comment = "状态 0待送货 1待取货 2已取货")
    private Integer status;

    /**
     * 送货时间
     */
    @Column(comment = "送货时间")
    private LocalDateTime deliveryTime;

    /**
     * 取货时间
     */
    @Column(comment = "取货时间")
    private LocalDateTime pickupTime;

    /**
     * 备注
     */
    @Column(comment = "备注")
    private String remark;

}
