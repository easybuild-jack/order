package com.mcst.order.orm.flex.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.flex.persistence.BaseFlexEntity;
import com.mcst.order.api.dto.OrderAmountDto;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 订单金额
 * </p>
 *
 * @author liu yijun
 * @since 2025-02-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table("order_amount")
@AutoMapper(target = OrderAmountDto.class)
public class OrderAmount extends BaseFlexEntity<OrderAmount> {

    /**
     * 订单ID
     */
    @PrimaryKey
    @Id(keyType = KeyType.Generator, value = "uuid")
    private String orderId;

    /**
     * 总金额(商品金额+邮费金额)
     */
    private BigDecimal totalAmount;

    /**
     * 商品金额
     */
    private BigDecimal goodsAmount;

    /**
     * 优惠金额（优惠掉的金额）
     */
    private BigDecimal discountAmount;

    /**
     * 优惠后金额（总金额-优惠金额）
     */
    private BigDecimal discountAfterAmount;

    /**
     * 邮费金额
     */
    private BigDecimal postageAmount;

    /**
     * 实际支付金额（优惠后金额+邮费金额），需要支付的金额
     */
    private BigDecimal actualPayAmount;


    /**
     * 用户优惠券ID
     */
    private String userCouponId;

    /**
     * 优惠名称
     */
    private String discountName;

}
