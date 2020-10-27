//package com.asiainfo.framework.redis;
//
//import com.asiainfo.common.utils.StringUtils;
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
//import org.springframework.beans.factory.config.ConstructorArgumentValues;
//import org.springframework.beans.factory.support.*;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.boot.context.properties.bind.Binder;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
//import org.springframework.core.env.Environment;
//import org.springframework.core.type.AnnotationMetadata;
//import org.springframework.data.redis.connection.RedisClusterConfiguration;
//import org.springframework.data.redis.connection.RedisNode;
//import org.springframework.data.redis.connection.RedisPassword;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import java.time.Duration;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.NoSuchElementException;
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.function.Supplier;
//
///**
// * @author wangjingyuan
// */
//@SuppressWarnings("unchecked")
//public class DynamicRedisRegister implements EnvironmentAware,ImportBeanDefinitionRegistrar {
//
//    private static final Logger logger = LoggerFactory.getLogger(DynamicRedisRegister.class);
//    private static Map<String, Object> registerBean = new ConcurrentHashMap<>();
//    private Environment env;
//    private Binder binder;
//
//
//    /**
//     * ImportBeanDefinitionRegistrar
//     *
//     * @param annotationMetadata     annotationMetadata
//     * @param beanDefinitionRegistry beanDefinitionRegistry
//     */
//    @Override
//    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
//        // get all redis config
//        Map<String, Map> multipleRedis;
//        try {
//            multipleRedis = binder.bind("fastdep.redis", Map.class).get();
//        } catch (NoSuchElementException e) {
//            logger.error("Failed to configure fastDep redis: 'fastdep.redis' attribute is not specified and no embedded redis could be configured.");
//            return;
//        }
//        boolean onPrimary = true;
//        for (String key : multipleRedis.keySet()) {
//            Map map = binder.bind("fastdep.redis." + key, Map.class).get();
//            // RedisClusterConfiguration
//            RedisClusterConfiguration configuration = new RedisClusterConfiguration();
//            String[] serverArray = String.valueOf(map.get("cluster")).split(",");
//            Set<RedisNode> nodes = new HashSet<RedisNode>();
//            for (String ipPort:serverArray
//                 ) {
//                 String[] ipAndPort = ipPort.split(":");
//                 nodes.add(new RedisNode(ipAndPort[0].trim(),Integer.valueOf(ipAndPort[1])));
//            }
//            configuration.setClusterNodes(nodes);
//            String password = String.valueOf(map.get("password"));
//            if (!StringUtils.isEmpty(password)) {
//                RedisPassword redisPassword = RedisPassword.of(password);
//                configuration.setPassword(redisPassword);
//            }
//            // GenericObjectPoolConfig
//            GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
//            try {
//                RedisProperties.Pool pool = binder.bind("fastdep.redis." + key + ".lettuce.pool", RedisProperties.Pool.class).get();
//                genericObjectPoolConfig.setMaxIdle(pool.getMaxIdle());
//                genericObjectPoolConfig.setMaxTotal(pool.getMaxActive());
//                genericObjectPoolConfig.setMinIdle(pool.getMinIdle());
//                if (pool.getMaxWait() != null) {
//                    genericObjectPoolConfig.setMaxWaitMillis(pool.getMaxWait().toMillis());
//                }
//            } catch (NoSuchElementException ignore) {
//            }
//            //LettuceConnectionFactory
//            Supplier<LettuceConnectionFactory> lettuceConnectionFactorySupplier = () -> {
//                LettuceConnectionFactory factory = (LettuceConnectionFactory) registerBean.get(key + "LettuceConnectionFactory");
//                if (factory != null) {
//                    return factory;
//                }
//                LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();
//                try {
//                    Duration shutdownTimeout = binder.bind("fastdep.redis." + key + ".shutdown-timeout", Duration.class).get();
//                    if (shutdownTimeout != null) {
//                        builder.shutdownTimeout(shutdownTimeout);
//                    }
//                } catch (NoSuchElementException ignore) {
//                }
//                LettuceClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder().poolConfig(genericObjectPoolConfig).build();
//                factory = new LettuceConnectionFactory(configuration, clientConfiguration);
//                registerBean.put(key + "LettuceConnectionFactory", factory);
//                return factory;
//            };
//            LettuceConnectionFactory lettuceConnectionFactory = lettuceConnectionFactorySupplier.get();
//            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(LettuceConnectionFactory.class, lettuceConnectionFactorySupplier);
//            AbstractBeanDefinition factoryBean = builder.getRawBeanDefinition();
//            factoryBean.setPrimary(onPrimary);
//            beanDefinitionRegistry.registerBeanDefinition(key + "LettuceConnectionFactory", factoryBean);
//            // StringRedisTemplate
//            GenericBeanDefinition stringRedisTemplate = new GenericBeanDefinition();
//            stringRedisTemplate.setBeanClass(StringRedisTemplate.class);
//            ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
//            constructorArgumentValues.addIndexedArgumentValue(0, lettuceConnectionFactory);
//            stringRedisTemplate.setConstructorArgumentValues(constructorArgumentValues);
//            stringRedisTemplate.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_NAME);
//            beanDefinitionRegistry.registerBeanDefinition(key + "StringRedisTemplate", stringRedisTemplate);
//            // RedisTemplate
//            GenericBeanDefinition redisTemplate = new GenericBeanDefinition();
//            redisTemplate.setBeanClass(RedisTemplate.class);
//            redisTemplate.getPropertyValues().add("connectionFactory", lettuceConnectionFactory);
//            redisTemplate.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_NAME);
//            beanDefinitionRegistry.registerBeanDefinition(key + "RedisTemplate", redisTemplate);
//            logger.info("Registration redis ({}) !", key);
//            if (onPrimary) {
//                onPrimary = false;
//            }
//        }
//        logger.info("Registration redis completed !");
//    }
//
//
//    /**
//     * init environment
//     *
//     * @param environment environment
//     */
//    @Override
//    public void setEnvironment(Environment environment) {
//        this.env = environment;
//        // bing binder
//        binder = Binder.get(this.env);
//    }
//}
