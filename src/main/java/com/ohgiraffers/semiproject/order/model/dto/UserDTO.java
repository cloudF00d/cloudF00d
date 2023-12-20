package com.ohgiraffers.semiproject.order.model.dto;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {

    private int userCode;

    private String name;

    private String email;

    private String address;

    private String phone;

    private String projectTitle;

    private String optionName;

    private int price;

    private String configure;

    private String optionType;

    private int amount;

    private String coupon;


}
