package com.ohgiraffers.semiproject.sellerManage.model.dao;

import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageProjectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface sellerManage {


    List<SellerManageProjectDTO> sellerProject();
}
