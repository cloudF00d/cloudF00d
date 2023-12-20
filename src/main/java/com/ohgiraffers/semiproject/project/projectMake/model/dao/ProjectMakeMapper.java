package com.ohgiraffers.semiproject.project.projectMake.model.dao;

import com.ohgiraffers.semiproject.project.projectMake.model.dto.BusinessMakeDTO;
import com.ohgiraffers.semiproject.project.projectMake.model.dto.ProjectMakeDTO;
import com.ohgiraffers.semiproject.project.projectMake.model.dto.ProjectMakeFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ProjectMakeMapper {
    int projectStart(ProjectMakeDTO projectMakeDTO);

    ProjectMakeDTO whatIsYourProjectCode(ProjectMakeDTO projectMakeDTO);

    int basicInfoUpdate(ProjectMakeDTO projectMakeDTO);

    int projectStartUpdate(ProjectMakeDTO projectMakeDTO);

    ProjectMakeDTO selectMakingProject(int code);

    int typeAndTargetUpdate(ProjectMakeDTO projectMakeDTO);

    BusinessMakeDTO alreadyExist(BusinessMakeDTO businessMakeDTO);

    int businessInsert(BusinessMakeDTO businessMakeDTO);

    int busiEmailUpdate(BusinessMakeDTO businessMakeDTO);


    BusinessMakeDTO selectBusiness(int code);

    int planUpdate(ProjectMakeDTO projectMakeDTO);

    int policyUpdate(int code);

    int insertAttachment(ProjectMakeFileDTO projectMakeFileDTO);
}
