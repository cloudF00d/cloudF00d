package com.ohgiraffers.semiproject.manager.search.model.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProjectDTO {

    private int projectCode;
    private String projectTitle;
    private ProjectCategoryDTO projectCategory;
    private String projectType;
    private PlanDTO projectPlan;
    private UserDTO sellerInfo;
    private int targetAmount;
    private Date projectEndDate;
    private String projectSummary;
    private char policyAgreement;
    private String sellerType;
    private char achievementStatus;
    private Date projectStartDate;
    private String progressStatus;
}
