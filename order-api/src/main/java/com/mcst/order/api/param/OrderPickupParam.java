package com.mcst.order.api.param;

import com.mcst.easyfk.core.dto.request.BasicParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单提货数据参数对象
 * </p>
 *
 * @author liu yijun
 * @since 2026-02-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单提货数据参数对象")
@SuperBuilder
@NoArgsConstructor
public class OrderPickupParam extends BasicParam {

    /**
     * 订单ID
     */
    @Schema(description = "订单ID")
    private String orderId;

    /**
     * 订单编号
     */
    @Schema(description = "订单编号")
    private String orderNo;

    /**
     * 提货点ID
     */
    @Schema(description = "提货点ID")
    private String pickupLocationId;

    /**
     * 提货点名称
     */
    @Schema(description = "提货点名称")
    private String pickupLocationName;

    /**
     * 提货码
     */
    @Schema(description = "提货码")
    private String pickupCode;

    /**
     * 提货人
     */
    @Schema(description = "提货人")
    private String pickupUser;

    /**
     * 提货人电话
     */
    @Schema(description = "提货人电话")
    private String pickupPhone;

    /**
     * 提货时间
     */
    @Schema(description = "提货时间")
    private LocalDateTime pickupTime;

    /**
     * 提货状态 0待提货 1已提货 2已取消
     */
    @Schema(description = "提货状态 0待提货 1已提货 2已取消")
    private Integer pickupStatus;

    /**
     * 提货备注
     */
    @Schema(description = "提货备注")
    private String pickupRemark;

    /**
     * 省
     */
    @Schema(description = "省")
    private String province;

    /**
     * 市
     */
    @Schema(description = "市")
    private String city;

    /**
     * 区
     */
    @Schema(description = "区")
    private String area;

    /**
     * 详细地址
     */
    @Schema(description = "详细地址")
    private String address;

    /**
     * 提货点完整地址
     */
    @Schema(description = "提货点完整地址")
    private String addressInfo;

    /**
     * 联系人
     */
    @Schema(description = "联系人")
    private String linkMan;

    /**
     * 联系电话
     */
    @Schema(description = "联系电话")
    private String linkPhone;

    /**
     * 经度
     */
    @Schema(description = "经度")
    private String longitude;

    /**
     * 纬度
     */
    @Schema(description = "纬度")
    private String latitude;

    /**
     * 实收金额
     */
    @Schema(description = "实收金额")
    private BigDecimal receivedAmount;

    /**
     * 发货人ID
     */
    @Schema(description = "发货人ID")
    private String deliverId;

    /**
     * 发货人姓名
     */
    @Schema(description = "发货人姓名")
    private String deliverName;


}