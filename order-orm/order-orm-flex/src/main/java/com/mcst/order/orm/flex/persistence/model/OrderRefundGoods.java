package com.mcst.order.orm.flex.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.flex.persistence.BaseFlexEntity;
import com.mcst.order.api.dto.OrderRefundGoodsDto;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
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
@Table("order_refund_goods")
@AutoMapper(target = OrderRefundGoodsDto.class)
public class OrderRefundGoods extends BaseFlexEntity<OrderRefundGoods> {

    /**
     * 订单退款商品ID
     */
    @PrimaryKey
    @Id(keyType = KeyType.Generator, value = "uuid")
    private String orderRefundGoodsId;

    /**
     * 退款ID
     */
    private String orderRefundId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 订单商品记录ID
     */
    private String orderGoodsId;

    /**
     * 商品ID
     */
    private String goodsId;

    /**
     * 商品SKU ID
     */
    private String goodsSkuId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品SKU 名称
     */
    private String goodsSkuName;

    /**
     * 商品图片
     */
    private String goodsPic;

    /**
     * 商品规格JSON（用于回显）
     */
    private String goodsSpecJson;

    /**
     * 商品单价
     */
    private BigDecimal goodsPrice;

    /**
     * 商品实际支付单价
     */
    private BigDecimal goodsActualPrice;

    /**
     * 实际退款金额
     */
    private BigDecimal refundRealAmount;

    /**
     * 退货数量
     */
    private Integer returnQuantity;

    /**
     * 退货完成时间
     */
    private LocalDateTime returnFinishTime;

    /**
     * 快递公司
     */
    private String expressCompany;

    /**
     * 快递公司代码
     */
    private String expressCompanyCode;

    /**
     * 快递单号
     */
    private String expressNo;

    /**
     * 备注
     */
    private String remark;

}
