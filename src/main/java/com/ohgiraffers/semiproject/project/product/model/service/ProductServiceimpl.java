package com.ohgiraffers.semiproject.project.product.model.service;

import com.ohgiraffers.semiproject.project.product.model.dao.ProjectDetailMapper;
import com.ohgiraffers.semiproject.project.product.model.dto.ProfileImageDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectFileDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectOptionDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.TotalStoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceimpl implements ProductService {

    private final ProjectDetailMapper mapper;

    public ProductServiceimpl(ProjectDetailMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public TotalStoryDTO totalStoryList(Long no) {
        TotalStoryDTO thumbnailList = mapper.totalStoryList(no);

        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectAllThumbnailList ===================== {}", thumbnailList);

        return thumbnailList;
    }

    @Override
    public List<ProjectOptionDTO> optionList(Long no) {

        return mapper.optionList(no);
    }

    @Override
    public List<ProjectFileDTO> projectimage(Long no) {
        return mapper.projectimage(no);
    }

    @Override
    public ProfileImageDTO profileimage(Long no) {
        return mapper.profileimage(no);
    }
}