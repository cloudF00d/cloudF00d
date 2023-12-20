package com.ohgiraffers.semiproject.order.model.dto;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import lombok.*;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class CartDTO {


    private int code;

    private MemberDTO memberCode;

    private ProjectDTO projectCode;

    private ProjectOptionDTO projectOptionCode;

    private String status;


}


