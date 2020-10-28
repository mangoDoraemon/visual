package com.asiainfo.system.service;

import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.core.domain.entity.*;

import java.util.List;

/**
 * ui基本组件操作
 * @author wangjingyuan
 */
public interface ISysUiDataService {
    SysUiData getData(String reportId);

    AjaxResult saveData(SysUiData dt);

    AjaxResult updateData(SysUiData dt);

    AjaxResult updataStatus(String reportId, String deleted);

    AjaxResult deleteData(String reportId, String deleted);

    List<SysUiData> findData(String userId, String deleted, String reportId);

    SysUiConfig getUiconfig(String type);

    List<SysUiBar> getUiBar(String id);

    List<SysUiLine> getUiLine(String id);

    List<SysUiMix> getUiMix(String id);

    List<SysUiPie> getUiPie(String id);

    List<SysUiRadartu> getUiRadartu(String id);

    List<SysUiTransverse> getUiTransverse(String id);

    List<SysUiTable> getUiTable(String id);

    SysUiOpction getUiOpction(String type);

    List<SysUiDataTable> getUiDataTable(String id);

    void saveUiDataTable(SysUiDataTable ut);

    AjaxResult deleteUiDataTable(String id);

    List<SysUiDataTable> getUserList(String userId, String type);



}
