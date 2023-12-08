package com.ohgiraffers.semiproject.manager.search.model.dto;

import lombok.*;
import org.springframework.dao.support.PersistenceExceptionTranslationInterceptor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CartDTO {

    private int cartCode;
    private UserDTO userCode;
    private List<ProjectDTO> projectCode;
    private int optionCode;
    private char usageStatus;
}
