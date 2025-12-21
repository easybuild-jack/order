package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.order.api.dto.OrderPickupDto;
import io.github.linpeilie.annotations.AutoMapper;
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
@TableName("order_pickup")
@AutoMapper(target = OrderPickupDto.class)
public class OrderPickup extends BaseMyBatisPlusEntity<OrderPickup> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    private String orderPickupId;

    private String orderInfoId;

    private String orderNo;

    private String pickupLocationId;

    private String pickupCode;

    private String pickupUser;

    private String pickupPhone;

    private LocalDateTime pickupTime;

    private Integer pickupStatus;

    private String pickupRemark;

    private String province;

    private String city;

    private String area;

    private String address;

    private String addressInfo;

    private String linkMan;

    private String linkPhone;

    private String longitude;

    private String latitude;

    private BigDecimal receivedAmount;

    private String deliverId;

    private String deliverName;

}