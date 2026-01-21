package com.mcst.order.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 取消订单响应
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Accessors(chain = true)
@Schema(description = "取消订单响应")
public class CancelOrderResp {

    @Schema(description = "订单信息ID")
    private String orderInfoId;

    @Schema(description = "订单编号")
    private String orderNo;

    @Schema(description = "原订单状态")
    private Integer oldOrderStatus;

    @Schema(description = "新订单状态（1已取消）")
    private Integer newOrderStatus;

    @Schema(description = "取消时间")
    private LocalDateTime cancelTime;
}
