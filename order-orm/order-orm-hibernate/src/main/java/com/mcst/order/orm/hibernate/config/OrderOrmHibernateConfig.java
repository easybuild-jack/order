package com.mcst.order.orm.hibernate.config;

import com.mcst.order.orm.hibernate.repository.impl.*;
import com.mcst.order.orm.repository.*;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author liu yijun
 */
@AutoConfiguration
@EnableConfigurationProperties
public class OrderOrmHibernateConfig {

    @Bean
    @ConditionalOnMissingBean
    public IOrderInfoRepository orderInfoRepository() {
        return new OrderInfoRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderAmountRepository orderAmountRepository() {
        return new OrderAmountRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderGoodsRepository orderGoodsRepository() {
        return new OrderGoodsRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderDeliverRepository orderDeliverRepository() {
        return new OrderDeliverRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderDeliverGoodsRepository orderDeliverGoodsRepository() {
        return new OrderDeliverGoodsRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderContainerRepository orderContainerRepository() {
        return new OrderContainerRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderPayRepository orderPayRepository() {
        return new OrderPayRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderPickupRepository orderPickupRepository() {
        return new OrderPickupRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderRefundRepository orderRefundRepository() {
        return new OrderRefundRepositoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public IOrderRefundGoodsRepository orderRefundGoodsRepository() {
        return new OrderRefundGoodsRepositoryImpl();
    }

}
