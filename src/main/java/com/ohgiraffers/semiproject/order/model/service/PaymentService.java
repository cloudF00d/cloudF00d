package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;
import com.ohgiraffers.semiproject.order.model.dto.PaymentHistoryDTO;

public interface PaymentService {


//    결제 페이지
    public PaymentHistoryDTO paymentPage(int no) throws PaymentPageException;



//    결제 취소






}
