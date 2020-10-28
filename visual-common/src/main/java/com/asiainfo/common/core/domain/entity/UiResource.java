package com.asiainfo.common.core.domain.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhang
 */
@Table(name = "ui_resource")
public class UiResource {
    @Id
    private String id;
    private String classname;
    private String imgurl;
    private Date create_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }


}
