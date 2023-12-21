package com.ohgiraffers.semiproject.project.projectMake.model.dao;

import com.ohgiraffers.semiproject.project.projectMake.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
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

    ProjectMakeFileDTO selectFileProject(int code);

    int deleteMainPicture(int code);

    int registBusinessLicense(ProjectMakeFileDTO projectMakeFileDTO);

    List<BusinessFileMakeDTO> selectBusinessFile(int code);

    int registProjectDetailImg(ProjectMakeFileDTO projectMakeFileDTO);

    int updateProjectContent(ProjectMakeDTO projectMakeDTO);

    int projectStoryImages(List<ProjectMakeFileDTO> projectMakeFileDTOS);

    int updateSummary(ProjectMakeDTO projectMakeDTO);

    int moveProject(ProjectNumberMakeDTO projectMakeDTO);

    ProjectCategoryDTO findCategory(String category);

    PlanDTO findPlan(String plan);


    List<ProjectMakeFileDTO> selectAllFileProject(int code);

    ProjectDTO findProjectCode(int code);

    int moveProjectFile(ProjectMakeFileDTO projectMakeFileDTO, int projectCode);

    int moveBusiness(BusinessMakeDTO businessMakeDTO);
}
