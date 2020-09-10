package com.asiainfo.framework.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.asiainfo.common.enums.ContextConst;
import com.asiainfo.framework.datasource.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author wangjingyuan
 */
@Configuration
public class MutiplyDataSource {
    //@Primary注解在哪个ds，默认使用那个ds

    @Bean(name = "dataSourcePrimary")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource(){
        return new DruidDataSource();
    }
    @Bean(name = "dataSourceLocal")
    @ConfigurationProperties(prefix = "spring.datasource.local")
    public DataSource localDataSource(){
        return new DruidDataSource();
    }

    @Bean(name = "dataSourceProd")
    @ConfigurationProperties(prefix = "spring.datasource.prod")
    public DataSource prodDataSource(){
        return new DruidDataSource();
    }

    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //配置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(primaryDataSource());

        //配置多数据源
        HashMap<Object, Object> dataSourceMap = new HashMap();
        dataSourceMap.put(ContextConst.DataSourceType.PRIMARY.name(),primaryDataSource());
        dataSourceMap.put(ContextConst.DataSourceType.LOCAL.name(),localDataSource());
        dataSourceMap.put(ContextConst.DataSourceType.PROD.name(),prodDataSource());
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事务
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}