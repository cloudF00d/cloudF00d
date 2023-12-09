package com.ohgiraffers.semiproject.project.product.model.dao;

import com.ohgiraffers.semiproject.project.product.model.dto.TotalStoryDTO;

import java.util.List;

public interface ProjectDetailMapper {
    List<TotalStoryDTO> totalStoryList();
}
