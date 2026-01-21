package com.mcst.order.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 退款完成回调响应
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Accessors(chain = true)
@Schema(description = "退款完成回调响应")
public class RefundCallbackResp {

    /**
     * 订单退款ID
     */
    @Schema(description = "订单退款ID")
    private String orderRefundId;

    /**
     * 退款单号
     */
    @Schema(description = "退款单号")
    private String orderRefundNo;

    /**
     * 订单编号
     */
    @Schema(description = "订单编号")
    private String orderNo;

    /**
     * 原退款状态
     */
    @Schema(description = "原退款状态")
    private Integer oldRefundStatus;

    /**
     * 新退款状态
     */
    @Schema(description = "新退款状态")
    private Integer newRefundStatus;

    /**
     * 退款金额
     */
    @Schema(description = "退款金额")
    private BigDecimal refundAmount;

    /**
     * 退款完成时间
     */
    @Schema(description = "退款完成时间")
    private LocalDateTime refundCompleteTime;

    /**
     * 是否为重复回调（用于幂等标识）
     */
    @Schema(description = "是否为重复回调（用于幂等标识）")
    private Boolean repeated;
}
