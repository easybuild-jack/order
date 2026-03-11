package com.mcst.order.orm.flex.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.flex.persistence.BaseFlexEntity;
import com.mcst.order.api.dto.OrderGoodsDto;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 订单商品
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table("order_goods")
@AutoMapper(target = OrderGoodsDto.class)
public class OrderGoods extends BaseFlexEntity<OrderGoods> {

    /**
     * 订单商品ID
     */
    @PrimaryKey
    @Id(keyType = KeyType.Generator, value = "uuid")
    private String orderGoodsId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 商品ID
     */
    private String goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品编码
     */
    private String goodsNo;

    /**
     * 商品SKUID
     */
    private String goodsSkuId;

    /**
     * SKU编码
     */
    private String goodsSkuNo;

    /**
     * 商品SKU名称
     */
    private String goodsSkuName;

    /**
     * 商品图片
     */
    private String goodsPicUrl;

    /**
     * 销售数量
     */
    private Integer goodsCount;

    /**
     * 商品原售价
     */
    private BigDecimal goodsPrice;

    /**
     * 产品序列号
     */
    private String serialNo;

    /**
     * 商品类型 0-普通商品 1-虚拟商品
     */
    private Integer goodsType;

    /**
     * 是否是赠品 0-否 1-是
     */
    private Integer giftFlag;

}
