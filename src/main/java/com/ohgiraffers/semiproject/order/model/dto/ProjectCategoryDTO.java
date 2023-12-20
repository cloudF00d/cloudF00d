package com.ohgiraffers.semiproject.order.model.dto;

import lombok.Getter;

@Getter
public class ProjectCategoryDTO {

    private int code;

    private String name;

    public ProjectCategoryDTO() {
    }

    public ProjectCategoryDTO(int code, String name) {
        this.code = code;
        this.name = name;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "ProjectCategoryDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
