package com.mcst.order.api.response;

import com.mcst.order.api.dto.PickupLocationDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
* 提货点信息数据响应对象
* </p>
*
* @author liu yijun
* @since 2025-10-17
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Schema(description="提货点信息数据响应对象")
public class PickupLocationResp extends PickupLocationDto {


}
