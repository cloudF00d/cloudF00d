package com.ohgiraffers.semiproject.project.product.model.service;

import com.ohgiraffers.semiproject.project.product.model.dto.ProfileImageDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectFileDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectOptionDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.TotalStoryDTO;

import java.util.List;

public interface ProductService {
    TotalStoryDTO totalStoryList(Long no);

    List<ProjectOptionDTO> optionList(Long no);

    List<ProjectFileDTO> projectimage(Long no);

    ProfileImageDTO profileimage(Long no);

//    static List<ProDTO> selectAllproductStoryList() { 왜 스테틱?
}
