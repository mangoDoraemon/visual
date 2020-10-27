package com.asiainfo.common.core.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wangjingyuan
 */
@Entity
@Table( name = "UI_OPCTION" )
public class SysUiOpction implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String opction;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpction() {
        return opction;
    }

    public void setOpction(String opction) {
        this.opction = opction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
