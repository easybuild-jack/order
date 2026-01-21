package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.Builder;
import java.io.Serializable;

/**
 * <p>
 * 货柜信息
 * </p>
 *
 * @author Author Name
 * @since 2025-01-21
 */
@Data
@Accessors(chain = true)
@Schema(description = "货柜信息")
@Builder
public class ContainerInfo implements Serializable {

    /**
     * 货柜信息ID
     */
    @Schema(description = "货柜信息ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "货柜信息ID不能为空")
    private String containerInfoId;

    /**
     * 货柜名称
     */
    @Schema(description = "货柜名称")
    private String containerName;

    /**
     * 货柜编号
     */
    @Schema(description = "货柜编号")
    private String containerCode;

    /**
     * 货柜格子编号
     */
    @Schema(description = "货柜格子编号")
    private String gridNos;
}
