package com.ohgiraffers.semiproject.project.projectMake.model.dto;

import lombok.*;

import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BusinessFileMakeDTO {
    int codeF;
    int codeS;
    String oriFileName;
    String chanFileName;
    String fPath;
    Date dateCrea;
    String fType;
}
