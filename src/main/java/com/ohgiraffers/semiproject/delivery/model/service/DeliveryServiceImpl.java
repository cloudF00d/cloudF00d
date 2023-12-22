package com.ohgiraffers.semiproject.delivery.model.service;

import com.ohgiraffers.semiproject.delivery.model.dao.DeliveryMapper;
import com.ohgiraffers.semiproject.delivery.model.dto.TotalDeliveryDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DeliveryServiceImpl implements DeliveryService{

    private final DeliveryMapper mapper;

    public DeliveryServiceImpl(DeliveryMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public MemberDTO searchUserCodeByUserId(String userId) {
        MemberDTO memberDTO = mapper.searchUserCodeByUserId(userId);

        return memberDTO;
    }

    @Override
    public List<TotalDeliveryDTO> searchDeliveryStatus(int userCode) {
        List<TotalDeliveryDTO> totalDeliveryDTO = mapper.searchDeliveryStatus(userCode);
        System.out.println("totalDeliveryDTO==================================" + totalDeliveryDTO);

        return totalDeliveryDTO;
    }
}
