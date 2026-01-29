package com.mcst.order.server.service;

import com.mcst.easyfk.core.dto.request.ModifyRequest;
import com.mcst.easyfk.core.dto.response.BaseResult;
import com.mcst.easyfk.service.api.IBaseService;
import com.mcst.order.api.request.OrderContainerReq;
import com.mcst.order.api.response.OrderContainerResp;

/**
 * <p>
 * 订单信息 服务接口类
 * </p>
 *
 * @author liu yijun
 * @since 2026-01-29
 */
public interface IOrderContainerService extends IBaseService<OrderContainerResp, String, OrderContainerReq> {


    /**
     * 批量发货
     *
     * @param param
     * @return
     */
    BaseResult<?> batchDelivery(ModifyRequest<OrderContainerReq> param);

}