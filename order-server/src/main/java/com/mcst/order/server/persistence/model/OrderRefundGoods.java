package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author liuyijun
 * @date 2025-10-13
 * @description 订单退款商品
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_refund_goods")
@Table(name = "order_refund_goods", comment = "订单退款商品")
public class OrderRefundGoods extends BaseMyBatisPlusEntity<OrderRefundGoods> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "OrderRefundGoodsId", isKey = true, length = 50)
    private String orderRefundGoodsId;

    /**
     * 退款记录ID
     */
    @Column(comment = "退款记录ID", length = 50)
    private String orderRefundId;

    /**
     * 订单信息ID
     */
    @Column(comment = "订单信息ID", length = 50)
    private String orderInfoId;

    /**
     * 订单编号
     */
    @Column(comment = "订单编号", length = 50)
    private String orderNo;

    /**
     * 订单商品记录ID
     */
    @Column(comment = "订单商品记录ID", length = 50)
    private String orderGoodsId;

    /**
     * 商品ID
     */
    @Column(comment = "商品ID", length = 50)
    private String goodsId;

    /**
     * 商品SKU ID
     */
    @Column(comment = "商品SKU ID", length = 50)
    private String goodsSkuId;

    /**
     * 商品名称
     */
    @Column(comment = "商品名称", length = 150)
    private String goodsName;

    /**
     * 商品SKU 名称
     */
    @Column(comment = "商品SKU 名称", length = 200)
    private String goodsSkuName;

    /**
     * 商品图片
     */
    @Column(comment = "商品图片", length = 200)
    private String goodsPic;

    /**
     * 商品规格JSON（用于回显）
     */
    @Column(comment = "商品规格JSON（用于回显）", type = MySqlTypeConstant.TEXT)
    private String goodsSpecJson;

    /**
     * 商品单价
     */
    @Column(comment = "商品单价", length = 10, decimalLength = 2)
    private BigDecimal goodsPrice;

    /**
     * 商品实际支付单价
     */
    @Column(comment = "商品实际支付单价", length = 10, decimalLength = 2)
    private BigDecimal goodsActualPrice;

    /**
     * 实际退款金额
     */
    @Column(comment = "实际退款金额", length = 10, decimalLength = 2, defaultValue = "0")
    private BigDecimal refundRealAmount;

    /**
     * 退货数量
     */
    @Column(comment = "退货数量", length = 10)
    private Integer returnQuantity;

    /**
     * 退货完成时间
     */
    @Column(comment = "退货完成时间", type = MySqlTypeConstant.DATETIME)
    private LocalDateTime returnFinishTime;

    /**
     * 快递公司
     */
    @Column(comment = "快递公司", length = 100)
    private String expressCompany;

    /**
     * 快递公司代码
     */
    @Column(comment = "快递公司代码", length = 100)
    private String expressCompanyCode;

    /**
     * 快递单号
     */
    @Column(comment = "快递单号", length = 100)
    private String expressNo;

    /**
     * 备注
     */
    @Column(comment = "备注", length = 200)
    private String remark;
}