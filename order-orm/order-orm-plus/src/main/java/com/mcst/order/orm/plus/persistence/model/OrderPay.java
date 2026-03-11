package com.mcst.order.orm.plus.persistence.model;

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
     * 订单ID
     */
    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "订单ID")
    private String orderId;

    /**
     * 实际支付金额
     */
    @Column(comment = "实际支付金额")
    private BigDecimal actualPayAmount;

    /**
     * 支付状态 0：未支付，1：支付中，2：已支付，3：已取消，4：支付失败
     */
    @Column(comment = "支付状态 0：未支付，1：支付中，2：已支付，3：已取消，4：支付失败")
    private Integer payStatus;

    /**
     * 第三方交易编号
     */
    @Column(comment = "第三方交易编号")
    private String thirdTradeNo;

    /**
     * 支付类型，wechat,alipay,douyin,union,credit,balance
     */
    @Column(comment = "支付类型，wechat,alipay,douyin,union,credit,balance")
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

    /**
     * 备注
     */
    @Column(comment = "备注")
    private String remark;

}
