package com.mcst.order.api.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.mcst.easyfk.core.dto.request.BasicParam;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;

/**
* <p>
* 订单信息数据参数对象
* </p>
*
* @author liu yijun
* @since 2026-01-29
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="订单信息数据参数对象")
@SuperBuilder
@NoArgsConstructor
public class OrderContainerParam extends BasicParam {

    /**
    * 订单货柜信息ID
    */
    @Schema(description= "订单货柜信息ID")
    private String orderContainerId;

    /**
    * 订单ID
    */
    @Schema(description= "订单ID")
    private String orderInfoId;

    /**
    * 订单编号
    */
    @Schema(description= "订单编号")
    private String orderNo;

    /**
    * 货柜信息ID
    */
    @Schema(description= "货柜信息ID")
    private String containerInfoId;

    /**
    * 货柜名称
    */
    @Schema(description= "货柜名称")
    private String containerName;

    /**
    * 货柜编号
    */
    @Schema(description= "货柜编号")
    private String containerCode;

    /**
    * 具体货柜格子编号，多个格子用逗号分隔
    */
    @Schema(description= "具体货柜格子编号，多个格子用逗号分隔")
    private String gridNos;

    /**
    * 状态 0待送货 1待取货 2已取货
    */
    @Schema(description= "状态 0待送货 1待取货 2已取货")
    private Integer status;

    /**
    * 送货时间
    */
    @Schema(description= "送货时间")
    private LocalDateTime deliveryTime;

    /**
    * 取货时间
    */
    @Schema(description= "取货时间")
    private LocalDateTime pickupTime;

    /**
    * 备注
    */
    @Schema(description= "备注")
    private String remark;


}