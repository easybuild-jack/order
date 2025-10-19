package com.mcst.order.api.dto;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.mcst.easyfk.core.dto.BaseDto;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
* <p>
* 订单退款
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="订单退款数据对象")
public class OrderRefundDto extends BaseDto {


    /**
    * OrderRefundId
    */
    @PrimaryKey
    @Schema(description= "OrderRefundId")
    private String orderRefundId;

    /**
    * 退款单号
    */
    @Schema(description= "退款单号")
    private String orderRefundNo;

    /**
    * 订单信息ID
    */
    @Schema(description= "订单信息ID")
    private String orderInfoId;

    /**
    * 订单编号
    */
    @Schema(description= "订单编号")
    private String orderNo;

    /**
    * 支付记录ID
    */
    @Schema(description= "支付记录ID")
    private String orderPayId;

    /**
    * 用户ID
    */
    @Schema(description= "用户ID")
    private String userId;

    /**
    * 用户电话
    */
    @Schema(description= "用户电话")
    private String userPhone;

    /**
    * 退款类型 0 仅退款 1 退货退款
    */
    @Schema(description= "退款类型 0 仅退款 1 退货退款")
    private Integer refundType;

    /**
    * 退款来源 0 用户申请 1 商家发起 2 系统发起
    */
    @Schema(description= "退款来源 0 用户申请 1 商家发起 2 系统发起")
    private Integer refundSource;

    /**
    * 退款状态 0 待审核 1 审核拒绝 2 待退货 3 待收货 4 退款中 5 已退款 6 已关闭
    */
    @Schema(description= "退款状态 0 待审核 1 审核拒绝 2 待退货 3 待收货 4 退款中 5 已退款 6 已关闭")
    private Integer refundStatus;

    /**
    * 退款渠道 0 原路退回 1 退至余额 2 线下打款
    */
    @Schema(description= "退款渠道 0 原路退回 1 退至余额 2 线下打款")
    private Integer refundChannel;

    /**
    * 退款原因类型
    */
    @Schema(description= "退款原因类型")
    private Integer refundReasonType;

    /**
    * 退款原因说明
    */
    @Schema(description= "退款原因说明")
    private String refundReason;

    /**
    * 退款申请备注（用户填写）
    */
    @Schema(description= "退款申请备注（用户填写）")
    private String applyRemark;

    /**
    * 退款审核备注（客服填写）
    */
    @Schema(description= "退款审核备注（客服填写）")
    private String auditRemark;

    /**
    * 退款处理备注（财务填写）
    */
    @Schema(description= "退款处理备注（财务填写）")
    private String handleRemark;

    /**
    * 退款申请金额
    */
    @Schema(description= "退款申请金额")
    private BigDecimal refundAmount;

    /**
    * 退款运费金额
    */
    @Schema(description= "退款运费金额")
    private BigDecimal refundFreightAmount;

    /**
    * 退款积分抵扣金额
    */
    @Schema(description= "退款积分抵扣金额")
    private BigDecimal refundCreditAmount;

    /**
    * 退款优惠券抵扣金额
    */
    @Schema(description= "退款优惠券抵扣金额")
    private BigDecimal refundCouponAmount;

    /**
    * 退款凭证图片，多个以逗号分隔
    */
    @Schema(description= "退款凭证图片，多个以逗号分隔")
    private String refundEvidencePics;

    /**
    * 退回物流公司
    */
    @Schema(description= "退回物流公司")
    private String returnExpressCompany;

    /**
    * 退回物流单号
    */
    @Schema(description= "退回物流单号")
    private String returnExpressNo;

    /**
    * 审核人ID
    */
    @Schema(description= "审核人ID")
    private String auditorId;

    /**
    * 审核人姓名
    */
    @Schema(description= "审核人姓名")
    private String auditorName;

    /**
    * 审核时间
    */
    @Schema(description= "审核时间")
    private LocalDateTime auditTime;

    /**
    * 处理人ID
    */
    @Schema(description= "处理人ID")
    private String handlerId;

    /**
    * 处理人姓名
    */
    @Schema(description= "处理人姓名")
    private String handlerName;

    /**
    * 处理时间
    */
    @Schema(description= "处理时间")
    private LocalDateTime handleTime;

    /**
    * 退款交易号
    */
    @Schema(description= "退款交易号")
    private String refundTradeNo;

    /**
    * 退款完成时间
    */
    @Schema(description= "退款完成时间")
    private LocalDateTime refundCompleteTime;

    /**
    * 用户收货确认时间（用于退货退款）
    */
    @Schema(description= "用户收货确认时间（用于退货退款）")
    private LocalDateTime receiveConfirmTime;

    /**
    * 联系电话
    */
    @Schema(description= "联系电话")
    private String contactPhone;

    /**
    * 联系人
    */
    @Schema(description= "联系人")
    private String contactName;


}
