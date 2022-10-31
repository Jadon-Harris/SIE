package com.uta.sie.entity;

import java.io.Serializable;
import javax.annotation.Generated;

public class BillboardPost implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.47+08:00", comments="Source field: billboard_post.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.47+08:00", comments="Source field: billboard_post.title")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: billboard_post.content")
    private String content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: billboard_post.school_id")
    private Integer schoolId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source Table: billboard_post")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.47+08:00", comments="Source field: billboard_post.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.47+08:00", comments="Source field: billboard_post.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.47+08:00", comments="Source field: billboard_post.title")
    public String getTitle() {
        return title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: billboard_post.title")
    public void setTitle(String title) {
        this.title = title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: billboard_post.content")
    public String getContent() {
        return content;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: billboard_post.content")
    public void setContent(String content) {
        this.content = content;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: billboard_post.school_id")
    public Integer getSchoolId() {
        return schoolId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: billboard_post.school_id")
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source Table: billboard_post")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}