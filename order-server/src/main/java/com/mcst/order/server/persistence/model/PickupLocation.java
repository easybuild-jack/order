package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.ForbiddenField;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 作者: liu yijun 日期: 2025-02-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("pickup_location")
public class PickupLocation extends BaseMyBatisPlusEntity<PickupLocation> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    private String pickupLocationId;

    private String locationName;

    private String province;

    private String city;

    private String area;

    private String address;

    private String addressInfo;

    private String linkMan;

    private String linkPhone;

    private String businessHours;

    private String longitude;

    private String latitude;

    /**
     * 禁用状态 0可用，1禁用
     */
    @ForbiddenField(value = "forbiddenFlag")
    private Integer forbiddenFlag;
}