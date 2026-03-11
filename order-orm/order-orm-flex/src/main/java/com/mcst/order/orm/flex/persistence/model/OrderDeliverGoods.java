package com.mcst.order.orm.flex.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.flex.persistence.BaseFlexEntity;
import com.mcst.order.api.dto.OrderDeliverGoodsDto;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单发货商品
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table("order_deliver_goods")
@AutoMapper(target = OrderDeliverGoodsDto.class)
public class OrderDeliverGoods extends BaseFlexEntity<OrderDeliverGoods> {

    /**
     * 订单发货商品ID
     */
    @PrimaryKey
    @Id(keyType = KeyType.Generator, value = "uuid")
    private String orderDeliverGoodsId;

    /**
     * 发货ID
     */
    private String orderDeliverId;

    /**
     * 商品ID
     */
    private String goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品编号
     */
    private String goodsNo;

    /**
     * 商品SKUID
     */
    private String goodsSkuId;

    /**
     * 商品SKU名称
     */
    private String goodsSkuName;

    /**
     * 商品SKU编号
     */
    private String goodsSkuNo;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 商品图片URL
     */
    private String goodsPicUrl;

}
