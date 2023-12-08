package com.ohgiraffers.semiproject.manager.search.model.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PaymentHistoryDTO {
    private List<PaymentDTO> paymentCode; // 결제 내역을 보기 위함
    private List<CartDTO> cartCode; // 사용자 정보, 프로젝트 정보를 보기 위함
}
