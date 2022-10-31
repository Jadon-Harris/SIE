package com.uta.sie.entity;

import java.io.Serializable;
import javax.annotation.Generated;

public class User implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: user.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: user.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: user.password")
    private String password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: user.email")
    private String email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: user.question")
    private String question;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: user.answer")
    private String answer;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: user.school_id")
    private Long schoolId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source Table: user")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: user.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: user.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: user.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: user.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: user.password")
    public String getPassword() {
        return password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: user.password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: user.email")
    public String getEmail() {
        return email;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: user.email")
    public void setEmail(String email) {
        this.email = email;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: user.question")
    public String getQuestion() {
        return question;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: user.question")
    public void setQuestion(String question) {
        this.question = question;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: user.answer")
    public String getAnswer() {
        return answer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: user.answer")
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: user.school_id")
    public Long getSchoolId() {
        return schoolId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: user.school_id")
    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source Table: user")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", question=").append(question);
        sb.append(", answer=").append(answer);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}