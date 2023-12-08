package com.ohgiraffers.semiproject.manager.search.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CartDTO {

    private int cartCode;
    private int userCode;
    private  ProjectDTO projectCode;
    private int optionCode;
    private char usageStatus;
}
