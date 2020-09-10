package com.asiainfo.framework.datasource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangjingyuan
 */
public class DataSourceContextHolder {

    public static final Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);

    private static final String DEFAULT_DATASOURCE = "PRIMARY_DATASOURCE";

    /**
     * 使用ThreadLocal维护变量，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
     *  所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * 设置数据源的变量
     */
    public static void setDataSource(String dbType){
        log.info("切换到["+dbType+"]数据源");
        contextHolder.set(dbType);
    }

    /**
     * 获得数据源的变量
     */
    public static String getDataSource(){
        return contextHolder.get();
    }

    /**
     * 清空数据源变量
     */
    public static void clearDataSource(){
        contextHolder.remove();
    }
}
