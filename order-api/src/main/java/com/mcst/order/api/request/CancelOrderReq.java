package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 取消订单请求
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Builder
@Accessors(chain = true)
@Schema(description = "取消订单请求")
public class CancelOrderReq implements Serializable {

    /**
     * 用户ID，当用户自己取消时必填
     */
    @Schema(description = "用户ID，当用户自己取消时必填")
    private String userId;

    /**
     * 订单编号
     */
    @Schema(description = "订单编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "订单编号不能为空")
    private String orderNo;

    /**
     * 取消原因备注
     */
    @Schema(description = "取消原因备注")
    @Size(max = 100)
    private String cancelRemark;
}
