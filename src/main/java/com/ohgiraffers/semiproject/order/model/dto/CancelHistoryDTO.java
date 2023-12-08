package com.ohgiraffers.semiproject.order.model.dto;

import java.sql.Date;

public class CancelHistoryDTO {

    private PaymentDTO paymentCode;

    private Date application;

    private String reason;

    private String status;

    private Date completion;

    public CancelHistoryDTO() {
    }

    public CancelHistoryDTO(PaymentDTO paymentCode, Date application, String reason, String status, Date completion) {
        this.paymentCode = paymentCode;
        this.application = application;
        this.reason = reason;
        this.status = status;
        this.completion = completion;
    }

    public PaymentDTO getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(PaymentDTO paymentCode) {
        this.paymentCode = paymentCode;
    }

    public Date getApplication() {
        return application;
    }

    public void setApplication(Date application) {
        this.application = application;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCompletion() {
        return completion;
    }

    public void setCompletion(Date completion) {
        this.completion = completion;
    }

    @Override
    public String toString() {
        return "CancelHistoryDTO{" +
                "paymentCode=" + paymentCode +
                ", application=" + application +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                ", completion=" + completion +
                '}';
    }
}
