package com.ohgiraffers.semiproject.project.product.model.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TotalStoryDTO {
    private ProjectDTO projectDTO;
    private ProjectFileDTO projectFileDTO;
    private ProjectOptionDTO projectOptionDTO;
    private PrivateBusinessDTO privateBusinessDTO;
    private ProfileImageDTO profileImageDTO;
    private ProjectUserDTO projectUserDTO;


}
