package com.mcst.order.api.dto;

import com.mcst.easyfk.core.annotation.PrimaryKey;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.mcst.easyfk.core.dto.BaseDto;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单货柜信息数据对象")
@SuperBuilder
@NoArgsConstructor
public class OrderContainerDto extends BaseDto {

    @PrimaryKey
    @Schema(description = "订单货柜信息ID")
    private String orderContainerId;

    @Schema(description = "订单ID")
    private String orderInfoId;

    @Schema(description = "订单编号")
    private String orderNo;

    @Schema(description = "货柜信息ID")
    private String containerInfoId;

    @Schema(description = "货柜名称")
    private String containerName;

    @Schema(description = "货柜编号")
    private String containerCode;

    @Schema(description = "具体货柜格子编号，多个格子用逗号分隔")
    private String gridNos;

    @Schema(description = "状态 0待送货 1待取货 2已取货")
    private Integer status;

    @Schema(description = "送货时间")
    private LocalDateTime deliveryTime;

    @Schema(description = "取货时间")
    private LocalDateTime pickupTime;

    @Schema(description = "备注")
    private String remark;

}
