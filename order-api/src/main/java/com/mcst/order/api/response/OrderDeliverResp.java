package com.mcst.order.api.response;

import com.mcst.order.api.dto.OrderDeliverDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单发货数据响应对象
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单发货数据响应对象")
public class OrderDeliverResp extends OrderDeliverDto {


}
