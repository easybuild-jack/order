package com.mcst.order.orm.hibernate.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.hibernate.persistence.BaseHibernateEntity;
import com.mcst.order.api.dto.OrderAmountDto;
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
 * 订单金额
 * </p>
 *
 * @author liu yijun
 * @since 2025-02-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Table(name = "order_amount")
@AutoMapper(target = OrderAmountDto.class)
public class OrderAmount extends BaseHibernateEntity {

    /**
     * 订单ID
     */
    @PrimaryKey
    @Id
    @UuidGenerator
    @Column(name = "order_id")
    private String orderId;

    /**
     * 总金额(商品金额+邮费金额)
     */
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    /**
     * 商品金额
     */
    @Column(name = "goods_amount")
    private BigDecimal goodsAmount;

    /**
     * 优惠金额（优惠掉的金额）
     */
    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    /**
     * 优惠后金额（总金额-优惠金额）
     */
    @Column(name = "discount_after_amount")
    private BigDecimal discountAfterAmount;

    /**
     * 邮费金额
     */
    @Column(name = "postage_amount")
    private BigDecimal postageAmount;

    /**
     * 实际支付金额（优惠后金额+邮费金额），需要支付的金额
     */
    @Column(name = "actual_pay_amount")
    private BigDecimal actualPayAmount;


    /**
     * 用户优惠券ID
     */
    @Column(name = "user_coupon_id")
    private String userCouponId;

    /**
     * 优惠名称
     */
    @Column(name = "discount_name")
    private String discountName;

}
