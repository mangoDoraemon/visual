package com.asiainfo.web.controller.common;

import com.asiainfo.common.core.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通用处理类
 *
 * @author wangjingyuan
 */
@RestController
public class CommonController {

    @Autowired
    RedisCache redisCache;

    @GetMapping("test")
    public void test(){
     redisCache.setCacheObject("hello4","hello4");
    }
}
