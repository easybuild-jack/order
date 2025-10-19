package com.mcst.order.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.mcst.order.api.param.OrderDeliverParam;

/**
* <p>
* 订单发货数据请求对象
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="订单发货数据请求对象")
public class OrderDeliverReq extends OrderDeliverParam {


}
