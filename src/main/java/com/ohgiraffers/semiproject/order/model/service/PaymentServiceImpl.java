package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;
import com.ohgiraffers.semiproject.order.model.dao.PaymentMapper;

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


//    결제 페이지



    public List<UserDTO>  paymentPage() throws PaymentPageException {
        List<UserDTO> paymentPage = mapper.user1();

        if((paymentPage == null)){
            throw new PaymentPageException("결제 실패 하였습니다");
        }
        System.out.println("paymentPage = " + paymentPage);

        return paymentPage;
    }


    //    결제 취소





}
