package com.ohgiraffers.semiproject.project.product.model.service;

import com.ohgiraffers.semiproject.project.product.model.dto.ProjectFileDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectOptionDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.TotalStoryDTO;

import java.util.List;

public interface ProductService {
    TotalStoryDTO totalStoryList();

    List<ProjectOptionDTO> optionList();

    ProjectFileDTO projectimage();

//    static List<ProDTO> selectAllproductStoryList() { 왜 스테틱?
}
