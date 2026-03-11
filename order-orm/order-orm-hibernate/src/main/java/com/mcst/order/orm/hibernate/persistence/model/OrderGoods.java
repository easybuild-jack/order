package com.mcst.order.orm.hibernate.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.hibernate.persistence.BaseHibernateEntity;
import com.mcst.order.api.dto.OrderGoodsDto;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UuidGenerator;

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
@Entity
@Table(name = "order_goods")
@AutoMapper(target = OrderGoodsDto.class)
public class OrderGoods extends BaseHibernateEntity {

    /**
     * 订单商品ID
     */
    @PrimaryKey
    @Id
    @UuidGenerator
    @Column(name = "order_goods_id")
    private String orderGoodsId;

    /**
     * 订单ID
     */
    @Column(name = "order_id")
    private String orderId;

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
     * 商品编码
     */
    @Column(name = "goods_no")
    private String goodsNo;

    /**
     * 商品SKUID
     */
    @Column(name = "goods_sku_id")
    private String goodsSkuId;

    /**
     * SKU编码
     */
    @Column(name = "goods_sku_no")
    private String goodsSkuNo;

    /**
     * 商品SKU名称
     */
    @Column(name = "goods_sku_name")
    private String goodsSkuName;

    /**
     * 商品图片
     */
    @Column(name = "goods_pic_url")
    private String goodsPicUrl;

    /**
     * 销售数量
     */
    @Column(name = "goods_count")
    private Integer goodsCount;

    /**
     * 商品原售价
     */
    @Column(name = "goods_price")
    private BigDecimal goodsPrice;

    /**
     * 产品序列号
     */
    @Column(name = "serial_no")
    private String serialNo;

    /**
     * 商品类型 0-普通商品 1-虚拟商品
     */
    @Column(name = "goods_type")
    private Integer goodsType;

    /**
     * 是否是赠品 0-否 1-是
     */
    @Column(name = "gift_flag")
    private Integer giftFlag;

}
