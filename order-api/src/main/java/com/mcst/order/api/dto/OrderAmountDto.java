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

/**
* <p>
* 订单金额
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="订单金额数据对象")
@SuperBuilder
@NoArgsConstructor
public class OrderAmountDto extends BaseDto {


    /**
    * OrderAmountId
    */
    @PrimaryKey
    @Schema(description= "OrderAmountId")
    private String orderAmountId;

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
    * 订单总金额，未打折的所有金额
    */
    @Schema(description= "订单总金额，未打折的所有金额")
    private BigDecimal totalAmount;

    /**
    * 商品总金额，未打折金额
    */
    @Schema(description= "商品总金额，未打折金额")
    private BigDecimal goodsAmount;

    /**
    * 优惠金额
    */
    @Schema(description= "优惠金额")
    private BigDecimal discountAmount;

    /**
    * 优惠后的金额
    */
    @Schema(description= "优惠后的金额")
    private BigDecimal discountAfterAmount;

    /**
    * 邮费金额
    */
    @Schema(description= "邮费金额")
    private BigDecimal postageAmount;

    /**
    * 实际金额 优惠后的金额+邮费 最终需要支付的金额
    */
    @Schema(description= "实际金额 优惠后的金额+邮费 最终需要支付的金额")
    private BigDecimal actualAmount;


}
