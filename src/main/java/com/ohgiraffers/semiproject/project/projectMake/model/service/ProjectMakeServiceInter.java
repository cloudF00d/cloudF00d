package com.ohgiraffers.semiproject.project.projectMake.model.service;

import com.ohgiraffers.semiproject.project.projectMake.model.dto.ProjectMakeDTO;

import java.util.List;

public interface ProjectMakeServiceInter {
    void projectStart(ProjectMakeDTO projectMakeDTO);

    ProjectMakeDTO whatIsYourProjectCode(ProjectMakeDTO projectMakeDTO);

    void basicInfoUpdate(ProjectMakeDTO projectMakeDTO);

    void projectStartUpdate(ProjectMakeDTO projectMakeDTO);

    ProjectMakeDTO selectMakingProject(int code);
}
