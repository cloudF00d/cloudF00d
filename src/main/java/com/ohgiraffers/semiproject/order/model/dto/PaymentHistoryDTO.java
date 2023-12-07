package com.ohgiraffers.semiproject.order.model.dto;

import java.util.List;

public class PaymentHistoryDTO {

    private PaymentDTO paymentt;


    private CartDTO cart;

    public PaymentHistoryDTO() {
    }

    public PaymentHistoryDTO(PaymentDTO paymentt, CartDTO cart) {
        this.paymentt = paymentt;
        this.cart = cart;
    }

    public PaymentDTO getPaymentt() {
        return paymentt;
    }

    public void setPaymentt(PaymentDTO paymentt) {
        this.paymentt = paymentt;
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
                "paymentt=" + paymentt +
                ", cart=" + cart +
                '}';
    }


}
