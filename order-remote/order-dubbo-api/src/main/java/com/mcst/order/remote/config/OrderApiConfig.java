package com.mcst.order.remote.config;


import com.mcst.order.api.*;
import com.mcst.order.remote.impl.*;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author liu yijun
 */
@AutoConfiguration
public class OrderApiConfig {
    @Bean
    @ConditionalOnMissingBean
    public IOrderDeliverApi orderDeliverApi() {
        return new OrderDeliverApiDubboImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderPickupApi orderPickupApi() {
        return new OrderPickupApiDubboImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderInfoApi orderInfoApi() {
        return new OrderInfoApiDubboImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderRefundApi orderRefundApi() {
        return new OrderRefundApiDubboImpl();
    }


    @Bean
    @ConditionalOnMissingBean
    public IOrderContainerApi orderContainerApi() {
        return new OrderContainerApiDubboImpl();
    }
}
