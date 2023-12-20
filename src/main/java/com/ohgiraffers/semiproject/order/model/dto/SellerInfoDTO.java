package com.ohgiraffers.semiproject.order.model.dto;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import lombok.Getter;

@Getter
public class SellerInfoDTO {


    private MemberDTO seller;

    public SellerInfoDTO(MemberDTO seller) {
        this.seller = seller;
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
