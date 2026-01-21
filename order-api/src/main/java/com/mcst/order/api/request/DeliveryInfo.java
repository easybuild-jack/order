package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 收货信息
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Accessors(chain = true)
@Builder
public class DeliveryInfo implements Serializable {

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
     * 省份
     */
    @Schema(description = "省份")
    private String province;

    /**
     * 城市
     */
    @Schema(description = "城市")
    private String city;

    /**
     * 区/县
     */
    @Schema(description = "区/县")
    private String area;

    /**
     * 详细地址
     */
    @Schema(description = "详细地址")
    private String address;
}
