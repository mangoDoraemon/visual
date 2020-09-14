package com.asiainfo.web.controller.tool;

import com.asiainfo.system.domain.Phone;
import com.asiainfo.system.domain.UserTable;

import com.asiainfo.system.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("测试类")
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @ApiOperation("查询主数据源")
    @GetMapping("/get")
    public List<UserTable> getOne(){
        return testService.getOne();
    }

    @GetMapping("/getPhone")
    public List<Phone> getPhone(){
        return testService.getPhone();
    }
}
