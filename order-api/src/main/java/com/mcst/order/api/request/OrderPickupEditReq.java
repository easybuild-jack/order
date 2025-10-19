package com.mcst.order.api.request;

import com.mcst.order.api.dto.OrderPickupDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 订单提货数据编辑对象
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="订单提货数据编辑对象")
public class OrderPickupEditReq extends OrderPickupDto {


}
