package com.zhss.eshop.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : liu heng
 * @description :
 * @date : 2023-04-13 00:11
 **/
@Configuration
public class MybatisConfig {
    /**
     * mybatis开启驼峰
     * @return 驼峰配置
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setMapUnderscoreToCamelCase(true);
    }
}
