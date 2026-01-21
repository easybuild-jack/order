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
 * 审核退款申请请求
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Builder
@Accessors(chain = true)
@Schema(description = "审核退款申请请求")
public class AuditRefundReq implements Serializable {

    /**
     * 退款单号
     */
    @Schema(description = "退款单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "退款单号不能为空")
    private String orderRefundNo;

    /**
     * 审核结果（1同意 2拒绝）
     */
    @Schema(description = "审核结果（1同意 2拒绝）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "审核结果不能为空")
    private Integer auditResult;

    /**
     * 是否需要退货（审核同意时必填）
     */
    @Schema(description = "是否需要退货（审核同意时必填）")
    private Boolean needReturn;

    /**
     * 审核备注
     */
    @Schema(description = "审核备注")
    private String auditRemark;
}
