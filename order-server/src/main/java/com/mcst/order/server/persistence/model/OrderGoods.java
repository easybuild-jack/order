package com.mcst.order.server.persistence.model;

import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;

import com.mcst.easyfk.core.annotation.PrimaryKey;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;

/**
 * @author: liu yijun
 * @date: 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_goods")
@Table(name = "order_goods", comment = "订单商品")
public class OrderGoods extends BaseMyBatisPlusEntity<OrderGoods> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "OrderGoodsId", isKey = true, length = 50)
    private String orderGoodsId;

    /**
     * 订单ID
     */
    @Column(comment = "订单ID", length = 50)
    private String orderInfoId;

    /**
     * 订单编号
     */
    @Column(comment = "订单编号", length = 50)
    private String orderNo;

    /**
     * 用户ID
     */
    @Column(comment = "用户ID", length = 50)
    private String userId;

    /**
     * 用户第三方账号 如：微信openid
     */
    @Column(comment = "用户第三方账号", length = 50)
    private String userThirdAccount;

    /**
     * 用户手机号
     */
    @Column(comment = "用户手机号", length = 11)
    private String userPhone;

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
     * 商品编码
     */
    @Column(comment = "商品编码", length = 50)
    private String goodsNo;

    /**
     * 商品SKUID
     */
    @Column(comment = "商品SKUID", length = 50)
    private String goodsSkuId;

    /**
     * SKU编码
     */
    @Column(comment = "SKU编码", length = 50)
    private String goodsSkuNo;

    /**
     * 商户sku名称
     */
    @Column(comment = "商户sku名称", length = 150)
    private String goodsSkuName;

    /**
     * 商品图片
     */
    @Column(comment = "商品图片", length = 200)
    private String goodsPicUrl;

    /**
     * 销售数量
     */
    @Column(comment = "销售数量", length = 10)
    private Integer goodsCount;

    /**
     * 商品原售价
     */
    @Column(comment = "商品原售价", length = 10, decimalLength = 2)
    private BigDecimal goodsPrice;

    /**
     * 产品序列号
     */
    @Column(comment = "产品序列号", length = 50)
    private String serialNo;

    /**
     * 商品类型 0-普通商品 1-虚拟商品
     */
    @Column(comment = "商品类型 0 普通商品 1 虚拟商品", length = 2, defaultValue = "0")
    private Integer goodsType;

    /**
     * 是否是赠品 0-否 1-是
     */
    @Column(comment = "是否是赠品 0-否 1-是", length = 2, defaultValue = "0")
    private Integer giftFlag;

}