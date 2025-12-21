package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
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
 * 作者: liu yijun 日期: 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_pay")
@AutoMapper(target = OrderPayDto.class)
public class OrderPay extends BaseMyBatisPlusEntity<OrderPay> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    private String orderPayId;

    private String orderInfoId;

    private String orderNo;

    private BigDecimal actualAmount;

    private BigDecimal payAmount;

    private BigDecimal creditAmount;

    private BigDecimal balanceAmount;

    private Integer payStatus;

    private String thirdTradeNo;

    private Integer thirdTradeChannel;

    private LocalDate payDate;

    private LocalDateTime payTime;


}