package com.mcst.order.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 申请退款/退货响应
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Accessors(chain = true)
@Schema(description = "申请退款/退货响应")
public class ApplyRefundResp {

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
     * 退款类型（0仅退款 1退货退款）
     */
    @Schema(description = "退款类型（0仅退款 1退货退款）")
    private Integer refundType;

    /**
     * 退款状态
     */
    @Schema(description = "退款状态")
    private Integer refundStatus;

    /**
     * 退款金额（系统自动计算）
     */
    @Schema(description = "退款金额（系统自动计算）")
    private BigDecimal refundAmount;

    /**
     * 申请时间
     */
    @Schema(description = "申请时间")
    private LocalDateTime applyTime;
}
