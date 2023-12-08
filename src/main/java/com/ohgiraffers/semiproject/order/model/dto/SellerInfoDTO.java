package com.ohgiraffers.semiproject.order.model.dto;

public class SellerInfoDTO {


    private MemberDTO seller;

    public SellerInfoDTO(MemberDTO seller) {
        this.seller = seller;
    }

    public MemberDTO getSeller() {
        return seller;
    }

    public void setSeller(MemberDTO seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "SellerInfoDTO{" +
                "seller=" + seller +
                '}';
    }
}
