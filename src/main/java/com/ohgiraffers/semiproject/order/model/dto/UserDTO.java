package com.ohgiraffers.semiproject.order.model.dto;


import lombok.Getter;
import lombok.Setter;


@Getter
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


    public UserDTO() {
    }



    public UserDTO(int userCode, String name, String email, String address, String phone, String projectTitle, String optionName, int price, String configure, String optionType, int amount, String coupon) {

        this.userCode = userCode;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.projectTitle = projectTitle;
        this.optionName = optionName;
        this.price = price;
        this.configure = configure;
        this.optionType = optionType;
        this.amount = amount;
        this.coupon = coupon;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setConfigure(String configure) {
        this.configure = configure;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userCode=" + userCode +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", projectTitle='" + projectTitle + '\'' +
                ", optionName='" + optionName + '\'' +
                ", price=" + price +
                ", configure='" + configure + '\'' +
                ", optionType='" + optionType + '\'' +
                ", amount=" + amount +
                ", coupon='" + coupon + '\'' +
                '}';
    }
}
