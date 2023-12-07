package com.ohgiraffers.semiproject.manager.search.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PaymentHistoryDTO {

    private PaymentDTO paymentCode;
    private CartDTO cartCode;


}
