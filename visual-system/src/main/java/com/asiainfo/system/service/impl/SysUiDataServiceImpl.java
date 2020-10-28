package com.asiainfo.system.service.impl;

import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.core.domain.entity.*;
import com.asiainfo.system.mapper.*;
import com.asiainfo.system.service.ISysUiDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * UI基本组件操作
 * @author wangjingyuan
 */
@Service
public class SysUiDataServiceImpl implements ISysUiDataService {


    @Autowired
    private SysUiOpctionMapper sysUiOpctionMapper;
    @Autowired
    private SysUiRadarTuMapper sysUiRadarTuMapper;
    @Autowired
    private SysUiTableMapper sysUiTableMapper;
    @Autowired
    private SysUiTransverseMapper sysUiTransverseMapper;
    @Autowired
    private SysUiPieMapper sysUiPieMapper;
    @Autowired
    private SysUiDataMapper sysUiDataMapper;

    @Autowired
    private SysUiConfigMapper sysUiConfigMapper;

    @Autowired
    private SysUiBarMapper sysUiBarMapper;

    @Autowired
    private SysUiDataTableMapper sysUiDataTableMapper;

    @Autowired
    private SysUiLineMapper sysUiLineMapper;

    @Autowired
    private SysUiMixMapper sysUiMixMapper;



    @Override
    public SysUiData getData(String reportId) {
        Example example = new Example(SysUiData.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("reportId", reportId);
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
        example.createCriteria().andEqualTo("reportId",dt.getReportId());
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
        example.createCriteria().andEqualTo("reportId",reportId);
        sysUiDataMapper.deleteByExample(example);
        return AjaxResult.success("删除成功");
    }

    @Override
    public List<SysUiData> findData(String userId, String deleted, String reportId) {
        Example example = new Example(SysUiData.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(reportId)){
            criteria.andEqualTo("reportId",reportId);
        }
        criteria.andEqualTo("userId", userId);
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

        return sysUiLineMapper.selectByExample(example);
    }

    @Override
    public List<SysUiMix> getUiMix(String id) {
        Example example = new Example(SysUiMix.class);
        if(StringUtils.isNotBlank(id)){
            example.createCriteria().andEqualTo("id", id);
        }
        return sysUiMixMapper.selectByExample(example);
    }

    @Override
    public List<SysUiPie> getUiPie(String id) {
        Example example = new Example(SysUiPie.class);
        if(StringUtils.isNotBlank(id)){
            example.createCriteria().andEqualTo("id", id);
        }
        return sysUiPieMapper.selectByExample(example);
    }

    @Override
    public List<SysUiRadartu> getUiRadartu(String id) {
        Example example = new Example(SysUiRadartu.class);
        if(StringUtils.isNotBlank(id)){
            example.createCriteria().andEqualTo("id", id);
        }
        return sysUiRadarTuMapper.selectByExample(example);
    }

    @Override
    public List<SysUiTransverse> getUiTransverse(String id) {
        Example example = new Example(SysUiTransverse.class);
        if(StringUtils.isNotBlank(id)){
            example.createCriteria().andEqualTo("id", id);
        }
        return sysUiTransverseMapper.selectByExample(example);
    }


    @Override
    public List<SysUiTable> getUiTable(String id) {
        Example example = new Example(SysUiTable.class);
        if(StringUtils.isNotBlank(id)){
            example.createCriteria().andEqualTo("id", id);
        }
        return sysUiTableMapper.selectByExample(example);
    }


    @Override
    public SysUiConfig getUiconfig(String type) {
        Example example = new Example(SysUiConfig.class);
        example.createCriteria().andEqualTo("type", type);
        return sysUiConfigMapper.selectOneByExample(example);
    }

    @Override
    public SysUiOpction getUiOpction(String type) {
        Example example = new Example(SysUiOpction.class);
        example.createCriteria().andEqualTo("type", type);
        return sysUiOpctionMapper.selectOneByExample(example);
    }


    @Override
    public List<SysUiDataTable> getUiDataTable(String id) {
        Example example = new Example(SysUiDataTable.class);
        if(StringUtils.isNotBlank(id)){
            example.createCriteria().andEqualTo("id", id);
            return sysUiDataTableMapper.selectByExample(example);
        }
        return sysUiDataTableMapper.selectByExample(example);
    }

    @Override
    public List<SysUiDataTable> getUserList(String userId, String type) {
        Example example = new Example(SysUiDataTable.class);
        Example.Criteria criteria = example.createCriteria();


        List<String> list = new ArrayList<String>();
        list.add("map2D");
        list.add("radartu");
        if (StringUtils.isNotBlank(userId)) {
            criteria.andEqualTo("user_id",userId);

        }
        if (StringUtils.isNotBlank(type)) {
            if ("radartu".equals(type)) {
                criteria.andEqualTo("type",type);

            } else if ("map2D".equals(type)) {
                criteria.andEqualTo("type",type);

            } else {
                criteria.andNotIn("type",list);

            }
        }
        example.setOrderByClause("create_time desc");
//        criteria.andCondition("create_time", "desc");
//        builder.setOrder("create_time", "desc");

        return sysUiDataTableMapper.selectByExample(example);
    }


    @Override
    public void saveUiDataTable(SysUiDataTable ut) {
//        Example example = new Example(SysUiDataTable.class);
//        sysUiDataTableMapper.save(example, ut);
        sysUiDataTableMapper.insertSelective(ut);
    }

    @Override
    public AjaxResult deleteUiDataTable(String id) {
        Example example = new Example(SysUiDataTable.class);
        example.createCriteria().andEqualTo("id", id);
        sysUiDataTableMapper.deleteByExample(example);
        return AjaxResult.success("删除成功");
    }


}
