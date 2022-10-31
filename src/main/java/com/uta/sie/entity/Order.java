package com.uta.sie.entity;

import java.io.Serializable;
import javax.annotation.Generated;

public class Order implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: order.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: order.product_id")
    private Integer productId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: order.seller_id")
    private String sellerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: order.buyer_id")
    private String buyerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source Table: order")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: order.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: order.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: order.product_id")
    public Integer getProductId() {
        return productId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: order.product_id")
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: order.seller_id")
    public String getSellerId() {
        return sellerId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: order.seller_id")
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: order.buyer_id")
    public String getBuyerId() {
        return buyerId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source field: order.buyer_id")
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-31T00:05:36.474+08:00", comments="Source Table: order")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", buyerId=").append(buyerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}