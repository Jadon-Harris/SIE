package com.uta.sie.entity;

import java.io.Serializable;
import javax.annotation.Generated;

public class Club implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.description")
    private String description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.school_id")
    private Long schoolId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.student_id")
    private Long studentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.image_url")
    private String imageUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source Table: club")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.description")
    public String getDescription() {
        return description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.school_id")
    public Long getSchoolId() {
        return schoolId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.school_id")
    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.student_id")
    public Long getStudentId() {
        return studentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.student_id")
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source field: club.image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.45+08:00", comments="Source Table: club")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", studentId=").append(studentId);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}