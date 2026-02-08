package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@Builder
public class PickupInfo implements Serializable {

    /**
     * 提货点ID
     */
    @Schema(description = "提货点ID")
    private String pickupLocationId;

    /**
     * 提货点名称
     */
    @Schema(description = "提货点名称")
    private String pickupLocationName;

    /**
     * 提货人
     */
    @Schema(description = "提货人")
    private String pickupUser;

    /**
     * 提货人电话
     */
    @Schema(description = "提货人电话")
    private String pickupPhone;
}
