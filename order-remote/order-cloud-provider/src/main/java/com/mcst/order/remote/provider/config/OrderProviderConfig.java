package com.mcst.order.remote.provider.config;

import com.mcst.order.remote.*;
import com.mcst.order.remote.provider.impl.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

/**
*
* @author liu yijun
*/
@Configuration
public class OrderProviderConfig {

    @Bean
    @ConditionalOnMissingBean
    public IPickupLocationRemote pickupLocationRemote() {
         return new PickupLocationRemoteImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderDeliverRemote orderDeliverRemote() {
         return new OrderDeliverRemoteImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderPickupRemote orderPickupRemote() {
         return new OrderPickupRemoteImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderInfoRemote orderInfoRemote() {
         return new OrderInfoRemoteImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderRefundRemote orderRefundRemote() {
         return new OrderRefundRemoteImpl();
    }


}
