package com.mcst.order.api.dto;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Accessors;
import com.mcst.easyfk.core.dto.BaseDto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
* <p>
* 订单信息
* </p>
*
* @author liu yijun
* @since 2026-01-26
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="订单信息数据对象")
@SuperBuilder
@NoArgsConstructor
public class OrderInfoDto extends BaseDto {


    /**
    * 订单信息ID
    */
    @PrimaryKey
    @Schema(description= "订单信息ID")
    private String orderInfoId;

    /**
    * 订单编号
    */
    @Schema(description= "订单编号")
    private String orderNo;

    /**
    * 用户ID
    */
    @Schema(description= "用户ID")
    private String userId;

    /**
    * 用户第三方账号，如微信openid
    */
    @Schema(description= "用户第三方账号，如微信openid")
    private String userThirdAccount;

    /**
    * 用户电话
    */
    @Schema(description= "用户电话")
    private String userPhone;

    /**
    * 商品名称
    */
    @Schema(description= "商品名称")
    private String goodsName;

    /**
    * 商品SKU 名称
    */
    @Schema(description= "商品SKU 名称")
    private String goodsSkuName;

    /**
    * 商品图片
    */
    @Schema(description= "商品图片")
    private String goodsPic;

    /**
    * 商品总数量
    */
    @Schema(description= "商品总数量")
    private Integer goodsCount;

    /**
    * 总金额
    */
    @Schema(description= "总金额")
    private BigDecimal totalAmount;

    /**
    * 实际支付金额，实际需要支付的金额
    */
    @Schema(description= "实际支付金额，实际需要支付的金额")
    private BigDecimal actualPayAmount;

    /**
    * 配送方式：0 自提 1 快递 2 虚拟商品 3 送货上门 99 送到货柜
    */
    @Schema(description= "配送方式：0 自提 1 快递 2 虚拟商品 3 送货上门 99 送到货柜")
    private Integer dispatchType;

    /**
    * 是否要发票 0未开发票，1已开票
    */
    @Schema(description= "是否要发票 0未开发票，1已开票")
    private Integer invoiceFlag;

    /**
    * 售后状态（0：未申请，1：已申请）
    */
    @Schema(description= "售后状态（0：未申请，1：已申请）")
    private Integer refundFlag;

    /**
    * 退款状态（0：未退款，1：全部退款，2：部分退款）
    */
    @Schema(description= "退款状态（0：未退款，1：全部退款，2：部分退款）")
    private Integer refundStatus;

    /**
    * 退款金额
    */
    @Schema(description= "退款金额")
    private BigDecimal refundAmount;

    /**
    * 买家备注
    */
    @Schema(description= "买家备注")
    private String userRemark;

    /**
    * 订单来源 0 线上商城 1 线下 2 淘宝 3 京东 4 拼多多 5 抖店
    */
    @Schema(description= "订单来源 0 线上商城 1 线下 2 淘宝 3 京东 4 拼多多 5 抖店")
    private Integer orderSource;

    /**
    * 标记备注
    */
    @Schema(description= "标记备注")
    private String tagRemark;

    /**
    * 订单状态（0：待支付，1：已取消，2：待发货，3：待收货，4：已收货，5：退货中，6：退款中，7：已退款）
    */
    @Schema(description= "订单状态（0：待支付，1：已取消，2：待发货，3：待收货，4：已收货，5：退货中，6：退款中，7：已退款）")
    private Integer orderStatus;

    /**
    * 订单渠道
    */
    @Schema(description= "订单渠道")
    private String orderChannel;

    /**
    * 客户端类型
    */
    @Schema(description= "客户端类型")
    private String clientType;

    /**
    * 订单推送状态（0：未推送，1：已推送）
    */
    @Schema(description= "订单推送状态（0：未推送，1：已推送）")
    private Integer pushFlag;

    /**
    * 订单备注
    */
    @Schema(description= "订单备注")
    private String orderRemark;

    /**
    * 统计状态 0未处理 1已处理
    */
    @Schema(description= "统计状态 0未处理 1已处理")
    private Integer statisticsFlag;

    /**
    * 商家ID
    */
    @Schema(description= "商家ID")
    private String merchantId;

    /**
    * 商家名称
    */
    @Schema(description= "商家名称")
    private String merchantName;

    /**
    * 商家备注
    */
    @Schema(description= "商家备注")
    private String merchantRemark;

    /**
    * 订单日期
    */
    @Schema(description= "订单日期")
    private LocalDate orderDate;

    /**
    * 订单时间
    */
    @Schema(description= "订单时间")
    private LocalDateTime orderTime;

    /**
    * 代理商ID
    */
    @Schema(description= "代理商ID")
    private String agentId;

    /**
    * 代理商名称
    */
    @Schema(description= "代理商名称")
    private String agentName;

    /**
    * 取消原因备注
    */
    @Schema(description= "取消原因备注")
    private String cancelRemark;

    /**
    * 取消时间
    */
    @Schema(description= "取消时间")
    private LocalDateTime cancelTime;


}
