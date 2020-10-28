package com.asiainfo.system.service.impl;

import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.core.domain.entity.SysUiData;
import com.asiainfo.common.core.domain.entity.UiResource;
import com.asiainfo.common.core.domain.entity.UiUser;
import com.asiainfo.system.mapper.*;
import com.asiainfo.system.service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IndexServiceImpl implements IIndexService {
    @Autowired
    private UiUserMapper uiUserMapper;


    @Override
    public UiUser getUiUser(String username) {
        Example example = new Example(UiUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("user_name", username);
        return uiUserMapper.selectOneByExample(example);
    }

}

