package com.mcst.order.orm.hibernate.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.hibernate.persistence.BaseHibernateEntity;
import com.mcst.order.api.dto.OrderRefundDto;
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
 * 订单退款
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Table(name = "order_refund")
@AutoMapper(target = OrderRefundDto.class)
public class OrderRefund extends BaseHibernateEntity {

    /**
     * 订单退款ID
     */
    @PrimaryKey
    @Id
    @UuidGenerator
    @Column(name = "order_refund_id")
    private String orderRefundId;

    /**
     * 退款单号
     */
    @Column(name = "order_refund_no")
    private String orderRefundNo;

    /**
     * 订单ID
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 订单编号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 支付记录ID
     */
    @Column(name = "order_pay_id")
    private String orderPayId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户电话
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 退款类型 0 仅退款 1 退货退款
     */
    @Column(name = "refund_type")
    private Integer refundType;

    /**
     * 退款来源 0 用户申请 1 商家发起 2 系统发起
     */
    @Column(name = "refund_source")
    private Integer refundSource;

    /**
     * 退款状态 0 待审核 1 审核拒绝 2 待退货 3 待收货 4 退款中 5 已退款 6 已关闭
     */
    @Column(name = "refund_status")
    private Integer refundStatus;

    /**
     * 退款渠道 0 原路退回 1 退至余额 2 线下打款
     */
    @Column(name = "refund_channel")
    private Integer refundChannel;

    /**
     * 退款原因类型
     */
    @Column(name = "refund_reason_type")
    private Integer refundReasonType;

    /**
     * 退款原因说明
     */
    @Column(name = "refund_reason")
    private String refundReason;

    /**
     * 退款申请备注（用户填写）
     */
    @Column(name = "apply_remark")
    private String applyRemark;

    /**
     * 退款审核备注（客服填写）
     */
    @Column(name = "audit_remark")
    private String auditRemark;

    /**
     * 退款处理备注（财务填写）
     */
    @Column(name = "handle_remark")
    private String handleRemark;

    /**
     * 退款申请金额
     */
    @Column(name = "refund_amount")
    private BigDecimal refundAmount;

    /**
     * 退款运费金额
     */
    @Column(name = "refund_freight_amount")
    private BigDecimal refundFreightAmount;

    /**
     * 退款积分抵扣金额
     */
    @Column(name = "refund_credit_amount")
    private BigDecimal refundCreditAmount;

    /**
     * 退款优惠券抵扣金额
     */
    @Column(name = "refund_coupon_amount")
    private BigDecimal refundCouponAmount;

    /**
     * 退款凭证图片，多个以逗号分隔
     */
    @Column(name = "refund_evidence_pics")
    private String refundEvidencePics;

    /**
     * 退回物流公司
     */
    @Column(name = "return_express_company")
    private String returnExpressCompany;

    /**
     * 退回物流单号
     */
    @Column(name = "return_express_no")
    private String returnExpressNo;

    /**
     * 审核人ID
     */
    @Column(name = "auditor_id")
    private String auditorId;

    /**
     * 审核人姓名
     */
    @Column(name = "auditor_name")
    private String auditorName;

    /**
     * 审核时间
     */
    @Column(name = "audit_time")
    private LocalDateTime auditTime;

    /**
     * 处理人ID
     */
    @Column(name = "handler_id")
    private String handlerId;

    /**
     * 处理人姓名
     */
    @Column(name = "handler_name")
    private String handlerName;

    /**
     * 处理时间
     */
    @Column(name = "handle_time")
    private LocalDateTime handleTime;

    /**
     * 退款交易号
     */
    @Column(name = "refund_trade_no")
    private String refundTradeNo;

    /**
     * 退款完成时间
     */
    @Column(name = "refund_complete_time")
    private LocalDateTime refundCompleteTime;

    /**
     * 用户收货确认时间（用于退货退款）
     */
    @Column(name = "receive_confirm_time")
    private LocalDateTime receiveConfirmTime;

    /**
     * 联系电话
     */
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 联系人
     */
    @Column(name = "contact_name")
    private String contactName;

}
