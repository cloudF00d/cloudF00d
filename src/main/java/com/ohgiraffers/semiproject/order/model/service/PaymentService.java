package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.common.exception.payment.DeliverInfoException;
import com.ohgiraffers.semiproject.common.exception.payment.PaymentInfoException;
import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.order.model.dto.DeliverDTO;
import com.ohgiraffers.semiproject.order.model.dto.PaymentHistoryDTO;
import com.ohgiraffers.semiproject.order.model.dto.UserDTO;


import java.util.Date;
import java.util.List;

public interface PaymentService {

    //    결제 페이지
    List<UserDTO> paymentPage(String userId ,int cartCode) throws PaymentPageException;


//    void paymentInfo(PaymentDTO payment ,int deliverCode, String status) throws PaymentInfoException;

    void paymentDeliverInfo(DeliverDTO deliver,int userCode) throws DeliverInfoException;

    void paymentInfo(int deliverCode, String status, int code, int amount, String method, Date time) throws PaymentInfoException;

    int paymentCount(int count, int cartNo);

    List<PaymentHistoryDTO> butHistory();

    void deliverInfoUpdate(MemberDTO member);


//    결제 취소






}
