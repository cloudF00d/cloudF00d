package com.ohgiraffers.semiproject.order.model.dao;

import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;
import com.ohgiraffers.semiproject.order.model.dto.PaymentHistoryDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

//    결제 페이지
   public int paymentPage(PaymentHistoryDTO paymentHistory) throws PaymentPageException;



//    결제 취소


}
