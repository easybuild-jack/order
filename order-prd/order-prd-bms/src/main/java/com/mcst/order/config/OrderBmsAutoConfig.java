package com.mcst.order.config;

import com.mcst.order.controller.OrderContainerBmsController;
import com.mcst.order.controller.OrderDeliverBmsController;
import com.mcst.order.controller.OrderInfoBmsController;
import com.mcst.order.controller.OrderPickupBmsController;
import com.mcst.order.controller.OrderRefundBmsController;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * Order BMS 控制器自动配置类
 *
 * @author Gemini
 */
@AutoConfiguration
public class OrderBmsAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public OrderContainerBmsController orderContainerBmsController() {
        return new OrderContainerBmsController();
    }

    @Bean
    @ConditionalOnMissingBean
    public OrderDeliverBmsController orderDeliverBmsController() {
        return new OrderDeliverBmsController();
    }

    @Bean
    @ConditionalOnMissingBean
    public OrderInfoBmsController orderInfoBmsController() {
        return new OrderInfoBmsController();
    }

    @Bean
    @ConditionalOnMissingBean
    public OrderPickupBmsController orderPickupBmsController() {
        return new OrderPickupBmsController();
    }

    @Bean
    @ConditionalOnMissingBean
    public OrderRefundBmsController orderRefundBmsController() {
        return new OrderRefundBmsController();
    }
}