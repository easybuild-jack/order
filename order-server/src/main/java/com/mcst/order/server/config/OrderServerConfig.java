package com.mcst.order.server.config;

import com.mcst.order.api.*;
import com.mcst.order.server.service.*;
import com.mcst.order.server.repository.*;
import com.mcst.order.server.impl.*;
import com.mcst.order.server.service.impl.*;
import com.mcst.order.server.repository.impl.*;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
/**
*
* @author liu yijun
*/
@Configuration
@EnableConfigurationProperties
public class OrderServerConfig {

    @Bean
    @ConditionalOnMissingBean
    public IPickupLocationApi pickupLocationApi() {
        return new PickupLocationApiServerImpl();
    }
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
    public IPickupLocationService pickupLocationService() {
        return new PickupLocationServiceImpl();
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
    public IOrderRefundGoodsRepository orderRefundGoodsRepository() {
        return new OrderRefundGoodsRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IPickupLocationRepository pickupLocationRepository() {
        return new PickupLocationRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderDeliverGoodsRepository orderDeliverGoodsRepository() {
        return new OrderDeliverGoodsRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderDeliverRepository orderDeliverRepository() {
        return new OrderDeliverRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderPickupRepository orderPickupRepository() {
        return new OrderPickupRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderPayRepository orderPayRepository() {
        return new OrderPayRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderAmountRepository orderAmountRepository() {
        return new OrderAmountRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderDiscountRepository orderDiscountRepository() {
        return new OrderDiscountRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderInfoRepository orderInfoRepository() {
        return new OrderInfoRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderRefundRepository orderRefundRepository() {
        return new OrderRefundRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderGoodsRepository orderGoodsRepository() {
        return new OrderGoodsRepositoryImpl();
    }


}
