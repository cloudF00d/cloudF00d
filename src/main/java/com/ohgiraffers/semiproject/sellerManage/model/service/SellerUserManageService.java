package com.ohgiraffers.semiproject.sellerManage.model.service;

import com.ohgiraffers.semiproject.sellerManage.model.dao.sellerManage;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerUserMangeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SellerUserManageService {

    private final sellerManage Mapper;

    public SellerUserManageService(sellerManage mapper) {
        Mapper = mapper;
    }


    public List<SellerUserMangeDTO> sellerUser() {

        List<SellerUserMangeDTO> sellerUser = Mapper.sellerUser();

        return sellerUser;
    }


}
