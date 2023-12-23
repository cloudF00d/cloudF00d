package com.ohgiraffers.semiproject.project.projectMake.model.dao;

import com.ohgiraffers.semiproject.manager.model.dto.PrivateBusinessDTO;
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

    ProjectDTO findProjectCode(ProjectMakeDTO projectMakeDTO);



    int moveBusiness(BusinessMakeDTO businessMakeDTO);

    int updateBusiness(BusinessMakeDTO businessMakeDTO);

    BusinessDTO findBusinessCode(int code);



    int deleteMakeProject(int code);

    int deleteMakeProjectFile(int code);

    int deleteBusinessMake(int code);

    int deleteBusinessFileMake(int code);

    int updateThumbnail(ProjectMakeFileDTO projectMakeFileDTO);

    int insertTag(PlanDTO a);

    int moveProjectFile(ProjectMakeFileDTO a);

    int moveBusinessFile(BusinessFileMakeDTO a);

    int insertOption(OptionMakeDTO op);

    List<OptionMakeDTO> selectOption(int code);

    void moveOption(OptionMakeDTO op);

    int updateOption(OptionMakeDTO optionMakeDTOS);

    PrivateBusinessDTO findOriginBusiness(int code);

    int deleteOption(int code);
}
