package com.ohgiraffers.semiproject.project.projectMake.model.dto;

import lombok.*;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectNumberMakeDTO {

    private String title;
    private int category;
    private String type;
    private int plan;
    private String targetAmount;
    private Date endDate;
    private Date startDate;
    private String summary;
    private String sellerType;
    private int sellerCode;
    private String tag;
    private char policy;
    private List<ProjectMakeFileDTO> attachmentList;
    private String content;

    public ProjectNumberMakeDTO(String title, int category, String type, int plan, String targetAmount, Date endDate, Date startDate, String summary, String sellerType, int sellerCode, char policy, String content) {
        this.title = title;
        this.category = category;
        this.type = type;
        this.plan = plan;
        this.targetAmount = targetAmount;
        this.endDate = endDate;
        this.startDate = startDate;
        this.summary = summary;
        this.sellerType = sellerType;
        this.sellerCode = sellerCode;
        this.policy = policy;
        this.content = content;
    }
}
