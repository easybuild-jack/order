package com.mcst.order.server.persistence.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mcst.easyfk.core.annotation.ForbiddenField;
import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.service.mybatisplus.annotation.Column;
import com.mcst.easyfk.service.mybatisplus.persistence.BaseMyBatisPlusEntity;
import com.mcst.order.api.dto.PickupLocationDto;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 提货点信息
 * </p>
 *
 * @author liu yijun
 * @since 2025-02-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("pickup_location")
@AutoMapper(target = PickupLocationDto.class)
public class PickupLocation extends BaseMyBatisPlusEntity<PickupLocation> {

    /**
     * 提货点ID
     */
    @PrimaryKey
    @TableId(type = IdType.ASSIGN_UUID)
    @Column(comment = "提货点ID")
    private String pickupLocationId;

    /**
     * 提货点名称
     */
    @Column(comment = "提货点名称")
    private String locationName;

    /**
     * 提货点编号
     */
    @Column(comment = "提货点编号")
    private String locationCode;

    /**
     * 省
     */
    @Column(comment = "省")
    private String province;

    /**
     * 市
     */
    @Column(comment = "市")
    private String city;

    /**
     * 区
     */
    @Column(comment = "区")
    private String area;

    /**
     * 详细地址
     */
    @Column(comment = "详细地址")
    private String address;

    /**
     * 提货点完整地址
     */
    @Column(comment = "提货点完整地址")
    private String addressInfo;

    /**
     * 联系人
     */
    @Column(comment = "联系人")
    private String linkMan;

    /**
     * 联系电话
     */
    @Column(comment = "联系电话")
    private String linkPhone;

    /**
     * 营业时间
     */
    @Column(comment = "营业时间")
    private String businessHours;

    /**
     * 经度
     */
    @Column(comment = "经度")
    private String longitude;

    /**
     * 纬度
     */
    @Column(comment = "纬度")
    private String latitude;

    /**
     * 禁用状态 0可用，1禁用
     */
    @ForbiddenField(value = "forbiddenFlag")
    @Column(comment = "禁用状态 0可用，1禁用")
    private Integer forbiddenFlag;

    /**
     * 门店ID
     */
    @Column(comment = "门店ID")
    private String merchantId;

    /**
     * 门店名称
     */
    @Column(comment = "门店名称")
    private String merchantName;

    /**
     * 代理商ID
     */
    @Column(comment = "代理商ID")
    private String agentId;

    /**
     * 代理商名称
     */
    @Column(comment = "代理商名称")
    private String agentName;

}
