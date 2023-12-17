package com.ohgiraffers.semiproject.sellerManage.model.service;

import com.ohgiraffers.semiproject.sellerManage.model.dao.sellerManage;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SellerProjectService {

    private final sellerManage Mapper;

    public SellerProjectService(sellerManage mapper) {
        Mapper = mapper;
    }

    public List<SellerManageProjectDTO> sellerProject() {

        List<SellerManageProjectDTO> sellerProject = Mapper.sellerProject();

        return sellerProject;
    }
}
