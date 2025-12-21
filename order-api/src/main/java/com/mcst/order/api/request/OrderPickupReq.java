package com.mcst.order.api.request;

import com.mcst.order.api.dto.OrderPickupDto;
import io.github.linpeilie.annotations.AutoMapper;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.mcst.order.api.param.OrderPickupParam;

/**
 * <p>
 * 订单提货数据请求对象
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单提货数据请求对象")
@AutoMapper(target = OrderPickupDto.class)
public class OrderPickupReq extends OrderPickupParam {

}
