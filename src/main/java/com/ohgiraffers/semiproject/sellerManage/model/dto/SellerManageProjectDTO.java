package com.ohgiraffers.semiproject.sellerManage.model.dto;

import java.sql.Date;

public class SellerManageProjectDTO {

    private int code;

    private int memberCode;

    private String projectTitle;

    private Date start;

    private Date end;

    private int amount;

    private String status;

    public SellerManageProjectDTO() {
    }

    public SellerManageProjectDTO(int code, int memberCode, String projectTitle, Date start, Date end, int amount, String status) {
        this.code = code;
        this.memberCode = memberCode;
        this.projectTitle = projectTitle;
        this.start = start;
        this.end = end;
        this.amount = amount;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SellerManageProjectDTO{" +
                "code=" + code +
                ", memberCode=" + memberCode +
                ", projectTitle='" + projectTitle + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
