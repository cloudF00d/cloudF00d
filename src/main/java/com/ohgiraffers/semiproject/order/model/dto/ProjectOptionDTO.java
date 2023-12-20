package com.ohgiraffers.semiproject.order.model.dto;

import lombok.Getter;

@Getter
public class ProjectOptionDTO {

    private int code;

    private String name;

    private String type;

    private int price;

    private String config;

    private ProjectDTO projectCode;

    public ProjectOptionDTO() {
    }

    public ProjectOptionDTO(int code, String name, String type, int price, String config, ProjectDTO projectCode) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.price = price;
        this.config = config;
        this.projectCode = projectCode;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public void setProjectCode(ProjectDTO projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public String toString() {
        return "ProjectOptionDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", config='" + config + '\'' +
                ", projectCode=" + projectCode +
                '}';
    }
}
