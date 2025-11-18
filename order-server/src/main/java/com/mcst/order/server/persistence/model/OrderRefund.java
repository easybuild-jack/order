package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 作者: liu yijun
 * 日期: 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_refund")
public class OrderRefund extends BaseMyBatisPlusEntity<OrderRefund> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    private String orderRefundId;

    /**
     * 退款单号
     */
    private String orderRefundNo;

    /**
     * 订单信息ID
     */
    private String orderInfoId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 支付记录ID
     */
    private String orderPayId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户电话
     */
    private String userPhone;

    /**
     * 退款类型 0 仅退款 1 退货退款
     */
    private Integer refundType;

    /**
     * 退款来源 0 用户申请 1 商家发起 2 系统发起
     */
    private Integer refundSource;

    /**
     * 退款状态 0 待审核 1 审核拒绝 2 待退货 3 待收货 4 退款中 5 已退款 6 已关闭
     */
    private Integer refundStatus;

    /**
     * 退款渠道 0 原路退回 1 退至余额 2 线下打款
     */
    private Integer refundChannel;

    /**
     * 退款原因类型
     */
    private Integer refundReasonType;

    /**
     * 退款原因说明
     */
    private String refundReason;

    /**
     * 退款申请备注（用户填写）
     */
    private String applyRemark;

    /**
     * 退款审核备注（客服填写）
     */
    private String auditRemark;

    /**
     * 退款处理备注（财务填写）
     */
    private String handleRemark;

    /**
     * 退款申请金额
     */
    private BigDecimal refundAmount;

    /**
     * 退款运费金额
     */
    private BigDecimal refundFreightAmount;

    /**
     * 退款积分抵扣金额
     */
    private BigDecimal refundCreditAmount;

    /**
     * 退款优惠券抵扣金额
     */
    private BigDecimal refundCouponAmount;

    /**
     * 退款凭证图片，多个以逗号分隔
     */
    private String refundEvidencePics;

    /**
     * 退回物流公司
     */
    private String returnExpressCompany;

    /**
     * 退回物流单号
     */
    private String returnExpressNo;

    /**
     * 审核人ID
     */
    private String auditorId;

    /**
     * 审核人姓名
     */
    private String auditorName;

    /**
     * 审核时间
     */
    private LocalDateTime auditTime;

    /**
     * 处理人ID
     */
    private String handlerId;

    /**
     * 处理人姓名
     */
    private String handlerName;

    /**
     * 处理时间
     */
    private LocalDateTime handleTime;

    /**
     * 退款交易号
     */
    private String refundTradeNo;

    /**
     * 退款完成时间
     */
    private LocalDateTime refundCompleteTime;

    /**
     * 用户收货确认时间（用于退货退款）
     */
    private LocalDateTime receiveConfirmTime;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 联系人
     */
    private String contactName;
}