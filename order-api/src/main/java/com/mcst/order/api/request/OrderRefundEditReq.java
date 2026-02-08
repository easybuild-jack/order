package com.mcst.order.api.request;

import com.mcst.order.api.dto.OrderRefundDto;
import io.github.linpeilie.annotations.AutoMapper;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单退款数据编辑对象
 * </p>
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description = "订单退款数据编辑对象")
@AutoMapper(target = OrderRefundReq.class)
public class OrderRefundEditReq extends OrderRefundDto {


}
