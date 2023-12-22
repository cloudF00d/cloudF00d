package com.ohgiraffers.semiproject.project.projectMake.model.service;

import com.ohgiraffers.semiproject.common.exception.thumbnail.ThumbnailRegistException;
import com.ohgiraffers.semiproject.project.projectMake.model.dao.ProjectMakeMapper;
import com.ohgiraffers.semiproject.project.projectMake.model.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.charset.CoderResult;
import java.util.List;
import java.util.Map;

@Service

public class ProjectMakeService implements ProjectMakeServiceInter {
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

    @Override
    @Transactional
    public void typeAndTargetUpdate(ProjectMakeDTO projectMakeDTO) {
        int result = mapper.typeAndTargetUpdate(projectMakeDTO);

        if (result > 0) {
            System.out.println("성공!");
        }
    }

    @Override
    public BusinessMakeDTO alreadyExist(BusinessMakeDTO businessMakeDTO) {
        BusinessMakeDTO businessMakeDTO1 = mapper.alreadyExist(businessMakeDTO);
        return businessMakeDTO1;
    }

    @Override
    @Transactional
    public void businessInsert(BusinessMakeDTO businessMakeDTO) {
        int result = mapper.businessInsert(businessMakeDTO);

        if (result > 0) {
            System.out.println("성공!");
        }
    }

    @Override
    @Transactional
    public void busiEmailUpdate(BusinessMakeDTO businessMakeDTO) {
        int result = mapper.busiEmailUpdate(businessMakeDTO);

        if (result > 0) {
            System.out.println("성공!");
        }
    }

    @Override
    public BusinessMakeDTO selectBusiness(int code) {
        BusinessMakeDTO businessMakeDTO = mapper.selectBusiness(code);

        return businessMakeDTO;
    }

    @Override
    @Transactional
    public void planUpdate(ProjectMakeDTO projectMakeDTO) {
        int result = mapper.planUpdate(projectMakeDTO);

        if (result > 0) {
            System.out.println("성공!");
        }
    }

    @Override
    @Transactional
    public void policyUpdate(int code) {
        int result = mapper.policyUpdate(code);

        if (result > 0) {
            System.out.println("성공!");
        }
    }

    @Override
    @Transactional
    public void registThumbnail(ProjectMakeDTO projectMakeDTO) throws ThumbnailRegistException {
        int result = 0;

        /* 먼저 board 테이블부터 insert 한다. */
//        int boardResult = mapper.insertThumbnailContent(projectMakeDTO);

        /* Attachment 리스트를 불러온다. */
        List<ProjectMakeFileDTO> attachmentList = projectMakeDTO.getAttachmentList();

        /* fileList에 boardNo값을 넣는다. */
        for (int i = 0; i < attachmentList.size(); i++) {
            attachmentList.get(i).setSCode(projectMakeDTO.getSellerCode());
        }

        /* Attachment 테이블에 list size만큼 insert 한다. */
        int attachmentResult = 0;
        for (int i = 0; i < attachmentList.size(); i++) {
            attachmentResult += mapper.insertAttachment(attachmentList.get(i));
        }

//        /* 게시글 추가 및 첨부파일 갯수 만큼 첨부파일 내용 insert에 실패 시 예외 발생 */
        if (!(attachmentResult == attachmentList.size())) {
            throw new ThumbnailRegistException("사진 게시판 등록에 실패하셨습니다.");
        }
    }

    @Override
    public ProjectMakeFileDTO selectFileProject(int code) {
        ProjectMakeFileDTO projectMakeFileDTO = mapper.selectFileProject(code);

        return projectMakeFileDTO;
    }

    @Override
    @Transactional
    public void deleteMainPicture(int code) {
        int result = mapper.deleteMainPicture(code);

        if (result > 0) {
            System.out.println("성공!!");
        }

    }


    @Override
    @Transactional
    public void registBusinessLicense(ProjectMakeDTO projectMakeDTO) throws ThumbnailRegistException {
        int result = 0;

        /* 먼저 board 테이블부터 insert 한다. */
//        int boardResult = mapper.insertThumbnailContent(projectMakeDTO);

        /* Attachment 리스트를 불러온다. */
        List<ProjectMakeFileDTO> attachmentList = projectMakeDTO.getAttachmentList();

        /* fileList에 boardNo값을 넣는다. */
        for (int i = 0; i < attachmentList.size(); i++) {
            attachmentList.get(i).setSCode(projectMakeDTO.getSellerCode());
        }

        /* Attachment 테이블에 list size만큼 insert 한다. */
        int attachmentResult = 0;
        for (int i = 0; i < attachmentList.size(); i++) {
            attachmentResult += mapper.registBusinessLicense(attachmentList.get(i));
        }

//        /* 게시글 추가 및 첨부파일 갯수 만큼 첨부파일 내용 insert에 실패 시 예외 발생 */
        if (!(attachmentResult == attachmentList.size())) {
            throw new ThumbnailRegistException("사진 게시판 등록에 실패하셨습니다.");
        }
    }

    @Override
    public List<BusinessFileMakeDTO> selectBusinessFile(int code) {
        List<BusinessFileMakeDTO> businessFileMakeDTO = mapper.selectBusinessFile(code);

        return businessFileMakeDTO;
    }

    @Override
    public void registProjectDetailImg(ProjectMakeDTO projectMakeDTO) throws ThumbnailRegistException {
        int result = 0;

        /* 먼저 board 테이블부터 insert 한다. */
//        int boardResult = mapper.insertThumbnailContent(projectMakeDTO);

        /* Attachment 리스트를 불러온다. */
        List<ProjectMakeFileDTO> attachmentList = projectMakeDTO.getAttachmentList();

        /* fileList에 boardNo값을 넣는다. */
        for (int i = 0; i < attachmentList.size(); i++) {
            attachmentList.get(i).setSCode(projectMakeDTO.getSellerCode());
        }

        /* Attachment 테이블에 list size만큼 insert 한다. */
        int attachmentResult = 0;
        for (int i = 0; i < attachmentList.size(); i++) {
            attachmentResult += mapper.registProjectDetailImg(attachmentList.get(i));
        }

//        /* 게시글 추가 및 첨부파일 갯수 만큼 첨부파일 내용 insert에 실패 시 예외 발생 */
        if (!(attachmentResult == attachmentList.size())) {
            throw new ThumbnailRegistException("사진 게시판 등록에 실패하셨습니다.");
        }
    }

    @Override
    @Transactional
    public void updateProjectContent(ProjectMakeDTO projectMakeDTO) {
        int result = mapper.updateProjectContent(projectMakeDTO);

        if (result > 0) {
            System.out.println("성공!");
        }
    }

    @Override
    @Transactional
    public void projectStoryImages(List<ProjectMakeFileDTO> projectMakeFileDTOS) {

        int result = mapper.projectStoryImages(projectMakeFileDTOS);

        if (result > 0) {
            System.out.println("성공!");
        }
    }


    @Override
    @Transactional
    public void updateSummary(ProjectMakeDTO projectMakeDTO) {
        int result = mapper.updateSummary(projectMakeDTO);

        if (result > 0) {
            System.out.println("성공!");
        }
    }

    @Override
    @Transactional
    public void moveProject(ProjectMakeDTO projectMakeDTO) {


        ProjectCategoryDTO category = mapper.findCategory(projectMakeDTO.getCategory()); // 카테고리 번호 찾기

        String plan = projectMakeDTO.getPlan(); // plan 이름 담기

        PlanDTO planDTO = mapper.findPlan(plan); // plan 번호 찾기

        ProjectNumberMakeDTO projectNumberMakeDTO = new ProjectNumberMakeDTO(
                projectMakeDTO.getTitle(),
                category.getCategoryCode(),
                projectMakeDTO.getType(),
                planDTO.getPlanCode(),
                projectMakeDTO.getTargetAmount(),
                projectMakeDTO.getEndDate(),
                projectMakeDTO.getStartDate(),
                projectMakeDTO.getSummary(),
                projectMakeDTO.getSellerType(),
                projectMakeDTO.getSellerCode(),
                projectMakeDTO.getPolicy(),
                projectMakeDTO.getContent());

        int result = mapper.moveProject(projectNumberMakeDTO); // 입력됌

        if (result > 0) {
            System.out.println("성공!");

            //tag 넣기
            int code = projectMakeDTO.getSellerCode(); //sellerCode 가져옴
            ProjectDTO projectDTO = mapper.findProjectCode(code); // projectCode 조회
            int projectCode = projectDTO.getProjectCode(); // projectCode 가져옴

            String arr[] = projectMakeDTO.getTag().split("\\s*,\\s*");

            for (String str : arr) {
                int tag = mapper.insertTag(str, projectCode); // 태그 입력됌

                if (tag > 0) {

                    int delete = mapper.deleteMakeProject(code); // 삭제 됌

                    if (delete > 0) {
                        System.out.println("projectMake 삭제 성공!");
                    }
                }
            }

        }


    }

    @Override
    @Transactional
    public void moveProjectFile(List<ProjectMakeFileDTO> projectMakeFileDTO) {
        //먼저 프로젝트 코드를 알아야 한다
        int code = projectMakeFileDTO.get(0).getSCode();
        ProjectDTO projectDTO = mapper.findProjectCode(code);
        int projectCode = projectDTO.getProjectCode();
        System.out.println("projectCode = " + projectCode);

        int i = 0;
        for (i = 0; i < projectMakeFileDTO.size(); i++) {
            System.out.println("projectMakeFileDTO = " + projectMakeFileDTO.get(i));
            if (projectMakeFileDTO.get(i).getOriginFileName() != null){
                ProjectMakeFileDTO A = new ProjectMakeFileDTO(
                        projectMakeFileDTO.get(i).getOriginFileName(),
                        projectMakeFileDTO.get(i).getFCode(),
                        projectMakeFileDTO.get(i).getSCode(),
                        projectMakeFileDTO.get(i).getChangeFileName(),
                        projectMakeFileDTO.get(i).getFilePath(),
                        projectMakeFileDTO.get(i).getCreateDate(),
                        projectMakeFileDTO.get(i).getType(),
                        projectCode
                );
                int result = mapper.moveProjectFile(A);
                if (result > 0) {
                    System.out.println("projectFile 옮기기 " + i + "번째 인덱스 성공!");
                }
            }



        }
        if (i == projectMakeFileDTO.size()) {

            int delete = mapper.deleteMakeProjectFile(code);

            if (delete > 0) {
                System.out.println("projectMakeFile 삭제 성공!");
            }
        }
    }

    @Override
    public List<ProjectMakeFileDTO> selectAllFileProject(int code) {
        List<ProjectMakeFileDTO> businessFileMakeDTO = mapper.selectAllFileProject(code);

        return businessFileMakeDTO;
    }

    @Override
    @Transactional
    public void moveBusiness(BusinessMakeDTO businessMakeDTO) {

        int result = mapper.moveBusiness(businessMakeDTO);

        if (result > 0) {
            System.out.println("moveBusiness 성공!");

            int code = businessMakeDTO.getSellCode();
            int delete = mapper.deleteBusinessMake(code);

            if (delete > 0) {
                System.out.println("businessMake 삭제 성공!");
            }
        }

    }

    @Override
    @Transactional
    public void updateBusiness(BusinessMakeDTO businessMakeDTO) {
        int result = mapper.updateBusiness(businessMakeDTO);

        if (result > 0) {
            System.out.println("성공!");
        }
    }

    @Override
    @Transactional
    public void moveBusinessFile(List<BusinessFileMakeDTO> businessFileMakeDTOS) {
        //삽입하기 위해 참조키인 프로젝트 코드를 알아야 한다
        int code = businessFileMakeDTOS.get(0).getCodeS();
        BusinessDTO projectDTO = mapper.findBusinessCode(code);
        int projectCode = projectDTO.getBusinessCode();

        int i = 0;
        for (i = 0; i < businessFileMakeDTOS.size(); i++) {

            BusinessFileMakeDTO A = new BusinessFileMakeDTO(
                    businessFileMakeDTOS.get(i).getCodeF(),
                    businessFileMakeDTOS.get(i).getCodeS(),
                    businessFileMakeDTOS.get(i).getOriFileName(),
                    businessFileMakeDTOS.get(i).getChanFileName(),
                    businessFileMakeDTOS.get(i).getFPath(),
                    businessFileMakeDTOS.get(i).getDateCrea(),
                    businessFileMakeDTOS.get(i).getFType(),
                    projectCode
            );

            int result = mapper.moveBusinessFile(A);

            if (result > 0) {
                System.out.println("businessFile 옮기기 " + i + "번째 인덱스 성공!");
            }
        }

        if (i == businessFileMakeDTOS.size()) {
            int delete = mapper.deleteBusinessFileMake(code);

            if (delete > 0) {
                System.out.println("businessMakeFile 삭제 성공!");
            }
        }
    }

    @Override
    @Transactional
    public void updateThumbnail(ProjectMakeDTO projectMakeDTO) throws ThumbnailRegistException {
        int result = 0;

        /* 먼저 board 테이블부터 insert 한다. */
//        int boardResult = mapper.insertThumbnailContent(projectMakeDTO);

        /* Attachment 리스트를 불러온다. */
        List<ProjectMakeFileDTO> attachmentList = projectMakeDTO.getAttachmentList();

        /* fileList에 boardNo값을 넣는다. */
        for (int i = 0; i < attachmentList.size(); i++) {
            attachmentList.get(i).setSCode(projectMakeDTO.getSellerCode());
        }

        /* Attachment 테이블에 list size만큼 insert 한다. */
        int attachmentResult = 0;
        for (int i = 0; i < attachmentList.size(); i++) {
            attachmentResult += mapper.updateThumbnail(attachmentList.get(i));
        }

//        /* 게시글 추가 및 첨부파일 갯수 만큼 첨부파일 내용 insert에 실패 시 예외 발생 */
        if (!(attachmentResult == attachmentList.size())) {
            throw new ThumbnailRegistException("사진 게시판 등록에 실패하셨습니다.");
        }
    }
}
