package com.mcst.order.orm.hibernate.persistence.model;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.hibernate.persistence.BaseHibernateEntity;
import com.mcst.order.api.dto.OrderPickupDto;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UuidGenerator;

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
@Entity
@Table(name = "order_pickup")
@AutoMapper(target = OrderPickupDto.class)
public class OrderPickup extends BaseHibernateEntity {

    /**
     * 订单提货ID
     */
    @PrimaryKey
    @Id
    @UuidGenerator
    @Column(name = "order_id")
    private String orderId;

    /**
     * 订单编号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 提货点ID
     */
    @Column(name = "pickup_location_id")
    private String pickupLocationId;

    /**
     * 提货点名称
     */
    @Column(name = "pickup_location_name")
    private String pickupLocationName;

    /**
     * 提货码
     */
    @Column(name = "pickup_code")
    private String pickupCode;

    /**
     * 提货人
     */
    @Column(name = "pickup_user")
    private String pickupUser;

    /**
     * 提货人电话
     */
    @Column(name = "pickup_phone")
    private String pickupPhone;

    /**
     * 提货时间
     */
    @Column(name = "pickup_time")
    private LocalDateTime pickupTime;

    /**
     * 提货状态 0待提货 1已提货 2已取消
     */
    @Column(name = "pickup_status")
    private Integer pickupStatus;

    /**
     * 提货备注
     */
    @Column(name = "pickup_remark")
    private String pickupRemark;

    /**
     * 省
     */
    @Column(name = "province")
    private String province;

    /**
     * 市
     */
    @Column(name = "city")
    private String city;

    /**
     * 区
     */
    @Column(name = "area")
    private String area;

    /**
     * 详细地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 提货点完整地址
     */
    @Column(name = "address_info")
    private String addressInfo;

    /**
     * 联系人
     */
    @Column(name = "link_man")
    private String linkMan;

    /**
     * 联系电话
     */
    @Column(name = "link_phone")
    private String linkPhone;

    /**
     * 经度
     */
    @Column(name = "longitude")
    private String longitude;

    /**
     * 纬度
     */
    @Column(name = "latitude")
    private String latitude;

    /**
     * 实收金额
     */
    @Column(name = "received_amount")
    private BigDecimal receivedAmount;

    /**
     * 发货人ID
     */
    @Column(name = "deliver_id")
    private String deliverId;

    /**
     * 发货人姓名
     */
    @Column(name = "deliver_name")
    private String deliverName;

}
