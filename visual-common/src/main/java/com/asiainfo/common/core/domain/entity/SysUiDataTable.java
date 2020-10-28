package com.asiainfo.common.core.domain.entity;

import com.asiainfo.common.utils.DateUtils;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;


import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Entity
@Table( name = "UI_DATA_TABLE" )
public class SysUiDataTable implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String user_id;
    private String columns;
    private String obj;
    private String dataname;

    //哪种类型图形
    private String type;
    private Date create_time;

    //用户创建类型为1，同步数据类型为2
    private String user_type;
    private String typetwo;
    private String rowtype;

    @Transient
    private String create_time_show;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getDataname() {
        return dataname;
    }

    public void setDataname(String dataname) {
        this.dataname = dataname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
    public String getCreate_time_show() {
        if (create_time!=null) {
            create_time_show = DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss",create_time);
        }
        return create_time_show;
    }
    public void setCreate_time_show(String create_time_show) {
        this.create_time_show = create_time_show;
    }

    public String getTypetwo() {
        return typetwo;
    }

    public void setTypetwo(String typetwo) {
        this.typetwo = typetwo;
    }

    public String getRowtype() {
        return rowtype;
    }

    public void setRowtype(String rowtype) {
        this.rowtype = rowtype;
    }


}

