package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.annotation.Column;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.order.api.dto.OrderDeliverGoodsDto;
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
@TableName("order_deliver_goods")
@AutoMapper(target = OrderDeliverGoodsDto.class)
public class OrderDeliverGoods extends BaseMyBatisPlusEntity<OrderDeliverGoods> {

    /**
     * 订单发货商品ID
     */
    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "订单发货商品ID")
    private String orderDeliverGoodsId;

    /**
     * 发货ID
     */
    @Column(comment = "发货ID")
    private String orderDeliverId;

    /**
     * 商品ID
     */
    @Column(comment = "商品ID")
    private String goodsId;

    /**
     * 商品名称
     */
    @Column(comment = "商品名称")
    private String goodsName;

    /**
     * 商品编号
     */
    @Column(comment = "商品编号")
    private String goodsNo;

    /**
     * 商品SKUID
     */
    @Column(comment = "商品SKUID")
    private String goodsSkuId;

    /**
     * 商品SKU名称
     */
    @Column(comment = "商品SKU名称")
    private String goodsSkuName;

    /**
     * 商品SKU编号
     */
    @Column(comment = "商品SKU编号")
    private String goodsSkuNo;

    /**
     * 商品数量
     */
    @Column(comment = "商品数量")
    private Integer goodsCount;

    /**
     * 商品图片URL
     */
    @Column(comment = "商品图片URL")
    private String goodsPicUrl;

}
