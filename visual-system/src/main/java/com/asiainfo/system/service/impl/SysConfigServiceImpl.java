package com.asiainfo.system.service.impl;


import com.asiainfo.system.domain.SysConfig;
import com.asiainfo.system.service.ISysConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 参数配置 服务层实现
 * 
 * @author ruoyi
 */
@Service
public class SysConfigServiceImpl implements ISysConfigService
{

    /**
     * 项目启动时，初始化参数到缓存
     */
    @PostConstruct
    public void init()
    {

        System.out.println("hello");
    }

    @Override
    public List<SysConfig> selectConfigList(SysConfig config) {
        return null;
    }

    @Override
    public SysConfig selectConfigById(Long configId) {
        return null;
    }

    @Override
    public String selectConfigByKey(String configKey) {
        return null;
    }
}
