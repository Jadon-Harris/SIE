package com.uta.sie.entity;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Generated;

public class Event implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.468+08:00", comments="Source field: event.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.description")
    private String description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.date_time")
    private Date dateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.location")
    private String location;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.school_id")
    private Integer schoolId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.student_id")
    private String studentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source Table: event")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.468+08:00", comments="Source field: event.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.description")
    public String getDescription() {
        return description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.date_time")
    public Date getDateTime() {
        return dateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.date_time")
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.location")
    public String getLocation() {
        return location;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.location")
    public void setLocation(String location) {
        this.location = location;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.school_id")
    public Integer getSchoolId() {
        return schoolId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.school_id")
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.student_id")
    public String getStudentId() {
        return studentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source field: event.student_id")
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.469+08:00", comments="Source Table: event")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", location=").append(location);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", studentId=").append(studentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}