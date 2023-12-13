package com.ohgiraffers.semiproject.manager.model.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserReportDTO {
    private UserReportAnswerDTO creationNumber;
    private Date creationDate;
    private UserDTO reporter;
    private String title;
    private String content;
    private UserDTO reportedPerson;
}

