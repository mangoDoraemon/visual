package com.asiainfo.web.controller.system;

import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.core.domain.entity.UiUser;
import com.asiainfo.system.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/serviceTool")
public class IndexController {



    @Autowired
    private IIndexService indexService;
    /**
     * 登录页面
     *
     * @return
     */
//    @NoLogin
    @RequestMapping("/login")
    public String login() {
        return "/index";
    }

    /**
     * 登录验证
     *
     * @return
     * @throws UnsupportedEncodingException
     */
//    @NoLogin
    @RequestMapping("/verify")
    public AjaxResult verify(@RequestBody LinkedHashMap map) throws UnsupportedEncodingException {
        String userName = map.get("userName").toString();
        String password = map.get("password").toString();
        System.out.println("userName:" + userName);
        System.out.println("password:" + password);
        UiUser uu = indexService.getUiUser(userName);
        if (uu == null) {
            return AjaxResult.error("用户不存在");
        }
        if (!(password.equals(uu.getPassword()))) {
            return AjaxResult.error("输入密码错误");
        }
        if (password.equals(uu.getPassword())) {
//            WebContextUtils.setSessionUser(uu);
            return AjaxResult.success("登录成功");
        }
        return null;
    }

}
