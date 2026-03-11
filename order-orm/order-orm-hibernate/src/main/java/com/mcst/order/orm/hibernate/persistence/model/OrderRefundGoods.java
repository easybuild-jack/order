package com.mcst.order.orm.hibernate.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.hibernate.persistence.BaseHibernateEntity;
import com.mcst.order.api.dto.OrderRefundGoodsDto;
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
@Entity
@Table(name = "order_refund_goods")
@AutoMapper(target = OrderRefundGoodsDto.class)
public class OrderRefundGoods extends BaseHibernateEntity {

    /**
     * 订单退款商品ID
     */
    @PrimaryKey
    @Id
    @UuidGenerator
    @Column(name = "order_refund_goods_id")
    private String orderRefundGoodsId;

    /**
     * 退款ID
     */
    @Column(name = "order_refund_id")
    private String orderRefundId;

    /**
     * 订单ID
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 订单商品记录ID
     */
    @Column(name = "order_goods_id")
    private String orderGoodsId;

    /**
     * 商品ID
     */
    @Column(name = "goods_id")
    private String goodsId;

    /**
     * 商品SKU ID
     */
    @Column(name = "goods_sku_id")
    private String goodsSkuId;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 商品SKU 名称
     */
    @Column(name = "goods_sku_name")
    private String goodsSkuName;

    /**
     * 商品图片
     */
    @Column(name = "goods_pic")
    private String goodsPic;

    /**
     * 商品规格JSON（用于回显）
     */
    @Column(name = "goods_spec_json")
    private String goodsSpecJson;

    /**
     * 商品单价
     */
    @Column(name = "goods_price")
    private BigDecimal goodsPrice;

    /**
     * 商品实际支付单价
     */
    @Column(name = "goods_actual_price")
    private BigDecimal goodsActualPrice;

    /**
     * 实际退款金额
     */
    @Column(name = "refund_real_amount")
    private BigDecimal refundRealAmount;

    /**
     * 退货数量
     */
    @Column(name = "return_quantity")
    private Integer returnQuantity;

    /**
     * 退货完成时间
     */
    @Column(name = "return_finish_time")
    private LocalDateTime returnFinishTime;

    /**
     * 快递公司
     */
    @Column(name = "express_company")
    private String expressCompany;

    /**
     * 快递公司代码
     */
    @Column(name = "express_company_code")
    private String expressCompanyCode;

    /**
     * 快递单号
     */
    @Column(name = "express_no")
    private String expressNo;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

}
