package com.mcst.order.orm.hibernate.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.hibernate.persistence.BaseHibernateEntity;
import com.mcst.order.api.dto.OrderPayDto;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UuidGenerator;

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
@Entity
@Table(name = "order_pay")
@AutoMapper(target = OrderPayDto.class)
public class OrderPay extends BaseHibernateEntity {

    /**
     * 订单ID
     */
    @PrimaryKey
    @Id
    @UuidGenerator
    @Column(name = "order_id")
    private String orderId;

    /**
     * 实际支付金额
     */
    @Column(name = "actual_pay_amount")
    private BigDecimal actualPayAmount;

    /**
     * 支付状态 0：未支付，1：支付中，2：已支付，3：已取消，4：支付失败
     */
    @Column(name = "pay_status")
    private Integer payStatus;

    /**
     * 第三方交易编号
     */
    @Column(name = "third_trade_no")
    private String thirdTradeNo;

    /**
     * 支付类型，wechat,alipay,douyin,union,credit,balance
     */
    @Column(name = "pay_type")
    private String payType;

    /**
     * 支付日期
     */
    @Column(name = "pay_date")
    private LocalDate payDate;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private LocalDateTime payTime;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

}
