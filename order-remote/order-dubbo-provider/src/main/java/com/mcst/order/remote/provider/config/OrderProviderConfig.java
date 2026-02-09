package com.mcst.order.remote.provider.config;

import com.mcst.order.remote.*;
import com.mcst.order.remote.provider.impl.*;
import org.apache.dubbo.config.ServiceConfig;
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
    public ServiceConfig<IOrderContainerRemote> orderContainerRemoteServiceConfig(OrderContainerRemoteImpl orderContainerRemoteImpl) {
        ServiceConfig<IOrderContainerRemote> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(IOrderContainerRemote.class);
        serviceConfig.setRef(orderContainerRemoteImpl);
        serviceConfig.export();
        return serviceConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public ServiceConfig<IOrderInfoRemote> orderInfoRemoteServiceConfig(OrderInfoRemoteImpl orderInfoRemoteImpl) {
        ServiceConfig<IOrderInfoRemote> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(IOrderInfoRemote.class);
        serviceConfig.setRef(orderInfoRemoteImpl);
        serviceConfig.export();
        return serviceConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public ServiceConfig<IOrderDeliverRemote> orderDeliverRemoteServiceConfig(OrderDeliverRemoteImpl orderDeliverRemoteImpl) {
        ServiceConfig<IOrderDeliverRemote> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(IOrderDeliverRemote.class);
        serviceConfig.setRef(orderDeliverRemoteImpl);
        serviceConfig.export();
        return serviceConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public ServiceConfig<IOrderPickupRemote> orderPickupRemoteServiceConfig(OrderPickupRemoteImpl orderPickupRemoteImpl) {
        ServiceConfig<IOrderPickupRemote> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(IOrderPickupRemote.class);
        serviceConfig.setRef(orderPickupRemoteImpl);
        serviceConfig.export();
        return serviceConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public ServiceConfig<IOrderRefundRemote> orderRefundRemoteServiceConfig(OrderRefundRemoteImpl orderRefundRemoteImpl) {
        ServiceConfig<IOrderRefundRemote> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(IOrderRefundRemote.class);
        serviceConfig.setRef(orderRefundRemoteImpl);
        serviceConfig.export();
        return serviceConfig;
    }
}
