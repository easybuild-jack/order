package com.mcst.order.api.response;

import com.mcst.merchant.api.dto.MerchantInfoDto;
import com.mcst.order.api.dto.OrderGoodsDto;
import com.mcst.order.api.dto.OrderInfoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 订单信息数据响应对象
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单信息数据响应对象")
public class OrderInfoResp extends OrderInfoDto {

    /**
     * 商家信息
     */
    @Schema(description = "商家信息")
    private MerchantInfoDto merchantInfoDto;

    /**
     * 订单商品列表
     */
    @Schema(description = "订单商品列表")
    private List<OrderGoodsDto> orderGoodsList;

}
