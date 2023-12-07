package com.ohgiraffers.semiproject.project.model.dto;


import java.sql.Date;

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


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProjectCategoryDTO getCategory() {
        return category;
    }

    public void setCategory(ProjectCategoryDTO category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PlanDTO getPlan() {
        return plan;
    }

    public void setPlan(PlanDTO plan) {
        this.plan = plan;
    }

    public SellerInfoDTO getSeller() {
        return seller;
    }

    public void setSeller(SellerInfoDTO seller) {
        this.seller = seller;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }

    public String getSellerType() {
        return sellerType;
    }

    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public String getProgress() {
        return progress;
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
