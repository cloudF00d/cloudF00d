package com.ohgiraffers.semiproject.project.projectMake.model.service;

import com.ohgiraffers.semiproject.common.exception.thumbnail.ThumbnailRegistException;
import com.ohgiraffers.semiproject.manager.model.dto.PrivateBusinessDTO;
import com.ohgiraffers.semiproject.project.projectMake.model.dto.*;

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

    ProjectMakeFileDTO selectFileProject(int code);

    void deleteMainPicture(int code);

    void registBusinessLicense(ProjectMakeDTO projectMakeDTO) throws ThumbnailRegistException;

    List<BusinessFileMakeDTO> selectBusinessFile(int code);

    void registProjectDetailImg(ProjectMakeDTO projectMakeDTO) throws ThumbnailRegistException;

    void updateProjectContent(ProjectMakeDTO projectMakeDTO);

    void projectStoryImages(List<ProjectMakeFileDTO> projectMakeFileDTOS);
     void updateSummary(ProjectMakeDTO projectMakeDTO);

    void moveProject(ProjectMakeDTO projectMakeDTO);

    void moveProjectFile(List<ProjectMakeFileDTO> projectMakeFileDTO);

    List<ProjectMakeFileDTO> selectAllFileProject(int code);

    void moveBusiness(BusinessMakeDTO businessMakeDTO);

    void updateBusiness(BusinessMakeDTO businessMakeDTO);

    void moveBusinessFile(List<BusinessFileMakeDTO> businessFileMakeDTOS);

    void updateThumbnail(ProjectMakeDTO projectMakeDTO) throws ThumbnailRegistException;

    void insertOption(List<OptionMakeDTO> optionMakeDTOS);

    List<OptionMakeDTO> selectOption(int code);

    void updateOption(List<OptionMakeDTO> optionMakeDTOS);

    PrivateBusinessDTO findOriginBusiness(int code);
}
