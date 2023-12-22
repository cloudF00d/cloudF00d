package com.ohgiraffers.semiproject.order.model.dto;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.project.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectOptionDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CartDTO {


    private int code;

    private MemberDTO memberCode;

    private ProjectDTO  projectCode;

    private ProjectOptionDTO projectOptionCode;

    private String status;




}


