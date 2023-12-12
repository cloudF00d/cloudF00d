package com.ohgiraffers.semiproject.manager.model.service;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dao.ManageProjectMapper;
import com.ohgiraffers.semiproject.manager.model.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class ManageProjectService implements ManageProjectServiceInter{


    private final ManageProjectMapper mapper;

    public ManageProjectService(ManageProjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int selectTotalCount(Map<String, String> searchMap) {
        int result = mapper.selectTotalCount(searchMap);

        return result;
    }

    @Override
    public List<ProjectDTO> findAllProject(SelectCriteria selectCriteria) {
        List<ProjectDTO> userDTOS = mapper.findAllProject(selectCriteria);

        return userDTOS;
    }
}
