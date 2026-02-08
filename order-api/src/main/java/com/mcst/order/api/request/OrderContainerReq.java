package com.mcst.order.api.request;

import com.mcst.order.api.param.OrderContainerParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 订单信息数据请求对象
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单信息数据请求对象")
@SuperBuilder
@NoArgsConstructor
public class OrderContainerReq extends OrderContainerParam {


}
