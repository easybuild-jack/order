package com.mcst.order.server.persistence.model;

import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;

import java.math.BigDecimal;

/**
 * 作者: liu yijun 日期: 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_discount")
@Table(name = "order_discount", comment = "订单优惠")
public class OrderDiscount extends BaseMyBatisPlusEntity<OrderDiscount> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "OrderDiscountId", isKey = true, length = 50)
    private String orderDiscountId;

    @Column(comment = "订单信息ID", length = 50)
    private String orderInfoId;

    @Column(comment = "订单编号", length = 50)
    private String orderNo;

    @Column(comment = "商品总金额", length = 10, decimalLength = 2)
    private BigDecimal goodsAmount;

    @Column(comment = "优惠金额", length = 10, decimalLength = 2)
    private BigDecimal discountAmount;

    @Column(comment = "优惠后的金额", length = 10, decimalLength = 2)
    private BigDecimal discountAfterAmount;

    @Column(comment = "用户优惠券ID", length = 500)
    private String userCouponIds;

    @Column(comment = "优惠备注 例如：满300减50 *1 现金抵扣券50 *1 限时折扣85折 *1", length = 200)
    private String discountRemark;

}