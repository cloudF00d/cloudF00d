package com.ohgiraffers.semiproject.order.model.dto;

import com.ohgiraffers.semiproject.deliver.model.dto.DeliverDTO;
import lombok.Getter;

import java.sql.Date;
@Getter
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

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "code=" + code +
                ", amount=" + amount +
                ", method='" + method + '\'' +
                ", time=" + time +
                ", deliverCode=" + deliverCode +
                ", status='" + status + '\'' +
                '}';
    }
}
