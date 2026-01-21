package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 自提信息
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Accessors(chain = true)
@Schema(description = "自提信息")
public class PickupInfo {

    @Schema(description = "提货点ID")
    private String pickupLocationId;

    @Schema(description = "提货点名称")
    private String pickupLocationName;

    @Schema(description = "提货人")
    private String pickupUser;

    @Schema(description = "提货人电话")
    private String pickupPhone;
}
