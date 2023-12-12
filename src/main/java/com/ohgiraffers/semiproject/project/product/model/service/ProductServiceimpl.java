package com.ohgiraffers.semiproject.project.product.model.service;

import com.ohgiraffers.semiproject.project.product.model.dao.ProjectDetailMapper;
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
    public TotalStoryDTO totalStoryList() {
        TotalStoryDTO thumbnailList = mapper.totalStoryList();

        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectAllThumbnailList ===================== {}", thumbnailList);

        return thumbnailList;
    }
}
