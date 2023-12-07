package com.ohgiraffers.semiproject.deliver.model.dto;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;

import java.util.List;

import java.sql.Date;



public class DeliverDTO {

    private int code;

    private Date day;

    private String status;

    private MemberDTO member;
    private String request;


    public DeliverDTO() {
    }


    public DeliverDTO(int code, Date day, String status, String request, MemberDTO member) {
        this.code = code;
        this.day = day;
        this.status = status;
        this.request = request;
        this.member = member;
    }


    public int getCode() {
        return code;
    }

    public Date getDay() {
        return day;
    }

    public String getStatus() {
        return status;
    }

    public String getRequest() {
        return request;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setMemberList(MemberDTO member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "DeliverDTO{" +
                "code=" + code +
                ", day=" + day +
                ", status='" + status + '\'' +
                ", request='" + request + '\'' +
                ", member=" + member +
                '}';
    }
}
