package com.asiainfo.common.core.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wangjingyuan
 */
@Entity
@Table( name = "UI_TABLE" )
public class SysUiTable implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String coustdata;
    private String tabledata;
    private String dataname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoustdata() {
        return coustdata;
    }

    public void setCoustdata(String coustdata) {
        this.coustdata = coustdata;
    }

    public String getTabledata() {
        return tabledata;
    }

    public void setTabledata(String tabledata) {
        this.tabledata = tabledata;
    }

    public String getDataname() {
        return dataname;
    }

    public void setDataname(String dataname) {
        this.dataname = dataname;
    }
}
