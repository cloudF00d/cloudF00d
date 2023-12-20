package com.ohgiraffers.semiproject.order.model.dto;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import lombok.Getter;

import java.sql.Date;


@Getter
public class DeliverDTO {

    private int code;

    private Date day;

    private String status;

    private MemberDTO memberCode;
    private String request;


    public DeliverDTO() {
    }


    public DeliverDTO(int code, Date day, String status, MemberDTO memberCode, String request) {
        this.code = code;
        this.day = day;
        this.status = status;
        this.memberCode = memberCode;
        this.request = request;
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

    public void setMemberCode(MemberDTO memberCode) {
        this.memberCode = memberCode;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "DeliverDTO{" +
                "code=" + code +
                ", day=" + day +
                ", status='" + status + '\'' +
                ", memberCode=" + memberCode +
                ", request='" + request + '\'' +
                '}';
    }
}
