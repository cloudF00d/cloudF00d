package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.common.exception.payment.DeliverInfoException;
import com.ohgiraffers.semiproject.common.exception.payment.PaymentInfoException;
import com.ohgiraffers.semiproject.order.model.dao.PaymentMapper;

import com.ohgiraffers.semiproject.order.model.dto.DeliverDTO;
import com.ohgiraffers.semiproject.order.model.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {


    private  PaymentMapper mapper;

    public PaymentServiceImpl(PaymentMapper mapper) {
        this.mapper = mapper;
    }


    public List<UserDTO>  paymentPage(String userId, int cartCode) {
        List<UserDTO> paymentPage = mapper.user1(userId, cartCode);
        return paymentPage;
    }


//    public void paymentInfo(PaymentDTO payment, int deliverCode, String status) throws PaymentInfoException{
//
//        int result= mapper.insertPaymentInfo(payment ,deliverCode, status);
//        log.info(String.valueOf(result));
//
//        if(!(result > 0 )){
//            throw new PaymentInfoException("결제 정보가 없습니다.");
//        }
//    }

    public void paymentDeliverInfo(DeliverDTO deliver, int userCode) throws DeliverInfoException {


        int result = mapper.insertDeliverInfo(deliver ,userCode);
        if(!(result > 0 )){
            throw new DeliverInfoException("개인 정보가 없습니다.");
        }
    }

    @Override
    public void paymentInfo(int deliverCode, String status, int code, int amount, String method, Date time) throws PaymentInfoException {
        int deliveryCode = mapper.selectLastInsertdeliveryCode();
        System.out.println("deliveryCode================================================ " + deliveryCode);
        int result= mapper.insertPaymentInfo(deliverCode ,status, deliveryCode, amount, method, time);
        log.info(String.valueOf(result));

        if(!(result > 0 )){
            throw new PaymentInfoException("결제 정보가 없습니다.");
        }
    }

    @Override
    public int paymentCount(int count, int cartCode){
        int result = mapper.updateCount(count,cartCode);
        return result;
    }


    //    결제 취소





}
