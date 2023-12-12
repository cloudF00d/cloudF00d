package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.common.exception.payment.MemberOrderPageException;
import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.order.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.order.model.dto.PaymentHistoryDTO;
import com.ohgiraffers.semiproject.order.model.dto.UserDTO;

import java.util.List;

public interface PaymentService {


//    결제 페이지
List<UserDTO> paymentPage() throws PaymentPageException;

//    MemberDTO member(MemberDTO member) throws MemberOrderPageException;




//    결제 취소






}
