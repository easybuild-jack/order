package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.annotation.Column;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.order.api.dto.OrderDiscountDto;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 订单优惠详情
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_discount")
@AutoMapper(target = OrderDiscountDto.class)
public class OrderDiscount extends BaseMyBatisPlusEntity<OrderDiscount> {

    /**
     * 订单优惠ID
     */
    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "订单优惠ID")
    private String orderDiscountId;

    /**
     * 订单信息ID
     */
    @Column(comment = "订单信息ID")
    private String orderInfoId;

    /**
     * 订单编号
     */
    @Column(comment = "订单编号")
    private String orderNo;

    /**
     * 商品金额
     */
    @Column(comment = "商品金额")
    private BigDecimal goodsAmount;

    /**
     * 优惠金额
     */
    @Column(comment = "优惠金额")
    private BigDecimal discountAmount;

    /**
     * 优惠后金额
     */
    @Column(comment = "优惠后金额")
    private BigDecimal discountAfterAmount;

    /**
     * 用户优惠券ID
     */
    @Column(comment = "用户优惠券ID")
    private String userCouponIds;

    /**
     * 优惠备注
     */
    @Column(comment = "优惠备注")
    private String discountRemark;

}
