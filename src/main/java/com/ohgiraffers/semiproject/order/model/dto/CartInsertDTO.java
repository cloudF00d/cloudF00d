package com.ohgiraffers.semiproject.order.model.dto;

import java.util.Date;

public class CartInsertDTO {

    private int cartCode;

    private String userId;

    private String projectTitle;

    private String optionName;

    private int price;

    private String configure;

    private String optionType;

    private int amount;

    private String coupon;

    private Date end;

    private Date start;

    public CartInsertDTO() {
    }


    public CartInsertDTO(int cartCode, String userId, String projectTitle, String optionName, int price, String configure, String optionType, int amount, String coupon, Date end, Date start) {
        this.cartCode = cartCode;
        this.userId = userId;
        this.projectTitle = projectTitle;
        this.optionName = optionName;
        this.price = price;
        this.configure = configure;
        this.optionType = optionType;
        this.amount = amount;
        this.coupon = coupon;
        this.end = end;
        this.start = start;
    }

    public int getCartCode() {
        return cartCode;
    }

    public void setCartCode(int cartCode) {
        this.cartCode = cartCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "CartInsertDTO{" +
                "cartCode=" + cartCode +
                ", userId='" + userId + '\'' +
                ", projectTitle='" + projectTitle + '\'' +
                ", optionName='" + optionName + '\'' +
                ", price=" + price +
                ", configure='" + configure + '\'' +
                ", optionType='" + optionType + '\'' +
                ", amount=" + amount +
                ", coupon='" + coupon + '\'' +
                ", end=" + end +
                ", start=" + start +
                '}';
    }
}
