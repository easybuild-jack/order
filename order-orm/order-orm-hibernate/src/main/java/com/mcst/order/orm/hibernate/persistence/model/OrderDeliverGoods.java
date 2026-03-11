package com.mcst.order.orm.hibernate.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.hibernate.persistence.BaseHibernateEntity;
import com.mcst.order.api.dto.OrderDeliverGoodsDto;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UuidGenerator;

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
@Entity
@Table(name = "order_deliver_goods")
@AutoMapper(target = OrderDeliverGoodsDto.class)
public class OrderDeliverGoods extends BaseHibernateEntity {

    /**
     * 订单发货商品ID
     */
    @PrimaryKey
    @Id
    @UuidGenerator
    @Column(name = "order_deliver_goods_id")
    private String orderDeliverGoodsId;

    /**
     * 发货ID
     */
    @Column(name = "order_deliver_id")
    private String orderDeliverId;

    /**
     * 商品ID
     */
    @Column(name = "goods_id")
    private String goodsId;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 商品编号
     */
    @Column(name = "goods_no")
    private String goodsNo;

    /**
     * 商品SKUID
     */
    @Column(name = "goods_sku_id")
    private String goodsSkuId;

    /**
     * 商品SKU名称
     */
    @Column(name = "goods_sku_name")
    private String goodsSkuName;

    /**
     * 商品SKU编号
     */
    @Column(name = "goods_sku_no")
    private String goodsSkuNo;

    /**
     * 商品数量
     */
    @Column(name = "goods_count")
    private Integer goodsCount;

    /**
     * 商品图片URL
     */
    @Column(name = "goods_pic_url")
    private String goodsPicUrl;

}
