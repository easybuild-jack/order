package com.mcst.order.api.response;

import com.mcst.order.api.dto.OrderContainerDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 订单信息数据响应对象
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单信息数据响应对象")
@SuperBuilder
@NoArgsConstructor
public class OrderContainerResp extends OrderContainerDto {


}
