package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 申请退款/退货请求
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Builder
@Accessors(chain = true)
@Schema(description = "申请退款/退货请求")
public class ApplyRefundReq implements Serializable {

    /**
     * 订单编号
     */
    @Schema(description = "订单编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "订单编号不能为空")
    private String orderNo;

    /**
     * 退款类型（0仅退款 1退货退款）
     */
    @Schema(description = "退款类型（0仅退款 1退货退款）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "退款类型不能为空")
    private Integer refundType;

    /**
     * 退款原因类型
     */
    @Schema(description = "退款原因类型")
    private Integer refundReasonType;

    /**
     * 退款原因说明
     */
    @Schema(description = "退款原因说明")
    private String refundReason;

    /**
     * 申请备注
     */
    @Schema(description = "申请备注")
    private String applyRemark;

    /**
     * 凭证图片（逗号分隔）
     */
    @Schema(description = "凭证图片（逗号分隔）")
    private String refundEvidencePics;

    /**
     * 联系人
     */
    @Schema(description = "联系人")
    private String contactName;

    /**
     * 联系电话
     */
    @Schema(description = "联系电话")
    private String contactPhone;
}
