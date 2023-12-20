package com.ohgiraffers.semiproject.project.projectMake.model.service;

import com.ohgiraffers.semiproject.common.exception.thumbnail.ThumbnailRegistException;
import com.ohgiraffers.semiproject.project.projectMake.model.dto.BusinessMakeDTO;
import com.ohgiraffers.semiproject.project.projectMake.model.dto.ProjectMakeDTO;

import java.util.List;
import java.util.Map;

public interface ProjectMakeServiceInter {
    void projectStart(ProjectMakeDTO projectMakeDTO);

    ProjectMakeDTO whatIsYourProjectCode(ProjectMakeDTO projectMakeDTO);

    void basicInfoUpdate(ProjectMakeDTO projectMakeDTO);

    void projectStartUpdate(ProjectMakeDTO projectMakeDTO);

    ProjectMakeDTO selectMakingProject(int code);


    void typeAndTargetUpdate(ProjectMakeDTO projectMakeDTO);

    BusinessMakeDTO alreadyExist(BusinessMakeDTO businessMakeDTO);

    void businessInsert(BusinessMakeDTO businessMakeDTO);

    void busiEmailUpdate(BusinessMakeDTO businessMakeDTO);

    BusinessMakeDTO selectBusiness(int code);

    void planUpdate(ProjectMakeDTO projectMakeDTO);

    void policyUpdate(int code);

    void registThumbnail(ProjectMakeDTO projectMakeDTO) throws ThumbnailRegistException;
}
