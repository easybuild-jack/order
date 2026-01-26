package com.mcst.order.api.response;

import com.mcst.order.api.dto.OrderGoodsDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 支付成功回调响应
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Accessors(chain = true)
@Schema(description = "支付成功回调响应")
public class PayCallbackResp {

    /**
     * 订单编号
     */
    @Schema(description = "订单编号")
    private String orderNo;

    /**
     * 订单商品列表
     */
    @Schema(description = "订单商品列表")
    private List<OrderGoodsDto> orderGoodsList;
}
