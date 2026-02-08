package com.mcst.order.config;

import com.mcst.order.controller.OrderDeliverController;
import com.mcst.order.controller.OrderInfoController;
import com.mcst.order.controller.OrderPickupController;
import com.mcst.order.controller.OrderRefundController;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * Order Client 控制器自动配置类
 *
 * @author Gemini
 */
@AutoConfiguration
public class OrderClientAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public OrderDeliverController orderDeliverController() {
        return new OrderDeliverController();
    }

    @Bean
    @ConditionalOnMissingBean
    public OrderInfoController orderInfoController() {
        return new OrderInfoController();
    }

    @Bean
    @ConditionalOnMissingBean
    public OrderPickupController orderPickupController() {
        return new OrderPickupController();
    }

    @Bean
    @ConditionalOnMissingBean
    public OrderRefundController orderRefundController() {
        return new OrderRefundController();
    }
}