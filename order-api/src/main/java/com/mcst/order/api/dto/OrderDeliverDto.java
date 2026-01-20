package com.mcst.order.api.dto;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.order.api.response.OrderDeliverResp;
import io.github.linpeilie.annotations.AutoMapper;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.mcst.easyfk.core.dto.BaseDto;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单发货
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单发货数据对象")
@AutoMapper(target = OrderDeliverResp.class)
@SuperBuilder
@NoArgsConstructor
public class OrderDeliverDto extends BaseDto {

    /**
     * OrderDeliverId
     */
    @PrimaryKey
    @Schema(description = "OrderDeliverId")
    private String orderDeliverId;

    /**
     * 订单ID
     */
    @Schema(description = "订单ID")
    private String orderInfoId;

    /**
     * 订单编号
     */
    @Schema(description = "订单编号")
    private String orderNo;

    /**
     * 快递单号
     */
    @Schema(description = "快递单号")
    private String expressNo;

    /**
     * 快递公司编码
     */
    @Schema(description = "快递公司编码")
    private String expressCompanyCode;

    /**
     * 快递公司
     */
    @Schema(description = "快递公司")
    private String expressCompany;

    /**
     * 发货门店ID
     */
    @Schema(description = "发货门店ID")
    private String shopId;

    /**
     * 发货门店名称
     */
    @Schema(description = "发货门店名称")
    private String shopName;

    /**
     * 发货人ID
     */
    @Schema(description = "发货人ID")
    private String empId;

    /**
     * 发货人名称
     */
    @Schema(description = "发货人名称")
    private String empName;

    /**
     * 发货日期
     */
    @Schema(description = "发货日期")
    private LocalDate deliveredDate;

    /**
     * 发货时间
     */
    @Schema(description = "发货时间")
    private LocalDateTime deliveredTime;

    /**
     * 收货人名称
     */
    @Schema(description = "收货人名称")
    private String recipientsName;

    /**
     * 收货人手机号
     */
    @Schema(description = "收货人手机号")
    private String recipientsPhone;

    /**
     * 收货地址的ID
     */
    @Schema(description = "收货地址的ID")
    private String recipientsAddressId;

    /**
     * 具体收货地址
     */
    @Schema(description = "具体收货地址")
    private String address;

    /**
     * 地区
     */
    @Schema(description = "地区")
    private String area;

    /**
     * 城市
     */
    @Schema(description = "城市")
    private String city;

    /**
     * 省份
     */
    @Schema(description = "省份")
    private String province;

    /**
     * 排序
     */
    @Schema(description = "排序")
    private Integer sort;

    /**
     * 状态 0:待签收 1已签收
     */
    @Schema(description = "状态 0:待签收 1已签收")
    private Integer status;

    /**
     * 收货时间
     */
    @Schema(description = "收货时间")
    private LocalDateTime receiveTime;

    /**
     * 快递费用
     */
    @Schema(description = "快递费用")
    private BigDecimal postageAmount;

    /**
     * 快递费用模板ID
     */
    @Schema(description = "快递费用模板ID")
    private String postageTemplateId;

    /**
     * 快递费用模板名称
     */
    @Schema(description = "快递费用模板名称")
    private String postageTemplateName;

    /**
     * 订阅状态 0 未订阅 1已订阅
     */
    @Schema(description = "订阅状态 0 未订阅 1已订阅")
    private Integer subscriptStatus;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

}
