package com.asiainfo.web.controller.system;

import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.common.core.page.TableDataInfo;
import com.asiainfo.system.domain.SysConfig;
import com.asiainfo.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 参数配置 信息操作处理
 *
 * @author wangjingyuan
 */
@RestController
@RequestMapping("/system/config")
public class SysConfigController extends BaseController {
    @Autowired
    private ISysConfigService configService;

    /**
     * 获取参数配置列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysConfig config)
    {

        startPage();
        List<SysConfig> list = configService.selectConfigList(config);
        return getDataTable(list);
    }

}
