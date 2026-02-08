package com.mcst.order.remote.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author liu yijun
 * @since 2025-10-17
 */
@ConfigurationProperties(prefix = "easyfk.config.remote.order")
@Data
public class OrderApiProperties {
    /**
     * Order模块的ServiceId配置
     */
    private String serviceId;
    /**
     * path 前缀地址，如：/remote 或/api 等，默认/remote
     */
    private String basePath;
}
