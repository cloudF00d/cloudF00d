package com.ohgiraffers.semiproject.delivery.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class TotalDeliveryDTO {
    private CartDTO cartDTO;
    private DeliveryDTO deliveryDTO;
    private PaymentDTO paymentDTO;
    private PaymentHistoryDTO paymentHistoryDTO;
    private ProjectDTO projectDTO;
    private ProjectFileDTO projectFileDTO;
    private ReturnHistoryDTO returnHistoryDTO;
}
