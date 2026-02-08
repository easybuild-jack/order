package com.mcst.order.api.dto;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import com.mcst.easyfk.core.dto.BaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * <p>
 * 订单货柜
 * </p>
 *
 * @author liu yijun
 * @since 2026-02-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单货柜数据对象")
@SuperBuilder
@NoArgsConstructor
public class OrderContainerDto extends BaseDto {


    /**
     * 订单ID
     */
    @PrimaryKey
    @Schema(description = "订单ID")
    private String orderId;

    /**
     * 订单编号
     */
    @Schema(description = "订单编号")
    private String orderNo;

    /**
     * 货柜ID
     */
    @Schema(description = "货柜ID")
    private String containerId;

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
     * 具体货柜格子编号，多个格子用逗号分隔
     */
    @Schema(description = "具体货柜格子编号，多个格子用逗号分隔")
    private String gridNos;

    /**
     * 状态 0待送货 1待取货 2已取货
     */
    @Schema(description = "状态 0待送货 1待取货 2已取货")
    private Integer status;

    /**
     * 送货时间
     */
    @Schema(description = "送货时间")
    private LocalDateTime deliveryTime;

    /**
     * 取货时间
     */
    @Schema(description = "取货时间")
    private LocalDateTime pickupTime;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;


}
