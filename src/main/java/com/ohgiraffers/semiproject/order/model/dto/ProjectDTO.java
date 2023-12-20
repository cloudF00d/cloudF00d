package com.ohgiraffers.semiproject.order.model.dto;


import lombok.Getter;

import java.sql.Date;

@Getter
public class ProjectDTO {


    private int code;

    private String title;

    private ProjectCategoryDTO category;

    private String type;

    private PlanDTO plan;

    private SellerInfoDTO seller;

    private int amount;

    private Date end;

    private String summary;

    private String agree;

    private String sellerType;

    private String status;

    private Date start;

    private String progress;

    public ProjectDTO() {
    }

    public ProjectDTO(int code, String title, ProjectCategoryDTO category, String type, PlanDTO plan, SellerInfoDTO seller, int amount, Date end, String summary, String agree, String sellerType, String status, Date start, String progress) {
        this.code = code;
        this.title = title;
        this.category = category;
        this.type = type;
        this.plan = plan;
        this.seller = seller;
        this.amount = amount;
        this.end = end;
        this.summary = summary;
        this.agree = agree;
        this.sellerType = sellerType;
        this.status = status;
        this.start = start;
        this.progress = progress;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(ProjectCategoryDTO category) {
        this.category = category;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPlan(PlanDTO plan) {
        this.plan = plan;
    }

    public void setSeller(SellerInfoDTO seller) {
        this.seller = seller;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }

    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", type='" + type + '\'' +
                ", plan=" + plan +
                ", seller=" + seller +
                ", amount=" + amount +
                ", end=" + end +
                ", summary='" + summary + '\'' +
                ", agree='" + agree + '\'' +
                ", sellerType='" + sellerType + '\'' +
                ", status='" + status + '\'' +
                ", start=" + start +
                ", progress='" + progress + '\'' +
                '}';
    }
}
