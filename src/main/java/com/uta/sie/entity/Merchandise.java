package com.uta.sie.entity;

import java.math.BigDecimal;

public class Merchandise {
    private Integer id;
    private String name;
    private BigDecimal price;

    private BigDecimal deposit;
    private String description;

    private String deadline;

    private String photo;
    private Long sellerId;

    private Long buyId;
    private Integer state;

    public Merchandise(String name, BigDecimal price, String description, String photo, Long sellerId, Long buyId, Integer state) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.photo = photo;
        this.sellerId = sellerId;
        this.buyId = buyId;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getBuyId() {
        return buyId;
    }

    public void setBuyId(Long buyId) {
        this.buyId = buyId;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }



    @Override
    public String toString() {
        return "Merchandise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", Photo='" + photo + '\'' +
                ", sellerId=" + sellerId +
                ", state=" + state +
                '}';
    }

    public Merchandise() {
    }
}
