package com.ohgiraffers.semiproject.delivery.model.service;

import com.ohgiraffers.semiproject.delivery.model.dao.DeliveryMapper;
import com.ohgiraffers.semiproject.delivery.model.dto.TotalDeliveryDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface DeliveryService {
    
    MemberDTO searchUserCodeByUserId(String userId);

    List<TotalDeliveryDTO> searchDeliveryStatus(int userCode);
}
