package com.asiainfo.web.controller.system;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.asiainfo.common.core.controller.BaseController;
import com.asiainfo.common.core.domain.AjaxResult;
import com.asiainfo.common.core.domain.entity.*;
import com.asiainfo.common.utils.StringUtils;
import com.asiainfo.system.mapper.SysUiDataMapper;
import com.asiainfo.system.service.ISysUiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * UI组件操作
 * @author wangjingyuan
 */
@RestController
@RequestMapping("/data")
public class SysUiDataController extends BaseController {

    @Autowired
    private ISysUiDataService sysUiDataService;


    @RequestMapping("/save")
    public AjaxResult save(@RequestBody LinkedHashMap map, HttpServletRequest request, ModelMap model, SysUiData udd) {
        String reportId = map.get("reportId").toString();
        System.out.println("reportId:" + reportId);
        String reportName = map.get("reportName").toString();
        String userId = map.get("userId").toString();
        // String deleted = (String) map.get("reportId");
        String reportImage = map.get("reportImage").toString();
        String obj = map.get("obj").toString();
        if (StringUtils.isBlank(reportId)) {
            return AjaxResult.error("reportId为空");
        }
        SysUiData dt = new SysUiData();
        dt.setReportId(reportId);
        dt.setReportName(reportName);
        dt.setUserId(userId);
        dt.setDeleted("0");
        dt.setReportImage(reportImage);
        dt.setObj(obj);
        SysUiData d = sysUiDataService.getData(reportId);
        AjaxResult ar;
        if (d == null) {
            ar = sysUiDataService.saveData(dt);
        } else {
            ar = sysUiDataService.updateData(dt);
        }
        return ar;
    }

    @RequestMapping("/delete")
    public AjaxResult delete(@RequestBody LinkedHashMap map, HttpServletRequest request, ModelMap model) {
        String deleted = map.get("deleted").toString();
        String reportId = map.get("reportId").toString();
        if ("1".equals(deleted)) {// 放入回收站
            AjaxResult ar = sysUiDataService.updataStatus(reportId, deleted);
            return ar;
        } else if ("2".equals(deleted)) {// 从库里删除记录
            AjaxResult ar = sysUiDataService.deleteData(reportId, deleted);
            return ar;
        } else if ("3".equals(deleted)) {// 回收站还原
            AjaxResult ar = sysUiDataService.updataStatus(reportId, "0");
            return ar;
        }
        return null;
    }

    @RequestMapping("/find")
    public AjaxResult find(@RequestBody LinkedHashMap map, HttpServletRequest request, ModelMap model) {
        String userId = map.get("userId").toString();
        String deleted = map.get("deleted").toString();
        String reportId = map.get("reportId").toString();
        if (StringUtils.isBlank(reportId)) {
            List<SysUiData> list = sysUiDataService.findData(userId, deleted, reportId);
            for (SysUiData a : list) {
                a.setObj("");
            }
            return AjaxResult.success("查询成功", list);
        } else {
            List<SysUiData> list = sysUiDataService.findData(userId, deleted, reportId);
            return AjaxResult.success("查询成功", list);
        }
    }

    @RequestMapping("/getBar")
    public AjaxResult getBar(HttpServletRequest request, ModelMap model) {
        String id = request.getParameter("id");
        List<SysUiBar> list = sysUiDataService.getUiBar(id);
        return AjaxResult.success("查询成功", list);
    }

    @RequestMapping("/getUiLine")
    public AjaxResult getUiLine(HttpServletRequest request, ModelMap model) {
        String id = request.getParameter("id");
         List<SysUiLine> list = sysUiDataService.getUiLine(id);
        return AjaxResult.success("查询成功", list);
    }

    @RequestMapping("/getUiMix")
    public AjaxResult getUiMix(HttpServletRequest request, ModelMap model) {
        String id = request.getParameter("id");
        List<SysUiMix> list = sysUiDataService.getUiMix(id);
        return AjaxResult.success("查询成功", list);
    }

    @RequestMapping("/getUiPie")
    public AjaxResult getUiPie(HttpServletRequest request, ModelMap model) {
        String id = request.getParameter("id");
        List<SysUiPie> list = sysUiDataService.getUiPie(id);
        return AjaxResult.success("查询成功", list);
    }

    @RequestMapping("/getUiRadartu")
    public AjaxResult getUiRadartu(HttpServletRequest request, ModelMap model) {
        String id = request.getParameter("id");
        List<SysUiRadartu> list = sysUiDataService.getUiRadartu(id);
        return AjaxResult.success("查询成功", list);
    }

    @RequestMapping("/getUiTransverse")
    public AjaxResult getUiTransverse(HttpServletRequest request, ModelMap model) {
        String id = request.getParameter("id");
        List<SysUiTransverse> list = sysUiDataService.getUiTransverse(id);
        return AjaxResult.success("查询成功", list);
    }

    @RequestMapping("/getUiTable")
    public AjaxResult getUiTable(HttpServletRequest request, ModelMap model) {
        String id = request.getParameter("id");
        List<SysUiTable> list = sysUiDataService.getUiTable(id);
        JSONArray ja = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            JSONObject js1 = new JSONObject();
            JSONObject js2 = new JSONObject();
            js2.put("coustData", list.get(i).getCoustdata());
            js2.put("tableData", list.get(i).getTabledata());
            js1.put("obj", js2);
            js1.put("id", list.get(i).getId());
            js1.put("dataname", list.get(i).getDataname());
            ja.add(js1);
        }
        return AjaxResult.success("查询成功", ja);
    }

    @RequestMapping("/getOpction")
    public AjaxResult getOpction(HttpServletRequest request, ModelMap model) {
        String type = request.getParameter("type");
        SysUiOpction uo = sysUiDataService.getUiOpction(type);
        return AjaxResult.success("查询成功", uo);
    }

    @RequestMapping("/getConfig")
    public AjaxResult getConfig(HttpServletRequest request, ModelMap model) {
        String type = request.getParameter("type").trim();
        SysUiConfig uc = sysUiDataService.getUiconfig(type);
        return AjaxResult.success("查询成功", uc);
    }


}
