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
 * 作者: liu yijun
 * 日期: 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("order_refund")
@Table(name = "order_refund", comment = "订单退款")
public class OrderRefund extends BaseMyBatisPlusEntity<OrderRefund> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "OrderRefundId", isKey = true, length = 50)
    private String orderRefundId;

    /**
     * 退款单号
     */
    @Column(comment = "退款单号", length = 50)
    private String orderRefundNo;

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
     * 支付记录ID
     */
    @Column(comment = "支付记录ID", length = 50)
    private String orderPayId;

    /**
     * 用户ID
     */
    @Column(comment = "用户ID", length = 50)
    private String userId;

    /**
     * 用户电话
     */
    @Column(comment = "用户电话", length = 50)
    private String userPhone;

    /**
     * 退款类型 0 仅退款 1 退货退款
     */
    @Column(comment = "退款类型 0 仅退款 1 退货退款", length = 2, defaultValue = "0")
    private Integer refundType;

    /**
     * 退款来源 0 用户申请 1 商家发起 2 系统发起
     */
    @Column(comment = "退款来源 0 用户申请 1 商家发起 2 系统发起", length = 2, defaultValue = "0")
    private Integer refundSource;

    /**
     * 退款状态 0 待审核 1 审核拒绝 2 待退货 3 待收货 4 退款中 5 已退款 6 已关闭
     */
    @Column(comment = "退款状态 0 待审核 1 审核拒绝 2 待退货 3 待收货 4 退款中 5 已退款 6 已关闭", length = 2, defaultValue = "0")
    private Integer refundStatus;

    /**
     * 退款渠道 0 原路退回 1 退至余额 2 线下打款
     */
    @Column(comment = "退款渠道 0 原路退回 1 退至余额 2 线下打款", length = 2, defaultValue = "0")
    private Integer refundChannel;

    /**
     * 退款原因类型
     */
    @Column(comment = "退款原因类型", length = 5, defaultValue = "0")
    private Integer refundReasonType;

    /**
     * 退款原因说明
     */
    @Column(comment = "退款原因说明", length = 200)
    private String refundReason;

    /**
     * 退款申请备注（用户填写）
     */
    @Column(comment = "退款申请备注（用户填写）", length = 200)
    private String applyRemark;

    /**
     * 退款审核备注（客服填写）
     */
    @Column(comment = "退款审核备注（客服填写）", length = 200)
    private String auditRemark;

    /**
     * 退款处理备注（财务填写）
     */
    @Column(comment = "退款处理备注（财务填写）", length = 200)
    private String handleRemark;

    /**
     * 退款申请金额
     */
    @Column(comment = "退款申请金额", length = 10, decimalLength = 2, defaultValue = "0")
    private BigDecimal refundAmount;

    /**
     * 退款运费金额
     */
    @Column(comment = "退款运费金额", length = 10, decimalLength = 2, defaultValue = "0")
    private BigDecimal refundFreightAmount;

    /**
     * 退款积分抵扣金额
     */
    @Column(comment = "退款积分抵扣金额", length = 10, decimalLength = 2, defaultValue = "0")
    private BigDecimal refundCreditAmount;

    /**
     * 退款优惠券抵扣金额
     */
    @Column(comment = "退款优惠券抵扣金额", length = 10, decimalLength = 2, defaultValue = "0")
    private BigDecimal refundCouponAmount;

    /**
     * 退款凭证图片，多个以逗号分隔
     */
    @Column(comment = "退款凭证图片，多个以逗号分隔", length = 500)
    private String refundEvidencePics;

    /**
     * 退回物流公司
     */
    @Column(comment = "退回物流公司", length = 100)
    private String returnExpressCompany;

    /**
     * 退回物流单号
     */
    @Column(comment = "退回物流单号", length = 50)
    private String returnExpressNo;

    /**
     * 审核人ID
     */
    @Column(comment = "审核人ID", length = 50)
    private String auditorId;

    /**
     * 审核人姓名
     */
    @Column(comment = "审核人姓名", length = 50)
    private String auditorName;

    /**
     * 审核时间
     */
    @Column(comment = "审核时间", type = MySqlTypeConstant.DATETIME)
    private LocalDateTime auditTime;

    /**
     * 处理人ID
     */
    @Column(comment = "处理人ID", length = 50)
    private String handlerId;

    /**
     * 处理人姓名
     */
    @Column(comment = "处理人姓名", length = 50)
    private String handlerName;

    /**
     * 处理时间
     */
    @Column(comment = "处理时间", type = MySqlTypeConstant.DATETIME)
    private LocalDateTime handleTime;

    /**
     * 退款交易号
     */
    @Column(comment = "退款交易号", length = 50)
    private String refundTradeNo;

    /**
     * 退款完成时间
     */
    @Column(comment = "退款完成时间", type = MySqlTypeConstant.DATETIME)
    private LocalDateTime refundCompleteTime;

    /**
     * 用户收货确认时间（用于退货退款）
     */
    @Column(comment = "用户收货确认时间（用于退货退款）", type = MySqlTypeConstant.DATETIME)
    private LocalDateTime receiveConfirmTime;

    /**
     * 联系电话
     */
    @Column(comment = "联系电话", length = 50)
    private String contactPhone;

    /**
     * 联系人
     */
    @Column(comment = "联系人", length = 50)
    private String contactName;
}