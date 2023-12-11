package com.ohgiraffers.semiproject.project.product.model.dao;

import com.ohgiraffers.semiproject.project.product.model.dto.TotalStoryDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectDetailMapper {
    TotalStoryDTO totalStoryList();
}
