package com.mcst.order.api.dto;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.core.dto.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * <p>
 * 订单商品
 * </p>
 *
 * @author liu yijun
 * @since 2026-02-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单商品数据对象")
@SuperBuilder
@NoArgsConstructor
public class OrderGoodsDto extends BaseDto {

    /**
     * 订单商品ID
     */
    @PrimaryKey
    @Schema(description = "订单商品ID")
    private String orderGoodsId;

    /**
     * 订单ID
     */
    @Schema(description = "订单ID")
    private String orderId;

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
     * 商品编码
     */
    @Schema(description = "商品编码")
    private String goodsNo;

    /**
     * 商品SKUID
     */
    @Schema(description = "商品SKUID")
    private String goodsSkuId;

    /**
     * SKU编码
     */
    @Schema(description = "SKU编码")
    private String goodsSkuNo;

    /**
     * 商品SKU名称
     */
    @Schema(description = "商品SKU名称")
    private String goodsSkuName;

    /**
     * 商品图片
     */
    @Schema(description = "商品图片")
    private String goodsPicUrl;

    /**
     * 销售数量
     */
    @Schema(description = "销售数量")
    private Integer goodsCount;

    /**
     * 商品售价
     */
    @Schema(description = "商品售价")
    private BigDecimal goodsPrice;

    /**
     * 产品序列号
     */
    @Schema(description = "产品序列号")
    private String serialNo;

    /**
     * 商品类型 0-普通商品 1-虚拟商品
     */
    @Schema(description = "商品类型 0-普通商品 1-虚拟商品")
    private Integer goodsType;

    /**
     * 是否是赠品 0-否 1-是
     */
    @Schema(description = "是否是赠品 0-否 1-是")
    private Integer giftFlag;

}
