package com.mcst.order.orm.flex.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.flex.persistence.BaseFlexEntity;
import com.mcst.order.api.dto.OrderPayDto;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
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
@Table("order_pay")
@AutoMapper(target = OrderPayDto.class)
public class OrderPay extends BaseFlexEntity<OrderPay> {

    /**
     * 订单ID
     */
    @PrimaryKey
    @Id(keyType = KeyType.Generator, value = "uuid")
    private String orderId;

    /**
     * 实际支付金额
     */
    private BigDecimal actualPayAmount;

    /**
     * 支付状态 0：未支付，1：支付中，2：已支付，3：已取消，4：支付失败
     */
    private Integer payStatus;

    /**
     * 第三方交易编号
     */
    private String thirdTradeNo;

    /**
     * 支付类型，wechat,alipay,douyin,union,credit,balance
     */
    private String payType;

    /**
     * 支付日期
     */
    private LocalDate payDate;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 备注
     */
    private String remark;

}
