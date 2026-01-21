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
 * 支付成功回调请求
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Builder
@Accessors(chain = true)
@Schema(description = "支付成功回调请求")
public class PayCallbackReq implements Serializable {

    /**
     * 订单编号
     */
    @Schema(description = "订单编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "订单编号不能为空")
    private String orderNo;

    /**
     * 第三方交易编号
     */
    @Schema(description = "第三方交易编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "第三方交易编号不能为空")
    private String thirdTradeNo;

    /**
     * 支付类型（wechat/alipay/credit/balance/union）
     */
    @Schema(description = "支付类型（wechat/alipay/credit/balance/union）")
    private String payType;

    /**
     * 实际支付金额
     */
    @Schema(description = "实际支付金额")
    private BigDecimal actualPayAmount;

    /**
     * 支付时间（不传则使用当前时间）
     */
    @Schema(description = "支付时间（不传则使用当前时间）")
    private LocalDateTime payTime;
}
