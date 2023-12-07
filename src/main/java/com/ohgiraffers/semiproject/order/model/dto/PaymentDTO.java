package com.ohgiraffers.semiproject.order.model.dto;

import com.ohgiraffers.semiproject.deliver.model.dto.DeliverDTO;

import java.sql.Date;
public class PaymentDTO {

    private int code;

    private int amount;

    private String method;

    private Date time;

    private DeliverDTO deliverCode;

    private String status;


    public PaymentDTO() {
    }

    public PaymentDTO(int code, int amount, String method, Date time, DeliverDTO deliverCode, String status) {
        this.code = code;
        this.amount = amount;
        this.method = method;
        this.time = time;
        this.deliverCode = deliverCode;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public int getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public Date getTime() {
        return time;
    }

    public DeliverDTO getDeliverCode() {
        return deliverCode;
    }

    public String getStatus() {
        return status;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setDeliverCode(DeliverDTO deliverCode) {
        this.deliverCode = deliverCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
