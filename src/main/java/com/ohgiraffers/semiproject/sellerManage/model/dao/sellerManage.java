package com.ohgiraffers.semiproject.sellerManage.model.dao;

import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageProjectDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageQnADTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerUserMangeDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper


public interface sellerManage {


    List<SellerManageProjectDTO> sellerProject();

    SellerManageProjectDTO sellerProjectDetail();

    int selectTotalCount(Map<String, String> searchMap);

    List<SellerUserMangeDTO> sellerUser();

    List<SellerManageQnADTO> sellerQnA();
}
