package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
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
@Table(name = "order_deliver_goods", comment = "订单发货商品")
public class OrderDeliverGoods extends BaseMyBatisPlusEntity<OrderDeliverGoods> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "OrderDeliverGoodsId", isKey = true, length = 50)
    private String orderDeliverGoodsId;

    /**
     * 发货ID
     */
    @Column(comment = "发货ID", length = 50)
    private String orderDeliverId;

    /**
     * 商品ID
     */
    @Column(comment = "商品ID", length = 50)
    private String goodsId;

    /**
     * 商品名称
     */
    @Column(comment = "商品名称", length = 50)
    private String goodsName;

    /**
     * 商品编号
     */
    @Column(comment = "商品编号", length = 50)
    private String goodsNo;

    /**
     * 商品SKUID
     */
    @Column(comment = "商品SKUID", length = 50)
    private String goodsSkuId;

    /**
     * 商品SKU名称
     */
    @Column(comment = "商品SKU名称", length = 150)
    private String goodsSkuName;

    /**
     * 商品SKU编号
     */
    @Column(comment = "商品SKU编号", length = 50)
    private String goodsSkuNo;

    /**
     * 商品数量
     */
    @Column(comment = "商品数量", length = 10)
    private Integer goodsCount;

    /**
     * 商品图片URL
     */
    @Column(comment = "商品图片URL", length = 200)
    private String goodsPicUrl;

}