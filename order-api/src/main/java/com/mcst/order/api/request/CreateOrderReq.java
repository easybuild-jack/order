package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 创建订单请求
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "创建订单请求")
public class CreateOrderReq {

    @Schema(description = "订单编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "订单编号不能为空")
    private String orderNo;

    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "用户ID不能为空")
    private String userId;

    @Schema(description = "用户第三方账号")
    private String userThirdAccount;

    @Schema(description = "用户手机号")
    private String userPhone;

    @Schema(description = "订单类型（0：线上，1：线下）")
    private Integer orderType = 0;

    @Schema(description = "配送方式（0自提 1快递 2虚拟商品 3送货上门 99货柜配送）")
    @NotNull(message = "配送方式不能为空")
    private Integer dispatchType;

    @Schema(description = "支付类型（wechat/alipay/credit/balance/union）")
    private String payType;

    @Schema(description = "第三方交易编号（支付成功后传入）")
    private String thirdTradeNo;

    @Schema(description = "支付状态（0未支付 1支付中 2已支付）")
    private Integer payStatus = 0;

    @Schema(description = "支付日期（支付成功后传入）")
    private LocalDate payDate;

    @Schema(description = "支付时间（支付成功后传入）")
    private LocalDateTime payTime;

    @Schema(description = "订单来源（0线上商城 1线下 2淘宝 3京东 4拼多多 5抖店）")
    private Integer orderSource = 0;

    @Schema(description = "客户端类型（0小程序 1APP 2PC）")
    private Integer clientType = 0;

    @Schema(description = "商家ID")
    private String merchantId;

    @Schema(description = "商家名称")
    private String merchantName;

    @Schema(description = "代理商ID")
    private String agentId;

    @Schema(description = "代理商名称")
    private String agentName;

    @Schema(description = "买家备注")
    @Size(max = 500)
    private String userRemark;

    @Schema(description = "是否要发票（0未开，1已开）")
    private Integer invoiceFlag = 0;

    @Schema(description = "使用的优惠券ID列表")
    private List<String> userCouponIds;

    @Schema(description = "优惠备注")
    private String discountRemark;

    @Schema(description = "商品金额")
    private BigDecimal goodsAmount;

    @Schema(description = "优惠金额")
    private BigDecimal discountAmount;

    @Schema(description = "邮费金额")
    private BigDecimal postageAmount;

    @Schema(description = "订单总金额")
    private BigDecimal totalAmount;

    @Schema(description = "实际支付金额")
    private BigDecimal actualPayAmount;

    @Schema(description = "优惠后金额（总金额-优惠金额）")
    private BigDecimal discountAfterAmount;

    @Schema(description = "商品总数量")
    private Integer goodsCount;

    @Schema(description = "商品列表", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "商品列表不能为空")
    private List<OrderGoodsItem> goodsList;

    @Schema(description = "收货信息（配送方式1、3时必填）")
    private DeliveryInfo deliveryInfo;

    @Schema(description = "自提信息（配送方式0时必填）")
    private PickupInfo pickupInfo;

    @Schema(description = "货柜信息（配送方式99时必填）")
    private ContainerInfo containerInfo;
}
