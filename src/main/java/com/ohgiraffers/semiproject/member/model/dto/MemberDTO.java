package com.ohgiraffers.semiproject.member.model.dto;


import java.sql.Date;

public class MemberDTO {


    private int code;

    private String id;

    private String paw;

    private String email;

    private Date date;

    private String address;

    private String name;

    private Date birth;

    private String phone;

    private String status;

    private int count;

    private String coupon;

    public MemberDTO() {
    }


    public MemberDTO(int code, String id, String paw, String email, Date date, String address, String name, Date birth, String phone, String status, int count, String coupon) {
        this.code = code;
        this.id = id;
        this.paw = paw;
        this.email = email;
        this.date = date;
        this.address = address;
        this.name = name;
        this.birth = birth;
        this.phone = phone;
        this.status = status;
        this.count = count;
        this.coupon = coupon;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaw() {
        return paw;
    }

    public void setPaw(String paw) {
        this.paw = paw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

//
    @Override
    public String toString() {
        return "MemberDTO{" +
                "code=" + code +
                ", id='" + id + '\'' +
                ", paw='" + paw + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", count=" + count +
                ", coupon='" + coupon + '\'' +
                '}';
    }
}
