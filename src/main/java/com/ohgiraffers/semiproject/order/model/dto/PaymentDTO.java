package com.ohgiraffers.semiproject.order.model.dto;

import com.ohgiraffers.semiproject.deliver.model.dto.DeliverDTO;
import lombok.*;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentDTO {

    private int code;

    private int amount;

    private String method;

    private Date time;

    private DeliverDTO deliverCode;

    private String status;



}
