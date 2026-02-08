package com.mcst.order.api.dto;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.core.dto.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * <p>
 * 订单金额
 * </p>
 *
 * @author liu yijun
 * @since 2026-02-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单金额数据对象")
@SuperBuilder
@NoArgsConstructor
public class OrderAmountDto extends BaseDto {


    /**
     * 订单ID
     */
    @PrimaryKey
    @Schema(description = "订单ID")
    private String orderId;

    /**
     * 总金额(商品金额+邮费金额)
     */
    @Schema(description = "总金额(商品金额+邮费金额)")
    private BigDecimal totalAmount;

    /**
     * 商品金额
     */
    @Schema(description = "商品金额")
    private BigDecimal goodsAmount;

    /**
     * 优惠金额（优惠掉的金额）
     */
    @Schema(description = "优惠金额（优惠掉的金额）")
    private BigDecimal discountAmount;

    /**
     * 优惠后金额（总金额-优惠金额）
     */
    @Schema(description = "优惠后金额（总金额-优惠金额）")
    private BigDecimal discountAfterAmount;

    /**
     * 邮费金额
     */
    @Schema(description = "邮费金额")
    private BigDecimal postageAmount;

    /**
     * 实际支付金额（优惠后金额+邮费金额），需要支付的金额
     */
    @Schema(description = "实际支付金额（优惠后金额+邮费金额），需要支付的金额")
    private BigDecimal actualPayAmount;

    /**
     * 用户优惠券ID
     */
    @Schema(description = "用户优惠券ID")
    private String userCouponId;

    /**
     * 优惠名称
     */
    @Schema(description = "优惠名称")
    private String discountName;


}
