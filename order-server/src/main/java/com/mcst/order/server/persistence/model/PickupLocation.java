package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
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
@Table(name = "pickup_location", comment = "提货点信息")
public class PickupLocation extends BaseMyBatisPlusEntity<PickupLocation> {

    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "PickupLocationId", isKey = true, length = 50)
    private String pickupLocationId;

    @Column(length = 100, comment = "提货点名称")
    private String locationName;

    @Column(length = 100, comment = "省")
    private String province;

    @Column(length = 100, comment = "市")
    private String city;

    @Column(length = 100, comment = "区")
    private String area;

    @Column(length = 100, comment = "详细地址")
    private String address;

    @Column(length = 100, comment = "提货点完整地址")
    private String addressInfo;

    @Column(length = 100, comment = "联系人")
    private String linkMan;

    @Column(length = 100, comment = "联系电话")
    private String linkPhone;

    @Column(length = 100, comment = "营业时间")
    private String businessHours;

    @Column(length = 100, comment = "经度")
    private String longitude;

    @Column(length = 100, comment = "纬度")
    private String latitude;

    /**
     * 禁用状态 0可用，1禁用
     */
    @ForbiddenField(value = "forbiddenFlag")
    @Column(length = 2, comment = "禁用状态 0可用，1禁用", defaultValue = "0")
    private Integer forbiddenFlag;
}