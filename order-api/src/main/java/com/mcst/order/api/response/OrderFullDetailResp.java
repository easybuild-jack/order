package com.mcst.order.api.response;

import com.mcst.order.api.dto.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
@Builder
@Schema(description = "订单全量信息响应")
public class OrderFullDetailResp implements Serializable {

    /**
     * 订单信息
     */
    @Schema(description = "订单信息")
    private OrderInfoDto orderInfo;
    /**
     * 订单商品列表
     */
    @Schema(description = "订单商品列表")
    private List<OrderGoodsDto> orderGoodsList;
    /**
     * 订单金额信息
     */
    @Schema(description = "订单金额信息")
    private OrderAmountDto orderAmountDto;
    /**
     * 订单支付信息
     */
    @Schema(description = "订单支付信息")
    private OrderPayDto orderPayDto;

    /**
     * 订单发货信息
     */
    @Schema(description = "订单发货信息")
    private OrderDeliverDto orderDeliverDto;

}
