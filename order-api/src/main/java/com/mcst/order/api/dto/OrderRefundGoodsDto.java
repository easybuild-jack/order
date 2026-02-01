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
import java.time.LocalDateTime;

/**
* <p>
* 退款商品
* </p>
*
* @author liu yijun
* @since 2026-02-01
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="退款商品数据对象")
@SuperBuilder
@NoArgsConstructor
public class OrderRefundGoodsDto extends BaseDto {

    /**
    * 订单退款商品ID
    */
    @PrimaryKey
    @Schema(description= "订单退款商品ID")
    private String orderRefundGoodsId;

    /**
    * 退款ID
    */
    @Schema(description= "退款ID")
    private String orderRefundId;

    /**
    * 订单ID
    */
    @Schema(description= "订单ID")
    private String orderId;


    /**
    * 订单商品记录ID
    */
    @Schema(description= "订单商品记录ID")
    private String orderGoodsId;

    /**
    * 商品ID
    */
    @Schema(description= "商品ID")
    private String goodsId;

    /**
    * 商品SKU ID
    */
    @Schema(description= "商品SKU ID")
    private String goodsSkuId;

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
    * 商品规格JSON（用于回显）
    */
    @Schema(description= "商品规格JSON（用于回显）")
    private String goodsSpecJson;

    /**
    * 商品单价
    */
    @Schema(description= "商品单价")
    private BigDecimal goodsPrice;

    /**
    * 商品实际支付单价
    */
    @Schema(description= "商品实际支付单价")
    private BigDecimal goodsActualPrice;

    /**
    * 实际退款金额
    */
    @Schema(description= "实际退款金额")
    private BigDecimal refundRealAmount;

    /**
    * 退货数量
    */
    @Schema(description= "退货数量")
    private Integer returnQuantity;

    /**
    * 退货完成时间
    */
    @Schema(description= "退货完成时间")
    private LocalDateTime returnFinishTime;

    /**
    * 快递公司
    */
    @Schema(description= "快递公司")
    private String expressCompany;

    /**
    * 快递公司代码
    */
    @Schema(description= "快递公司代码")
    private String expressCompanyCode;

    /**
    * 快递单号
    */
    @Schema(description= "快递单号")
    private String expressNo;

    /**
    * 备注
    */
    @Schema(description= "备注")
    private String remark;


}
