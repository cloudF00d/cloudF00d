package com.ohgiraffers.semiproject.project.projectMake.model.dao;

import com.ohgiraffers.semiproject.project.projectMake.model.dto.ProjectMakeDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMakeMapper {
    int projectStart(ProjectMakeDTO projectMakeDTO);

    ProjectMakeDTO whatIsYourProjectCode(ProjectMakeDTO projectMakeDTO);

    int basicInfoUpdate(ProjectMakeDTO projectMakeDTO);

    int projectStartUpdate(ProjectMakeDTO projectMakeDTO);

    ProjectMakeDTO selectMakingProject(int code);
}
