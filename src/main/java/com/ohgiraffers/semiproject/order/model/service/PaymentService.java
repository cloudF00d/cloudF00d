package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;
import com.ohgiraffers.semiproject.order.model.dto.PaymentHistoryDTO;
import com.ohgiraffers.semiproject.order.model.dto.UserDTO;

import java.util.List;

public interface PaymentService {


//    결제 페이지
List<UserDTO> paymentPage() throws PaymentPageException;



//    결제 취소






}
