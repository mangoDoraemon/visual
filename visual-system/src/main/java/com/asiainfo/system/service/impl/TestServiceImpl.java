package com.asiainfo.system.service.impl;


import com.asiainfo.common.annotation.DataSourceSign;
import com.asiainfo.common.enums.ContextConst;
import com.asiainfo.system.domain.Phone;
import com.asiainfo.system.domain.UserTable;
import com.asiainfo.system.mapper.TestMapper;
import com.asiainfo.system.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {


    @Resource
    TestMapper testMapper;

    @Override
    public List<UserTable> getOne() {
        return testMapper.getOne();
    }

    @DataSourceSign(ContextConst.DataSourceType.LOCAL)
    @Override
    public List<Phone> getPhone() {
        return testMapper.getPhone();
    }
}
