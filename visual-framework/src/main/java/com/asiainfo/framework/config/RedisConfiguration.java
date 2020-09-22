//package com.asiainfo.framework.config;
//
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
///**
// * redis多数据源配置
// *
// * @author wangjingyuan
// */
//@Configuration
//public class RedisConfiguration {
//
//    /**
//     * 配置lettuce连接池
//     *
//     * @return
//     */
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "spring.redis.cluster.lettuce.pool")
//    public GenericObjectPoolConfig redisPool() {
//        return new GenericObjectPoolConfig();
//    }
//}
