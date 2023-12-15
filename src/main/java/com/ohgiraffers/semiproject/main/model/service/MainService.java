package com.ohgiraffers.semiproject.main.model.service;

import com.ohgiraffers.semiproject.main.model.dao.MainMapper;
import com.ohgiraffers.semiproject.manager.model.dao.BoardMapper;
import com.ohgiraffers.semiproject.main.model.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MainService {

    private final MainMapper mapper;

    public MainService(MainMapper mapper) {
        this.mapper = mapper;
    }

    public List<ProjectDTO> firstNewProject() {

        List<ProjectDTO> project = mapper.firstNewProject();

        return project;
    }

    public List<ProjectDTO> secondNewProject() {
        List<ProjectDTO> project = mapper.secondNewProject();

        return project;
    }

    public List<ProjectDTO> firstReProject() {
        List<ProjectDTO> project = mapper.firstReProject();

        return project;
    }

    public List<ProjectDTO> secondReProject() {
        List<ProjectDTO> project = mapper.secondReProject();

        return project;
    }
}

