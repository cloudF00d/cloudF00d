package com.ohgiraffers.semiproject.main.model.dao;

import com.ohgiraffers.semiproject.main.model.dto.ProjectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    List<ProjectDTO> firstNewProject();

    List<ProjectDTO> secondNewProject();

    List<ProjectDTO> firstReProject();

    List<ProjectDTO> secondReProject();
}
