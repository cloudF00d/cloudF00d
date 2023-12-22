package com.ohgiraffers.semiproject.delivery.model.dao;

import com.ohgiraffers.semiproject.delivery.model.dto.TotalDeliveryDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryMapper {
    MemberDTO searchUserCodeByUserId(String userId);

    List<TotalDeliveryDTO> searchDeliveryStatus(int userCode);
}
