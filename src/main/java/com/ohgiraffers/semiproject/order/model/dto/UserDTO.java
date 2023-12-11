package com.ohgiraffers.semiproject.order.model.dto;


import lombok.Getter;
import lombok.Setter;


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

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getConfigure() {
        return configure;
    }

    public void setConfigure(String configure) {
        this.configure = configure;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCoupon() {
        return coupon;
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
