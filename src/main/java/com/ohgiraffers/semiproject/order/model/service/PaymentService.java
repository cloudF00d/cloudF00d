package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;
import com.ohgiraffers.semiproject.order.model.dto.PaymentHistoryDTO;

public interface PaymentService {


//    결제 페이지
    void paymentPage(PaymentHistoryDTO paymentHistory) throws PaymentPageException;



//    결제 취소






}