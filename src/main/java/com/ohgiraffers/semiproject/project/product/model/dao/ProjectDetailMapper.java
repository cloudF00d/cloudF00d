package com.ohgiraffers.semiproject.project.product.model.dao;

import com.ohgiraffers.semiproject.project.product.model.dto.ProfileImageDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectFileDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectOptionDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.TotalStoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectDetailMapper {
    TotalStoryDTO totalStoryList(Long no);
    List<ProjectOptionDTO> optionList(Long no);

    List<ProjectFileDTO> projectimage(Long no);

    ProfileImageDTO profileimage(Long no);
}
//