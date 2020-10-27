//package com.asiainfo.framework.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.bind.Binder;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.core.env.MapPropertySource;
//import org.springframework.data.redis.connection.RedisClusterConfiguration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * redis配置
// *
// * @author wangjingyuan
// */
//@Configuration
//@EnableCaching
//public class RedisConfig extends CachingConfigurerSupport
//{
//
//
//    @Autowired
//    private Environment environment;
//
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.redis.cluster.lettuce.pool")
//    public GenericObjectPoolConfig redisPool(){ ;
//        return new GenericObjectPoolConfig();
//    }
//
//    @Bean
//    public RedisClusterConfiguration redisClusterConfig(){
//        Map<String, Object> source = new HashMap<>(8);
//        source.put("spring.redis.cluster.nodes", environment.getProperty("spring.redis.cluster.nodes"));
//        System.out.println(source);
//        RedisClusterConfiguration redisClusterConfiguration;
//        redisClusterConfiguration = new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", source));
//        redisClusterConfiguration.setPassword(environment.getProperty("spring.redis.password"));
//        return redisClusterConfiguration;
//
//    }
//
//
//    @Bean
//    public LettuceConnectionFactory lettuceConnectionFactory(GenericObjectPoolConfig redisPool,RedisClusterConfiguration redisClusterConfig) {
//        LettuceClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder().poolConfig(redisPool).build();
//        return new LettuceConnectionFactory(redisClusterConfig, clientConfiguration);
//    }
//
//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate( RedisConnectionFactory redisConnectionFactory) {
//        return getRedisTemplate(redisConnectionFactory);
//
//    }
//
//
//
//    public RedisTemplate<Object, Object> getRedisTemplate(RedisConnectionFactory connectionFactory)
//    {
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//
//        FastJson2JsonRedisSerializer serializer = new FastJson2JsonRedisSerializer(Object.class);
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        serializer.setObjectMapper(mapper);
//
//        template.setValueSerializer(serializer);
//        // 使用StringRedisSerializer来序列化和反序列化redis的key值
//        template.setKeySerializer(new StringRedisSerializer());
//        template.afterPropertiesSet();
//        return template;
//    }
//}
