package com.uta.sie.entity;

import java.io.Serializable;
import javax.annotation.Generated;

public class Product implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.472+08:00", comments="Source field: product.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: product.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: product.description")
    private String description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: product.price")
    private String price;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: product.school_id")
    private Integer schoolId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source Table: product")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: product.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: product.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: product.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: product.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: product.description")
    public String getDescription() {
        return description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: product.description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: product.price")
    public String getPrice() {
        return price;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: product.price")
    public void setPrice(String price) {
        this.price = price;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: product.school_id")
    public Integer getSchoolId() {
        return schoolId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source field: product.school_id")
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.473+08:00", comments="Source Table: product")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", price=").append(price);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}