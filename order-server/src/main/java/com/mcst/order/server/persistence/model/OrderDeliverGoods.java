package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 订单发货商品
 *
 * @author: liu yijun
 * @date: 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_deliver_goods")
public class OrderDeliverGoods extends BaseMyBatisPlusEntity<OrderDeliverGoods> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
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