package com.asiainfo.system.service;

import com.asiainfo.system.domain.SysConfig;

import java.util.List;

/**
 * 参数配置 服务层
 * 
 * @author wangjingyuan
 */
public interface ISysConfigService
{

    /**
     * 查询参数配置列表
     * @param config 参数配置信息
     * @return 参数配置集合
     */
    List<SysConfig> selectConfigList(SysConfig config);

    /**
     * 查询参数配置信息
     *
     * @param configId 参数配置ID
     * @return 参数配置信息
     */
    public SysConfig selectConfigById(Long configId);

    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数键名
     * @return 参数键值
     */
    public String selectConfigByKey(String configKey);
}
