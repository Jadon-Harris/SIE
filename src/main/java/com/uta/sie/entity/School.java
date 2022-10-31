package com.uta.sie.entity;

import java.io.Serializable;
import javax.annotation.Generated;

public class School implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.state")
    private String state;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.city")
    private String city;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.country")
    private String country;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source Table: school")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.state")
    public String getState() {
        return state;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.state")
    public void setState(String state) {
        this.state = state;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.city")
    public String getCity() {
        return city;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.city")
    public void setCity(String city) {
        this.city = city;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.country")
    public String getCountry() {
        return country;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.471+08:00", comments="Source field: school.country")
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.472+08:00", comments="Source Table: school")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", state=").append(state);
        sb.append(", city=").append(city);
        sb.append(", country=").append(country);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}