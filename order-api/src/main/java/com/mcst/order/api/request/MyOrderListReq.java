package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Schema(description = "我的订单列表请求参数")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyOrderListReq implements Serializable {

    /**
     * 用户ID
     */
    @Schema(description = "用户ID", hidden = true)
    private String userId;

    /**
     * 订单状态（0：待支付，1：已取消，2：待发货，3：待收货，4：已收货，5：退货中，6：退款中，7：已退款）
     */
    @Schema(description = "订单状态（0：待支付，1：已取消，2：待发货，3：待收货，4：已收货，5：退货中，6：退款中，7：已退款）")
    private Integer orderStatus;

    /**
     * 当前页码
     */
    @Schema(description = "当前页码")
    private Integer page;

    /**
     * 每页数量
     */
    @Schema(description = "每页数量")
    private Integer limit;
}
