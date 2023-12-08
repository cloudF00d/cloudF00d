package com.ohgiraffers.semiproject.manager.search.model.dto;

import lombok.*;

import java.sql.Date;
import java.util.List;


public class UserDetailDTO {

    UserDTO userCode;
    ProjectDTO projectCode;
    List<CartDTO> cartCode;
    List<PaymentDTO> paymentCode;

}
