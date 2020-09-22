package com.asiainfo.system.service.impl;


import com.asiainfo.common.core.redis.RedisCache;
import com.asiainfo.system.mapper.SysConfigMapper;
import com.asiainfo.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
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

    }
}
