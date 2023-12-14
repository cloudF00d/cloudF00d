package com.ohgiraffers.semiproject.project.product.model.service;

import com.ohgiraffers.semiproject.project.product.model.dto.ProfileImageDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectFileDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectOptionDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.TotalStoryDTO;

import java.util.List;

public interface ProductService {
    TotalStoryDTO totalStoryList();

    List<ProjectOptionDTO> optionList();

    List<ProjectFileDTO> projectimage();

    ProfileImageDTO profileimage();

//    static List<ProDTO> selectAllproductStoryList() { 왜 스테틱?
}
