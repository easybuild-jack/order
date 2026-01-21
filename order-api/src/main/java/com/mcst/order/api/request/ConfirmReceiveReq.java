package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 确认收货并退款请求
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Builder
@Accessors(chain = true)
@Schema(description = "确认收货并退款请求")
public class ConfirmReceiveReq implements Serializable {

    /**
     * 退款单号
     */
    @Schema(description = "退款单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "退款单号不能为空")
    private String orderRefundNo;

    /**
     * 处理备注
     */
    @Schema(description = "处理备注")
    private String handleRemark;
}
