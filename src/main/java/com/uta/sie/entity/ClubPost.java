package com.uta.sie.entity;

import java.io.Serializable;
import javax.annotation.Generated;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class ClubPost implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.452+08:00", comments="Source field: club_post.id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.452+08:00", comments="Source field: club_post.title")
    private String title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.453+08:00", comments="Source field: club_post.content")
    private String content;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.453+08:00", comments="Source field: club_post.club_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long clubId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.453+08:00", comments="Source field: club_post.student_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long studentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.453+08:00", comments="Source Table: club_post")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.452+08:00", comments="Source field: club_post.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.452+08:00", comments="Source field: club_post.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.452+08:00", comments="Source field: club_post.title")
    public String getTitle() {
        return title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.453+08:00", comments="Source field: club_post.title")
    public void setTitle(String title) {
        this.title = title;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.453+08:00", comments="Source field: club_post.content")
    public String getContent() {
        return content;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.453+08:00", comments="Source field: club_post.content")
    public void setContent(String content) {
        this.content = content;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.453+08:00", comments="Source field: club_post.club_id")
    public Long getClubId() {
        return clubId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.453+08:00", comments="Source field: club_post.club_id")
    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.453+08:00", comments="Source field: club_post.student_id")
    public Long getStudentId() {
        return studentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.453+08:00", comments="Source field: club_post.student_id")
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.453+08:00", comments="Source Table: club_post")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", clubId=").append(clubId);
        sb.append(", studentId=").append(studentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}