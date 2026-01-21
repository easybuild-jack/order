package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 订单商品项
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Accessors(chain = true)
@Schema(description = "订单商品项")
public class OrderGoodsItem {

    @Schema(description = "商品ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "商品ID不能为空")
    private String goodsId;

    @Schema(description = "商品SKU ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "商品SKU ID不能为空")
    private String goodsSkuId;

    @Schema(description = "商品名称")
    private String goodsName;

    @Schema(description = "SKU名称")
    private String goodsSkuName;

    @Schema(description = "商品编码")
    private String goodsNo;

    @Schema(description = "SKU编码")
    private String goodsSkuNo;

    @Schema(description = "商品图片")
    private String goodsPic;

    @Schema(description = "购买数量", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "购买数量不能为空")
    @Min(1)
    private Integer goodsCount;

    @Schema(description = "商品单价")
    private BigDecimal goodsPrice;

    @Schema(description = "商品类型（0普通商品 1虚拟商品）")
    private Integer goodsType = 0;

    @Schema(description = "是否赠品（0否 1是）")
    private Integer giftFlag = 0;
}
