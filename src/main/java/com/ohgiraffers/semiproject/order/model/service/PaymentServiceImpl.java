package com.ohgiraffers.semiproject.order.model.service;


import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;
import com.ohgiraffers.semiproject.order.model.dao.PaymentMapper;
import com.ohgiraffers.semiproject.order.model.dto.PaymentHistoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {


    private  PaymentMapper mapper;

    public PaymentServiceImpl(PaymentMapper mapper) {
        this.mapper = mapper;
    }


//    결제 페이지



    public PaymentHistoryDTO paymentPage(int no) throws PaymentPageException {
        PaymentHistoryDTO paymentPage = mapper.paymentPage();

        if(!(paymentPage == null)){
            throw new PaymentPageException("결제 실패 하였습니다");
        }
        return paymentPage;
    }


//    결제 취소





}
