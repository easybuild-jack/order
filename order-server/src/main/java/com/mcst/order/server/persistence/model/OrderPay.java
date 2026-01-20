package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.annotation.Column;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.order.api.dto.OrderPayDto;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单支付
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_pay")
@AutoMapper(target = OrderPayDto.class)
public class OrderPay extends BaseMyBatisPlusEntity<OrderPay> {

    /**
     * 订单支付ID
     */
    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "订单支付ID")
    private String orderPayId;

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
     * 实际支付金额
     */
    @Column(comment = "实际支付金额")
    private BigDecimal actualPayAmount;

    /**
     * 支付状态 0：未支付，1：支付中，2：已支付
     */
    @Column(comment = "支付状态 0：未支付，1：支付中，2：已支付")
    private Integer payStatus;

    /**
     * 第三方交易编号
     */
    @Column(comment = "第三方交易编号")
    private String thirdTradeNo;

    /**
     * 支付类型，支付宝、微信、积分等
     */
    @Column(comment = "支付类型，支付宝、微信、积分等")
    private String payType;

    /**
     * 支付日期
     */
    @Column(comment = "支付日期")
    private LocalDate payDate;

    /**
     * 支付时间
     */
    @Column(comment = "支付时间")
    private LocalDateTime payTime;

}
