package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.order.api.dto.OrderAmountDto;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 作者: liu yijun 日期: 2025-02-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_amount")
@AutoMapper(target = OrderAmountDto.class)
public class OrderAmount extends BaseMyBatisPlusEntity<OrderAmount> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    private String orderAmountId;

    private String orderInfoId;

    private String orderNo;

    private BigDecimal totalAmount;


    private BigDecimal goodsAmount;

    private BigDecimal discountAmount;

    private BigDecimal discountAfterAmount;

    private BigDecimal postageAmount;

    private BigDecimal actualAmount;

}