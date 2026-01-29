package com.mcst.order.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 自送货发货操作请求
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SelfDeliveryReq implements Serializable {

    /**
     * 订单ID列表
     */
    private List<String> orderIds;

    /**
     * 类型 0 货柜，1 提货点
     */
    private Integer type;
}
