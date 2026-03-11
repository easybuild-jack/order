package com.mcst.order.orm.flex.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.flex.persistence.BaseFlexEntity;
import com.mcst.order.api.dto.OrderPickupDto;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单提货
 * </p>
 *
 * @author liu yijun
 * @since 2025-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Table("order_pickup")
@AutoMapper(target = OrderPickupDto.class)
public class OrderPickup extends BaseFlexEntity<OrderPickup> {

    /**
     * 订单提货ID
     */
    @PrimaryKey
    @Id(keyType = KeyType.Generator, value = "uuid")
    private String orderId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 提货点ID
     */
    private String pickupLocationId;

    /**
     * 提货点名称
     */
    private String pickupLocationName;

    /**
     * 提货码
     */
    private String pickupCode;

    /**
     * 提货人
     */
    private String pickupUser;

    /**
     * 提货人电话
     */
    private String pickupPhone;

    /**
     * 提货时间
     */
    private LocalDateTime pickupTime;

    /**
     * 提货状态 0待提货 1已提货 2已取消
     */
    private Integer pickupStatus;

    /**
     * 提货备注
     */
    private String pickupRemark;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 提货点完整地址
     */
    private String addressInfo;

    /**
     * 联系人
     */
    private String linkMan;

    /**
     * 联系电话
     */
    private String linkPhone;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 实收金额
     */
    private BigDecimal receivedAmount;

    /**
     * 发货人ID
     */
    private String deliverId;

    /**
     * 发货人姓名
     */
    private String deliverName;

}
