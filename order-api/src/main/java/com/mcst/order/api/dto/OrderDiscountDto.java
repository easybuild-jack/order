package com.mcst.order.api.dto;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.mcst.easyfk.core.dto.BaseDto;
import java.math.BigDecimal;

/**
* <p>
* 订单优惠
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="订单优惠数据对象")
public class OrderDiscountDto extends BaseDto {


    /**
    * OrderDiscountId
    */
    @PrimaryKey
    @Schema(description= "OrderDiscountId")
    private String orderDiscountId;

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
    * 商品总金额
    */
    @Schema(description= "商品总金额")
    private BigDecimal goodsAmount;

    /**
    * 优惠金额
    */
    @Schema(description= "优惠金额")
    private BigDecimal discountAmount;

    /**
    * 优惠后的金额
    */
    @Schema(description= "优惠后的金额")
    private BigDecimal discountAfterAmount;

    /**
    * 用户优惠券ID
    */
    @Schema(description= "用户优惠券ID")
    private String userCouponIds;

    /**
    * 优惠备注 例如：满300减50 *1 现金抵扣券50 *1 限时折扣85折 *1
    */
    @Schema(description= "优惠备注 例如：满300减50 *1 现金抵扣券50 *1 限时折扣85折 *1")
    private String discountRemark;


}
