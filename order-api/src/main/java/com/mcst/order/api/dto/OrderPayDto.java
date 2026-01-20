package com.mcst.order.api.dto;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.mcst.easyfk.core.dto.BaseDto;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单支付
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单支付数据对象")
@SuperBuilder
@NoArgsConstructor
public class OrderPayDto extends BaseDto {

    /**
     * 订单支付ID
     */
    @PrimaryKey
    @Schema(description = "订单支付ID")
    private String orderPayId;

    /**
     * 订单信息ID
     */
    @Schema(description = "订单信息ID")
    private String orderInfoId;

    /**
     * 订单编号
     */
    @Schema(description = "订单编号")
    private String orderNo;

    /**
     * 实际支付金额
     */
    @Schema(description = "实际支付金额")
    private BigDecimal actualPayAmount;

    /**
     * 支付状态 0：未支付，1：支付中，2：已支付
     */
    @Schema(description = "支付状态 0：未支付，1：支付中，2：已支付")
    private Integer payStatus;

    /**
     * 第三方交易编号
     */
    @Schema(description = "第三方交易编号")
    private String thirdTradeNo;

    /**
     * 支付类型，支付宝、微信、积分等
     */
    @Schema(description = "支付类型，支付宝、微信、积分等")
    private String payType;

    /**
     * 支付日期
     */
    @Schema(description = "支付日期")
    private LocalDate payDate;

    /**
     * 支付时间
     */
    @Schema(description = "支付时间")
    private LocalDateTime payTime;

}
