package com.ohgiraffers.semiproject.order.model.dao;

import com.ohgiraffers.semiproject.order.model.dto.DeliverDTO;
import com.ohgiraffers.semiproject.order.model.dto.PaymentDTO;
import com.ohgiraffers.semiproject.order.model.dto.PaymentHistoryDTO;
import com.ohgiraffers.semiproject.order.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface PaymentMapper {
   List<UserDTO> user1(String userId);


//   int insertPaymentInfo(PaymentDTO payment, int deliverCode, String status);

   int insertDeliverInfo(DeliverDTO deliver,int userCode);

   int insertPaymentInfo(int deliverCode, String status, int code, int amount, String method, Date time);

   int selectLastInsertdeliveryCode();
}


//    결제 페이지
   

//    결제 취소



