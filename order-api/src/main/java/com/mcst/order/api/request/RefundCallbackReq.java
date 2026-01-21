package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 退款完成回调请求
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Builder
@Accessors(chain = true)
@Schema(description = "退款完成回调请求")
public class RefundCallbackReq implements Serializable {

    /**
     * 退款单号
     */
    @Schema(description = "退款单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "退款单号不能为空")
    private String orderRefundNo;

    /**
     * 退款交易号（第三方支付返回）
     */
    @Schema(description = "退款交易号（第三方支付返回）")
    private String refundTradeNo;

    /**
     * 实际退款金额
     */
    @Schema(description = "实际退款金额")
    private BigDecimal actualRefundAmount;

    /**
     * 退款完成时间
     */
    @Schema(description = "退款完成时间")
    private LocalDateTime refundCompleteTime;
}
