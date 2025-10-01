package com.mcst.order.server.persistence.model;

import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 作者: liu yijun 日期: 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_pay")
@Table(name = "order_pay", comment = "订单支付")
public class OrderPay extends BaseMyBatisPlusEntity<OrderPay> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "OrderPayId", isKey = true, length = 50)
    private String orderPayId;

    @Column(comment = "订单信息ID", length = 50)
    private String orderInfoId;

    @Column(comment = "订单编号", length = 50)
    private String orderNo;

    @Column(comment = "实际金额，实际需要支付的金额", length = 2, defaultValue = "0")
    private BigDecimal actualAmount;

    @Column(comment = "支付金额", length = 10, decimalLength = 2, defaultValue = "0")
    private BigDecimal payAmount;

    @Column(comment = "支付积分", length = 10, decimalLength = 2)
    private BigDecimal creditAmount;

    @Column(comment = "支付余额", length = 10, decimalLength = 2)
    private BigDecimal balanceAmount;

    @Column(comment = "支付状态 0：未支付，1：支付中，2：已支付", length = 2, defaultValue = "0")
    private Integer payStatus;

    @Column(comment = "第三方交易号", length = 50)
    private String thirdTradeNo;

    @Column(comment = "第三方支付渠道 0 微信 1支付宝 2抖音 3银联", length = 2)
    private Integer thirdTradeChannel;

    @Column(comment = "支付日期", type = MySqlTypeConstant.DATE)
    private LocalDate payDate;

    @Column(comment = "支付时间", type = MySqlTypeConstant.TIMESTAMP)
    private LocalDateTime payTime;


}