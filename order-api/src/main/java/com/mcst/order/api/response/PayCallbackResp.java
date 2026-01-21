package com.mcst.order.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 支付成功回调响应
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Accessors(chain = true)
@Schema(description = "支付成功回调响应")
public class PayCallbackResp {

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
     * 第三方交易编号
     */
    @Schema(description = "第三方交易编号")
    private String thirdTradeNo;

    /**
     * 原订单状态
     */
    @Schema(description = "原订单状态")
    private Integer oldOrderStatus;

    /**
     * 新订单状态
     */
    @Schema(description = "新订单状态")
    private Integer newOrderStatus;

    /**
     * 原支付状态
     */
    @Schema(description = "原支付状态")
    private Integer oldPayStatus;

    /**
     * 新支付状态
     */
    @Schema(description = "新支付状态")
    private Integer newPayStatus;

    /**
     * 支付时间
     */
    @Schema(description = "支付时间")
    private LocalDateTime payTime;

    /**
     * 是否为重复回调（用于幂等标识）
     */
    @Schema(description = "是否为重复回调（用于幂等标识）")
    private Boolean repeated;
}
