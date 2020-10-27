package com.asiainfo.common.core.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wangjingyuan
 */
@Entity
@Table( name = "UI_CONFIG" )
public class SysUiConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String configs;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConfigs() {
        return configs;
    }

    public void setConfigs(String configs) {
        this.configs = configs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
