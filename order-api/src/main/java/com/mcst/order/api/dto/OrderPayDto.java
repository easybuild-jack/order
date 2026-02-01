package com.mcst.order.api.dto;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
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
* @since 2026-02-01
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="订单支付数据对象")
@SuperBuilder
@NoArgsConstructor
public class OrderPayDto extends BaseDto {


    /**
    * 订单ID
    */
    @PrimaryKey
    @Schema(description= "订单ID")
    private String orderId;

    /**
    * 实际支付金额
    */
    @Schema(description= "实际支付金额")
    private BigDecimal actualPayAmount;

    /**
    * 支付状态 0：未支付，1：支付中，2：已支付，3：已取消，4：支付失败
    */
    @Schema(description= "支付状态 0：未支付，1：支付中，2：已支付，3：已取消，4：支付失败")
    private Integer payStatus;

    /**
    * 第三方交易编号
    */
    @Schema(description= "第三方交易编号")
    private String thirdTradeNo;

    /**
    * 支付类型，wechat,alipay,douyin,union,credit,balance
    */
    @Schema(description= "支付类型，wechat,alipay,douyin,union,credit,balance")
    private String payType;

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

    /**
    * 备注
    */
    @Schema(description= "备注")
    private String remark;


}
