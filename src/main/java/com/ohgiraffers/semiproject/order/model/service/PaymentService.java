package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.common.exception.member.MemberJoinException;
import com.ohgiraffers.semiproject.common.exception.payment.DeliverInfoException;
import com.ohgiraffers.semiproject.common.exception.payment.PaymentInfoException;
import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;

import com.ohgiraffers.semiproject.order.model.dto.DeliverDTO;
import com.ohgiraffers.semiproject.order.model.dto.PaymentDTO;
import com.ohgiraffers.semiproject.order.model.dto.PaymentHistoryDTO;
import com.ohgiraffers.semiproject.order.model.dto.UserDTO;


import java.util.Date;
import java.util.List;

public interface PaymentService {

    //    결제 페이지
    List<UserDTO> paymentPage(String userId) throws PaymentPageException;


//    void paymentInfo(PaymentDTO payment ,int deliverCode, String status) throws PaymentInfoException;

    void paymentDeliverInfo(DeliverDTO deliver,int userCode) throws DeliverInfoException;

    void paymentInfo(int deliverCode, String status, int code, int amount, String method, Date time) throws PaymentInfoException;


//    결제 취소






}
