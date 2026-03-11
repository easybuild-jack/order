package com.mcst.order.server.config;

import com.mcst.order.api.*;
import com.mcst.order.server.impl.*;
import com.mcst.order.server.service.*;
import com.mcst.order.server.service.impl.*;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author liu yijun
 */
@AutoConfiguration
@EnableConfigurationProperties
public class OrderServerConfig {

    @Bean
    @ConditionalOnMissingBean
    public IOrderDeliverApi orderDeliverApi() {
        return new OrderDeliverApiServerImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderPickupApi orderPickupApi() {
        return new OrderPickupApiServerImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderInfoApi orderInfoApi() {
        return new OrderInfoApiServerImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderRefundApi orderRefundApi() {
        return new OrderRefundApiServerImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderContainerApi orderContainerApi() {
        return new OrderContainerApiServerImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderDeliverService orderDeliverService() {
        return new OrderDeliverServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderPickupService orderPickupService() {
        return new OrderPickupServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderInfoService orderInfoService() {
        return new OrderInfoServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderRefundService orderRefundService() {
        return new OrderRefundServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderContainerService orderContainerService() {
        return new OrderContainerServiceImpl();
    }


    @Bean
    @ConditionalOnMissingBean
    public OrderHelper orderHelper() {
        return new OrderHelper();
    }
}
