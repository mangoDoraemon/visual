package com.asiainfo.system.service;

import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.core.domain.entity.UiResource;
import com.asiainfo.common.core.domain.entity.UiUser;

import java.util.List;


/**
 * @author zhang
 */
public interface IIndexService {


    UiUser getUiUser(String username);
}
