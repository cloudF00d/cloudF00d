package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;
import com.ohgiraffers.semiproject.order.model.dao.PaymentMapper;

import com.ohgiraffers.semiproject.order.model.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {


    private  PaymentMapper mapper;

    public PaymentServiceImpl(PaymentMapper mapper) {
        this.mapper = mapper;
    }


    public List<UserDTO>  paymentPage(String userId, String title) {
        List<UserDTO> paymentPage = mapper.user1(userId, title);
        return paymentPage;
    }




    //    결제 취소





}
