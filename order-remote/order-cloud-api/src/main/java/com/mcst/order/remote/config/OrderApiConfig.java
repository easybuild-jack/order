package com.mcst.order.remote.config;


import com.mcst.order.api.*;
import com.mcst.order.remote.IOrderContainerRemote;
import com.mcst.order.remote.impl.*;
import com.mcst.order.remote.properties.OrderApiProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
*
* @author liu yijun
*/
@Configuration
@EnableConfigurationProperties(OrderApiProperties.class)
public class OrderApiConfig {
    @Bean
    @ConditionalOnMissingBean
    public IOrderDeliverApi orderDeliverApi() {
         return new OrderDeliverApiScImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderPickupApi orderPickupApi() {
         return new OrderPickupApiScImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderInfoApi orderInfoApi() {
         return new OrderInfoApiScImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderRefundApi orderRefundApi() {
         return new OrderRefundApiScImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderContainerApi orderContainerApi() {
         return new OrderContainerApiScImpl();
    }


}
