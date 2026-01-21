package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 取消订单请求
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "取消订单请求")
public class CancelOrderReq {

    @Schema(description = "订单编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "订单编号不能为空")
    private String orderNo;

    @Schema(description = "取消原因类型（1用户主动取消 2支付超时 3库存不足 4价格变动 5系统取消 6商家取消 99其他）")
    private Integer cancelReasonType;

    @Schema(description = "取消原因备注")
    @Size(max = 500)
    private String cancelRemark;
}
