package com.ohgiraffers.semiproject.order.model.dto;

import java.util.List;

public class PaymentHistoryDTO {

    private PaymentDTO payment;


    private CartDTO cart;



    public PaymentHistoryDTO() {
    }

    public PaymentHistoryDTO(PaymentDTO payment, CartDTO cart) {
        this.payment = payment;
        this.cart = cart;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO paymentt) {
        this.payment = paymentt;
    }

    public CartDTO getCart() {
        return cart;
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
