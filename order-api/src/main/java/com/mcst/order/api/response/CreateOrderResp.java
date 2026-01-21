package com.mcst.order.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 创建订单响应
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Accessors(chain = true)
@Schema(description = "创建订单响应")
public class CreateOrderResp {

    @Schema(description = "订单信息ID")
    private String orderInfoId;

    @Schema(description = "订单编号")
    private String orderNo;

    @Schema(description = "订单状态（0待支付 1已取消 2待发货...）")
    private Integer orderStatus;

    @Schema(description = "支付类型（wechat/alipay/credit/balance/union）")
    private String payType;

    @Schema(description = "支付状态（0未支付 1支付中 2已支付）")
    private Integer payStatus;

    @Schema(description = "订单总金额")
    private BigDecimal totalAmount;

    @Schema(description = "商品总数量")
    private Integer goodsCount;
}
