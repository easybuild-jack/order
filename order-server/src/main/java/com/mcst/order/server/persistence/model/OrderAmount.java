package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 作者: liu yijun 日期: 2025-02-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_amount")
@Table(name = "order_amount", comment = "订单金额")
public class OrderAmount extends BaseMyBatisPlusEntity<OrderAmount> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "OrderAmountId", isKey = true, length = 50)
    private String orderAmountId;

    @Column(comment = "订单信息ID", length = 50)
    private String orderInfoId;

    @Column(comment = "订单编号", length = 50)
    private String orderNo;

    @Column(comment = "订单总金额，未打折的所有金额", length = 10, decimalLength = 2)
    private BigDecimal totalAmount;

    @Column(comment = "商品总金额，未打折金额", length = 10, decimalLength = 2)
    private BigDecimal goodsAmount;

    @Column(comment = "优惠金额", length = 10, decimalLength = 2)
    private BigDecimal discountAmount;

    @Column(comment = "优惠后的金额", length = 10, decimalLength = 2)
    private BigDecimal discountAfterAmount;

    @Column(comment = "邮费金额", length = 10, decimalLength = 2)
    private BigDecimal postageAmount;

    @Column(comment = "实际金额 优惠后的金额+邮费 最终需要支付的金额", length = 10, decimalLength = 2)
    private BigDecimal actualAmount;

}