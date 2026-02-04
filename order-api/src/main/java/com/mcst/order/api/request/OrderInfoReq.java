package com.mcst.order.api.request;

import com.mcst.easyfk.core.annotation.BetweenEnd;
import com.mcst.easyfk.core.annotation.BetweenStart;
import com.mcst.order.api.dto.OrderInfoDto;
import com.mcst.order.api.param.OrderInfoParam;
import io.github.linpeilie.annotations.AutoMapper;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * <p>
 * 订单信息数据请求对象
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单信息数据请求对象")
@AutoMapper(target = OrderInfoDto.class)
public class OrderInfoReq extends OrderInfoParam {

    /**
     * 开始日期
     */
    @BetweenStart(field = "orderDate")
    @Schema(description = "开始日期")
    private LocalDate startDate;

    /**
     * 结束日期
     */
    @BetweenEnd(field = "orderDate")
    @Schema(description = "结束日期")
    private LocalDate endDate;


    /**
     * 开始时间
     */
    @BetweenStart(field = "orderTime")
    @Schema(description = "开始时间")
    private LocalDate startDateTime;

    /**
     * 结束时间
     */
    @BetweenEnd(field = "orderTime")
    @Schema(description = "结束时间")
    private LocalDate endDateTime;


}
