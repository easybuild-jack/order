package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 填写退货物流请求
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Builder
@Accessors(chain = true)
@Schema(description = "填写退货物流请求")
public class SubmitReturnExpressReq implements Serializable {

    /**
     * 退款单号
     */
    @Schema(description = "退款单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "退款单号不能为空")
    private String orderRefundNo;

    /**
     * 物流公司
     */
    @Schema(description = "物流公司", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "物流公司不能为空")
    private String returnExpressCompany;

    /**
     * 物流单号
     */
    @Schema(description = "物流单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "物流单号不能为空")
    private String returnExpressNo;
}
