package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.annotation.Column;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.order.api.dto.OrderRefundGoodsDto;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单退款商品
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_refund_goods")
@AutoMapper(target = OrderRefundGoodsDto.class)
public class OrderRefundGoods extends BaseMyBatisPlusEntity<OrderRefundGoods> {

    /**
     * 订单退款商品ID
     */
    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "订单退款商品ID")
    private String orderRefundGoodsId;

    /**
     * 退款ID
     */
    @Column(comment = "退款ID")
    private String orderRefundId;

    /**
     * 订单ID
     */
    @Column(comment = "订单ID")
    private String orderId;

    /**
     * 订单商品记录ID
     */
    @Column(comment = "订单商品记录ID")
    private String orderGoodsId;

    /**
     * 商品ID
     */
    @Column(comment = "商品ID")
    private String goodsId;

    /**
     * 商品SKU ID
     */
    @Column(comment = "商品SKU ID")
    private String goodsSkuId;

    /**
     * 商品名称
     */
    @Column(comment = "商品名称")
    private String goodsName;

    /**
     * 商品SKU 名称
     */
    @Column(comment = "商品SKU 名称")
    private String goodsSkuName;

    /**
     * 商品图片
     */
    @Column(comment = "商品图片")
    private String goodsPic;

    /**
     * 商品规格JSON（用于回显）
     */
    @Column(comment = "商品规格JSON（用于回显）")
    private String goodsSpecJson;

    /**
     * 商品单价
     */
    @Column(comment = "商品单价")
    private BigDecimal goodsPrice;

    /**
     * 商品实际支付单价
     */
    @Column(comment = "商品实际支付单价")
    private BigDecimal goodsActualPrice;

    /**
     * 实际退款金额
     */
    @Column(comment = "实际退款金额")
    private BigDecimal refundRealAmount;

    /**
     * 退货数量
     */
    @Column(comment = "退货数量")
    private Integer returnQuantity;

    /**
     * 退货完成时间
     */
    @Column(comment = "退货完成时间")
    private LocalDateTime returnFinishTime;

    /**
     * 快递公司
     */
    @Column(comment = "快递公司")
    private String expressCompany;

    /**
     * 快递公司代码
     */
    @Column(comment = "快递公司代码")
    private String expressCompanyCode;

    /**
     * 快递单号
     */
    @Column(comment = "快递单号")
    private String expressNo;

    /**
     * 备注
     */
    @Column(comment = "备注")
    private String remark;

}
