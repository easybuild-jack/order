package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.annotation.Column;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.order.api.dto.OrderAmountDto;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 订单金额
 * </p>
 *
 * @author liu yijun
 * @since 2025-02-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_amount")
@AutoMapper(target = OrderAmountDto.class)
public class OrderAmount extends BaseMyBatisPlusEntity<OrderAmount> {

    /**
     * 订单ID
     */
    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "订单ID")
    private String orderId;

    /**
     * 总金额(商品金额+邮费金额)
     */
    @Column(comment = "总金额(商品金额+邮费金额)")
    private BigDecimal totalAmount;

    /**
     * 商品金额
     */
    @Column(comment = "商品金额")
    private BigDecimal goodsAmount;

    /**
     * 优惠金额（优惠掉的金额）
     */
    @Column(comment = "优惠金额（优惠掉的金额）")
    private BigDecimal discountAmount;

    /**
     * 优惠后金额（总金额-优惠金额）
     */
    @Column(comment = "优惠后金额（总金额-优惠金额）")
    private BigDecimal discountAfterAmount;

    /**
     * 邮费金额
     */
    @Column(comment = "邮费金额")
    private BigDecimal postageAmount;

    /**
     * 实际支付金额（优惠后金额+邮费金额），需要支付的金额
     */
    @Column(comment = "实际支付金额（优惠后金额+邮费金额），需要支付的金额")
    private BigDecimal actualPayAmount;


    /**
     * 用户优惠券ID
     */
    @Column(comment = "用户优惠券ID")
    private String userCouponId;

    /**
     * 优惠券名称
     */
    @Column(comment = "优惠券名称")
    private String discountName;

}