package com.uta.sie.entity;

import java.io.Serializable;

public class Pay implements Serializable {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "number='" + number + '\'' +
                '}';
    }
}
