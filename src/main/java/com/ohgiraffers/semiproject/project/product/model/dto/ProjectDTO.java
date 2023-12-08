package com.ohgiraffers.semiproject.project.product.model.dto;

import lombok.*;

import java.util.Date;


public class ProjectDTO {//프로젝트

    private int projectCode;
    private String projectTitle;
    private int projectCategory;
    private String projectType;
    private int plan;
    private int sellerInfo;
    private int targetAmount;
    private Date projectEndDate;
    private String projectSummary;
    private char policyAgreement;
    private String sellerType;
    private char achievementStatus;
    private Date projectStartDate;
    private String progressStatus;

    public ProjectDTO() {
    }

    public ProjectDTO(int projectCode, String projectTitle, int projectCategory, String projectType, int plan, int sellerInfo, int targetAmount, Date projectEndDate, String projectSummary, char policyAgreement, String sellerType, char achievementStatus, Date projectStartDate, String progressStatus) {
        this.projectCode = projectCode;
        this.projectTitle = projectTitle;
        this.projectCategory = projectCategory;
        this.projectType = projectType;
        this.plan = plan;
        this.sellerInfo = sellerInfo;
        this.targetAmount = targetAmount;
        this.projectEndDate = projectEndDate;
        this.projectSummary = projectSummary;
        this.policyAgreement = policyAgreement;
        this.sellerType = sellerType;
        this.achievementStatus = achievementStatus;
        this.projectStartDate = projectStartDate;
        this.progressStatus = progressStatus;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectCode=" + projectCode +
                ", projectTitle='" + projectTitle + '\'' +
                ", projectCategory=" + projectCategory +
                ", projectType='" + projectType + '\'' +
                ", plan=" + plan +
                ", sellerInfo=" + sellerInfo +
                ", targetAmount=" + targetAmount +
                ", projectEndDate=" + projectEndDate +
                ", projectSummary='" + projectSummary + '\'' +
                ", policyAgreement=" + policyAgreement +
                ", sellerType='" + sellerType + '\'' +
                ", achievementStatus=" + achievementStatus +
                ", projectStartDate=" + projectStartDate +
                ", progressStatus='" + progressStatus + '\'' +
                '}';
    }

    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public void setProjectCategory(int projectCategory) {
        this.projectCategory = projectCategory;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public void setSellerInfo(int sellerInfo) {
        this.sellerInfo = sellerInfo;
    }

    public void setTargetAmount(int targetAmount) {
        this.targetAmount = targetAmount;
    }

    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public void setProjectSummary(String projectSummary) {
        this.projectSummary = projectSummary;
    }

    public void setPolicyAgreement(char policyAgreement) {
        this.policyAgreement = policyAgreement;
    }

    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
    }

    public void setAchievementStatus(char achievementStatus) {
        this.achievementStatus = achievementStatus;
    }

    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public void setProgressStatus(String progressStatus) {
        this.progressStatus = progressStatus;
    }

    public int getProjectCode() {
        return projectCode;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public int getProjectCategory() {
        return projectCategory;
    }

    public String getProjectType() {
        return projectType;
    }

    public int getPlan() {
        return plan;
    }

    public int getSellerInfo() {
        return sellerInfo;
    }

    public int getTargetAmount() {
        return targetAmount;
    }

    public Date getProjectEndDate() {
        return projectEndDate;
    }

    public String getProjectSummary() {
        return projectSummary;
    }

    public char getPolicyAgreement() {
        return policyAgreement;
    }

    public String getSellerType() {
        return sellerType;
    }

    public char getAchievementStatus() {
        return achievementStatus;
    }

    public Date getProjectStartDate() {
        return projectStartDate;
    }

    public String getProgressStatus() {
        return progressStatus;
    }
}
