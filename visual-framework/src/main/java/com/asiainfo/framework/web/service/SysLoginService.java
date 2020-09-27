package com.asiainfo.framework.web.service;

import com.asiainfo.common.constant.Constants;
import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.core.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 登录校验方法
 *
 * @author wangjingyuan
 */
@Component
public class SysLoginService {

    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    /**
     * 登录验证
     *
     * @param userName 用户名
     * @param userPwd 密码
     * @param uuid 唯一标识
     * @return 结果
     */
    public String login(String userName, String userPwd, String uuid)
    {
        //Todo 登录验证逻辑
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

        // 用户验证
        Authentication authentication = null;
          return null;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {

        AjaxResult ajax = AjaxResult.success();

        return ajax;
    }
}
