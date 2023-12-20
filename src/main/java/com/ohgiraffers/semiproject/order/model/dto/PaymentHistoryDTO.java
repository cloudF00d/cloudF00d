package com.ohgiraffers.semiproject.order.model.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PaymentHistoryDTO {

    private PaymentDTO payment;


    private CartDTO cart;



    public PaymentHistoryDTO() {
    }

    public PaymentHistoryDTO(PaymentDTO payment, CartDTO cart) {
        this.payment = payment;
        this.cart = cart;
    }

    public void setPayment(PaymentDTO paymentt) {
        this.payment = paymentt;
    }

    public void setCart(CartDTO cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "PaymentHistoryDTO{" +
                "paymentt=" + payment +
                ", cart=" + cart +
                '}';
    }


}
