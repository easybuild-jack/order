package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

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
@Schema(description = "收货信息")
public class DeliveryInfo {

    @Schema(description = "收货人名称")
    private String recipientsName;

    @Schema(description = "收货人手机号")
    private String recipientsPhone;

    @Schema(description = "省份")
    private String province;

    @Schema(description = "城市")
    private String city;

    @Schema(description = "区/县")
    private String area;

    @Schema(description = "详细地址")
    private String address;
}
