package com.ohgiraffers.semiproject.project.product.model.dao;

import com.ohgiraffers.semiproject.project.product.model.dto.TotalStoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectDetailMapper {
    List<TotalStoryDTO> totalStoryList();
}
//