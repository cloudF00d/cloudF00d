package com.ohgiraffers.semiproject.project.model.dto;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ProjectDTO {

    private int projectCode;

    private String projectTitle;

    private int projectCategory;

    private String projectType;

    private int projectPlan;

    private int sellerInfo;

    private int targetAmount;

    private Date projectEndDate;

    private String projectSummary;

    private String sellerType;

    private String AchievementStatus;

    private Date projectStartDate;

    private String progressStatus;

}





