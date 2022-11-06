package com.uta.sie.entity;

import java.io.Serializable;
import javax.annotation.Generated;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class ClubMember implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.455+08:00", comments="Source field: club_member.id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.455+08:00", comments="Source field: club_member.club_id")
    private Long clubId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.455+08:00", comments="Source field: club_member.student_id")
    private Long studentId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.456+08:00", comments="Source Table: club_member")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.455+08:00", comments="Source field: club_member.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.455+08:00", comments="Source field: club_member.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.455+08:00", comments="Source field: club_member.club_id")
    public Long getClubId() {
        return clubId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.455+08:00", comments="Source field: club_member.club_id")
    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.455+08:00", comments="Source field: club_member.student_id")
    public Long getStudentId() {
        return studentId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.456+08:00", comments="Source field: club_member.student_id")
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-11-05T16:16:32.456+08:00", comments="Source Table: club_member")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clubId=").append(clubId);
        sb.append(", studentId=").append(studentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}