package com.mcst.order.api.dto;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.core.dto.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 订单发货商品
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单发货商品数据对象")
@SuperBuilder
@NoArgsConstructor
public class OrderDeliverGoodsDto extends BaseDto {

    /**
     * 订单发货商品ID
     */
    @PrimaryKey
    @Schema(description = "订单发货商品ID")
    private String orderDeliverGoodsId;

    /**
     * 发货ID
     */
    @Schema(description = "发货ID")
    private String orderDeliverId;

    /**
     * 商品ID
     */
    @Schema(description = "商品ID")
    private String goodsId;

    /**
     * 商品名称
     */
    @Schema(description = "商品名称")
    private String goodsName;

    /**
     * 商品编号
     */
    @Schema(description = "商品编号")
    private String goodsNo;

    /**
     * 商品SKUID
     */
    @Schema(description = "商品SKUID")
    private String goodsSkuId;

    /**
     * 商品SKU名称
     */
    @Schema(description = "商品SKU名称")
    private String goodsSkuName;

    /**
     * 商品SKU编号
     */
    @Schema(description = "商品SKU编号")
    private String goodsSkuNo;

    /**
     * 商品数量
     */
    @Schema(description = "商品数量")
    private Integer goodsCount;

    /**
     * 商品图片URL
     */
    @Schema(description = "商品图片URL")
    private String goodsPicUrl;

}
