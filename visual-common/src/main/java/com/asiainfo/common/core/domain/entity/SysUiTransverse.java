package com.asiainfo.common.core.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wangjingyuan
 */
@Entity
@Table( name = "UI_TRANSVERSE" )
public class SysUiTransverse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String obj;
    private String dataname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
