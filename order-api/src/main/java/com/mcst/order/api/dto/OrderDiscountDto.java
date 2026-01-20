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
 * 订单优惠详情
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单优惠详情数据对象")
@SuperBuilder
@NoArgsConstructor
public class OrderDiscountDto extends BaseDto {

    /**
     * 订单优惠ID
     */
    @PrimaryKey
    @Schema(description = "订单优惠ID")
    private String orderDiscountId;

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
     * 商品金额
     */
    @Schema(description = "商品金额")
    private BigDecimal goodsAmount;

    /**
     * 优惠金额
     */
    @Schema(description = "优惠金额")
    private BigDecimal discountAmount;

    /**
     * 优惠后金额
     */
    @Schema(description = "优惠后金额")
    private BigDecimal discountAfterAmount;

    /**
     * 用户优惠券ID
     */
    @Schema(description = "用户优惠券ID")
    private String userCouponIds;

    /**
     * 优惠备注
     */
    @Schema(description = "优惠备注")
    private String discountRemark;

}
