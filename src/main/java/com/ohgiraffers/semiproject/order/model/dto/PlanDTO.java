package com.ohgiraffers.semiproject.order.model.dto;

import lombok.Getter;

@Getter
public class PlanDTO {

    private int code;

    private String name;

    private int price;

    private String detail;

    public PlanDTO() {
    }

    public PlanDTO(int code, String name, int price, String detail) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "PlanDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                '}';
    }
}
