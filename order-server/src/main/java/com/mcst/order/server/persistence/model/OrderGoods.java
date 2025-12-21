package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.order.api.dto.OrderGoodsDto;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author: liu yijun
 * @date: 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_goods")
@AutoMapper(target = OrderGoodsDto.class)
public class OrderGoods extends BaseMyBatisPlusEntity<OrderGoods> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    private String orderGoodsId;

    /**
     * 订单ID
     */
    private String orderInfoId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户第三方账号 如：微信openid
     */
    private String userThirdAccount;

    /**
     * 用户手机号
     */
    private String userPhone;

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
     * 商户sku名称
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