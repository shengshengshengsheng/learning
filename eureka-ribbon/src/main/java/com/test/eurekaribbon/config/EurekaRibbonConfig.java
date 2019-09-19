package com.test.eurekaribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 应用配置类 EurekaRibbonConfig
 * 服务发现
 * @author ：XuQiangsheng
 * @date ：Created in 2019/9/18 9:13
 */
@Configuration
public class EurekaRibbonConfig {
    @Bean // 初始化 Bean
    @LoadBalanced // 实现负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
