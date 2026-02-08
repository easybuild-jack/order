package com.mcst.order.remote.provider.config;

import com.mcst.order.remote.*;
import com.mcst.order.remote.provider.impl.*;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author liu yijun
 */
@AutoConfiguration
public class OrderProviderConfig {

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


    @Bean
    @ConditionalOnMissingBean
    public IOrderContainerRemote orderContainerRemote() {
        return new OrderContainerRemoteImpl();
    }
}
