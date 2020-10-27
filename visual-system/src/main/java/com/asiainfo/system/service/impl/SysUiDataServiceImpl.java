package com.asiainfo.system.service.impl;

import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.core.domain.entity.*;
import com.asiainfo.system.mapper.SysUiBarMapper;
import com.asiainfo.system.mapper.SysUiConfigMapper;
import com.asiainfo.system.mapper.SysUiDataMapper;
import com.asiainfo.system.service.ISysUiDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * UI基本组件操作
 * @author wangjingyuan
 */
@Service
public class SysUiDataServiceImpl implements ISysUiDataService {

    @Autowired
    private SysUiDataMapper sysUiDataMapper;

    @Autowired
    private SysUiConfigMapper sysUiConfigMapper;

    @Autowired
    private SysUiBarMapper sysUiBarMapper;


    @Override
    public SysUiData getData(String reportId) {
        Example example = new Example(SysUiData.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("report_id", reportId);
        return sysUiDataMapper.selectOneByExample(example);
    }

    @Override
    public AjaxResult saveData(SysUiData sysUiData) {
        sysUiData.setInsertTime(new Date());
        sysUiData.setUpdateTime(new Date());
        sysUiDataMapper.insertSelective(sysUiData);
        return AjaxResult.success("保存成功");
    }

    @Override
    public AjaxResult updateData(SysUiData dt) {
        Example example = new Example(SysUiData.class);
        example.createCriteria().andEqualTo("report_id",dt.getReportId());
        sysUiDataMapper.updateByExampleSelective(dt,example);
        return AjaxResult.success("保存成功");
    }

    @Override
    public AjaxResult updataStatus(String reportId, String deleted) {
        sysUiDataMapper.updateStatusById(reportId,deleted);
        if ("0".equals(deleted)) {
            return AjaxResult.success("还原成功");
        } else {
            return AjaxResult.success("删除成功");
        }
    }

    @Override
    public AjaxResult deleteData(String reportId, String deleted) {
        Example example = new Example(SysUiData.class);
        example.createCriteria().andEqualTo("report_id",reportId);
        sysUiDataMapper.deleteByExample(example);
        return AjaxResult.success("删除成功");
    }

    @Override
    public List<SysUiData> findData(String userId, String deleted, String reportId) {
        Example example = new Example(SysUiData.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(reportId)){
            criteria.andEqualTo("report_id",reportId);
        }
        criteria.andEqualTo("user_id", userId);
        criteria.andEqualTo("deleted", deleted);


        return sysUiDataMapper.selectByExample(example);
    }

    @Override
    public List<SysUiBar> getUiBar(String id) {
        Example example = new Example(SysUiBar.class);
        if(StringUtils.isNotBlank(id)){
            example.createCriteria().andEqualTo("id", id);
        }

        return sysUiBarMapper.selectByExample(example);
    }

    @Override
    public List<SysUiLine> getUiLine(String id) {
        Example example = new Example(SysUiLine.class);
        if(StringUtils.isNotBlank(id)){
            example.createCriteria().andEqualTo("id", id);
        }

        return null;
    }

    @Override
    public List<SysUiMix> getUiMix(String id) {
        return null;
    }

    @Override
    public List<SysUiPie> getUiPie(String id) {
        return null;
    }

    @Override
    public List<SysUiRadartu> getUiRadartu(String id) {
        return null;
    }

    @Override
    public List<SysUiTransverse> getUiTransverse(String id) {
        return null;
    }

    @Override
    public List<SysUiTable> getUiTable(String id) {
        return null;
    }

    @Override
    public SysUiOpction getUiOpction(String type) {
        return null;
    }

    @Override
    public SysUiConfig getUiconfig(String type) {
        Example example = new Example(SysUiConfig.class);
        example.createCriteria().andEqualTo("type", type);
        return sysUiConfigMapper.selectOneByExample(example);
    }


}
