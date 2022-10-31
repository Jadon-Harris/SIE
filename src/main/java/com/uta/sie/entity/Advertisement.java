package com.uta.sie.entity;

import java.io.Serializable;
import javax.annotation.Generated;

public class Advertisement implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.462+08:00", comments="Source field: advertisement.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.465+08:00", comments="Source field: advertisement.title")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.465+08:00", comments="Source field: advertisement.img_url")
    private String imgUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.465+08:00", comments="Source field: advertisement.admin_id")
    private Integer adminId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.465+08:00", comments="Source field: advertisement.school_id")
    private Integer schoolId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.466+08:00", comments="Source Table: advertisement")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.465+08:00", comments="Source field: advertisement.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.465+08:00", comments="Source field: advertisement.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.465+08:00", comments="Source field: advertisement.title")
    public String getTitle() {
        return title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.465+08:00", comments="Source field: advertisement.title")
    public void setTitle(String title) {
        this.title = title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.465+08:00", comments="Source field: advertisement.img_url")
    public String getImgUrl() {
        return imgUrl;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.465+08:00", comments="Source field: advertisement.img_url")
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.465+08:00", comments="Source field: advertisement.admin_id")
    public Integer getAdminId() {
        return adminId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.465+08:00", comments="Source field: advertisement.admin_id")
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.466+08:00", comments="Source field: advertisement.school_id")
    public Integer getSchoolId() {
        return schoolId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.466+08:00", comments="Source field: advertisement.school_id")
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.466+08:00", comments="Source Table: advertisement")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", adminId=").append(adminId);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}