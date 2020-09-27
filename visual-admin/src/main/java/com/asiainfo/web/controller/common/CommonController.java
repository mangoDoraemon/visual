package com.asiainfo.web.controller.common;

import com.asiainfo.common.core.redis.RedisCache;
import com.asiainfo.common.utils.http.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
    public String test(){
        System.out.println("你好哇");
        redisCache.setCacheObject("wjy","qwe");
        String a= redisCache.getCacheObject("wjy");
        return a;

    }

    @PostMapping("test1")
    public void test1(@RequestParam("name") String name,@RequestParam("phone") String phone){
 System.out.println(name);
 System.out.println(phone);
    }

    public static void main(String[] args) throws IOException {

    }
}
