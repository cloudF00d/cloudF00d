package com.ohgiraffers.semiproject.project.projectMake.model.service;

import com.ohgiraffers.semiproject.project.projectMake.model.dao.ProjectMakeMapper;
import com.ohgiraffers.semiproject.project.projectMake.model.dto.ProjectMakeDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProjectMakeService implements ProjectMakeServiceInter{
    private ProjectMakeMapper mapper;

    public ProjectMakeService(ProjectMakeMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public void projectStart(ProjectMakeDTO projectMakeDTO) {
        int result = mapper.projectStart(projectMakeDTO);

        if (result > 0) {
            System.out.println("성공!");
        }

    }

    @Override
    public ProjectMakeDTO whatIsYourProjectCode(ProjectMakeDTO projectMakeDTO) {
        ProjectMakeDTO projectMakeDTO1 = mapper.whatIsYourProjectCode(projectMakeDTO);

        return projectMakeDTO1;

    }

    @Override
    @Transactional
    public void basicInfoUpdate(ProjectMakeDTO projectMakeDTO) {
        int result = mapper.basicInfoUpdate(projectMakeDTO);

        if (result > 0) {
            System.out.println("성공!");
        }
    }

    @Override
    @Transactional
    public void projectStartUpdate(ProjectMakeDTO projectMakeDTO) {
        int result = mapper.projectStartUpdate(projectMakeDTO);

        if (result > 0) {
            System.out.println("성공!");
        }
    }

    @Override
    public ProjectMakeDTO selectMakingProject(int code) {
        ProjectMakeDTO projectMakeDTO = mapper.selectMakingProject(code);

        return projectMakeDTO;
    }


}
