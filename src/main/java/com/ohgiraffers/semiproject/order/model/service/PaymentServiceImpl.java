package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.common.exception.member.MemberJoinException;
import com.ohgiraffers.semiproject.common.exception.payment.DeliverInfoException;
import com.ohgiraffers.semiproject.common.exception.payment.PaymentInfoException;
import com.ohgiraffers.semiproject.order.model.dao.PaymentMapper;

import com.ohgiraffers.semiproject.order.model.dto.DeliverDTO;
import com.ohgiraffers.semiproject.order.model.dto.PaymentDTO;
import com.ohgiraffers.semiproject.order.model.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {


    private  PaymentMapper mapper;

    public PaymentServiceImpl(PaymentMapper mapper) {
        this.mapper = mapper;
    }


    public List<UserDTO>  paymentPage(String userId) {
        List<UserDTO> paymentPage = mapper.user1(userId);
        return paymentPage;
    }


    public void paymentInfo(PaymentDTO payment, int deliverCode, String status) throws PaymentInfoException{

        int result= mapper.insertPaymentInfo(payment ,deliverCode, status);
        log.info(String.valueOf(result));

        if(!(result > 0 )){
            throw new PaymentInfoException("결제 정보가 없습니다.");
        }
    }

    public void paymentDeliverInfo(DeliverDTO deliver, int userCode) throws DeliverInfoException {


        int result = mapper.insertDeliverInfo(deliver ,userCode);
        if(!(result > 0 )){
            throw new DeliverInfoException("개인 정보가 없습니다.");
        }
    }




    //    결제 취소





}
