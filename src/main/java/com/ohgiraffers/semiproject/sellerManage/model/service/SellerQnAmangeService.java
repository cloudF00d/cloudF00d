package com.ohgiraffers.semiproject.sellerManage.model.service;

import com.ohgiraffers.semiproject.sellerManage.model.dao.sellerManage;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageQnADTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerQnAmangeService {

    private final sellerManage Mapper;

    public SellerQnAmangeService(sellerManage mapper) {
        Mapper = mapper;
    }

    public List<SellerManageQnADTO> sellerQnA() {

        List<SellerManageQnADTO> sellerQnA = Mapper.sellerQnA();

        return sellerQnA;
    }
}
