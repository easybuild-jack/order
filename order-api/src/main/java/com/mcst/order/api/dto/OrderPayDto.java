package com.mcst.order.api.dto;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.mcst.easyfk.core.dto.BaseDto;
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
@Schema(description="订单支付数据对象")
public class OrderPayDto extends BaseDto {


    /**
    * OrderPayId
    */
    @PrimaryKey
    @Schema(description= "OrderPayId")
    private String orderPayId;

    /**
    * 订单信息ID
    */
    @Schema(description= "订单信息ID")
    private String orderInfoId;

    /**
    * 订单编号
    */
    @Schema(description= "订单编号")
    private String orderNo;

    /**
    * 实际金额，实际需要支付的金额
    */
    @Schema(description= "实际金额，实际需要支付的金额")
    private BigDecimal actualAmount;

    /**
    * 支付金额
    */
    @Schema(description= "支付金额")
    private BigDecimal payAmount;

    /**
    * 支付积分
    */
    @Schema(description= "支付积分")
    private BigDecimal creditAmount;

    /**
    * 支付余额
    */
    @Schema(description= "支付余额")
    private BigDecimal balanceAmount;

    /**
    * 支付状态 0：未支付，1：支付中，2：已支付
    */
    @Schema(description= "支付状态 0：未支付，1：支付中，2：已支付")
    private Integer payStatus;

    /**
    * 第三方交易号
    */
    @Schema(description= "第三方交易号")
    private String thirdTradeNo;

    /**
    * 第三方支付渠道 0 微信 1支付宝 2抖音 3银联
    */
    @Schema(description= "第三方支付渠道 0 微信 1支付宝 2抖音 3银联")
    private Integer thirdTradeChannel;

    /**
    * 支付日期
    */
    @Schema(description= "支付日期")
    private LocalDate payDate;

    /**
    * 支付时间
    */
    @Schema(description= "支付时间")
    private LocalDateTime payTime;


}
