package com.mcst.order.api.dto;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.order.api.response.PickupLocationResp;
import io.github.linpeilie.annotations.AutoMapper;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.mcst.easyfk.core.dto.BaseDto;

/**
 * <p>
 * 提货点信息
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "提货点信息数据对象")
@AutoMapper(target = PickupLocationResp.class)
public class PickupLocationDto extends BaseDto {

    /**
     * PickupLocationId
     */
    @PrimaryKey
    @Schema(description = "PickupLocationId")
    private String pickupLocationId;

    /**
     * 提货点名称
     */
    @Schema(description = "提货点名称")
    private String locationName;

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
     * 营业时间
     */
    @Schema(description = "营业时间")
    private String businessHours;

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
     * 禁用状态 0可用，1禁用
     */
    @Schema(description = "禁用状态 0可用，1禁用")
    private Integer forbiddenFlag;

}
