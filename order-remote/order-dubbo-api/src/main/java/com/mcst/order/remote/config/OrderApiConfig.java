package com.mcst.order.remote.config;


import com.mcst.order.api.*;
import com.mcst.order.remote.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;

/**
*
* @author liu yijun
*/
@Configuration
public class OrderApiConfig {
    @Bean
    @ConditionalOnMissingBean
    public IPickupLocationApi pickupLocationApi() {
         return new PickupLocationApiDubboImpl();
    }

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


}
