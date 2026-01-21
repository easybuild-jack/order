package com.mcst.order.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 确认收货并退款响应
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Accessors(chain = true)
@Schema(description = "确认收货并退款响应")
public class ConfirmReceiveResp {

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
     * 确认收货时间
     */
    @Schema(description = "确认收货时间")
    private LocalDateTime receiveConfirmTime;
}
