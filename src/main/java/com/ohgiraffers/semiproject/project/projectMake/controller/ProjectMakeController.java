package com.ohgiraffers.semiproject.project.projectMake.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.semiproject.common.exception.thumbnail.ThumbnailRegistException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.project.projectMake.model.dto.*;
import com.ohgiraffers.semiproject.project.projectMake.model.service.ProjectMakeService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.lang.model.SourceVersion;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.security.Principal;
import java.util.*;

@Controller
@Slf4j
@RequestMapping("/projectMake")
public class ProjectMakeController {
    @Value("")
    private String IMAGE_DIR;

    @Value("C:/uploadfile/")
    private String ROOT_LOCATION;

    private final ProjectMakeService projectMakeService;

    private final ObjectMapper objectMapper;

    public ProjectMakeController(ProjectMakeService projectMakeService, ObjectMapper objectMapper) {
        this.projectMakeService = projectMakeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("projectApply")
    public String projectApply() {

        return "/content/project/projectMake/projectApply";

    }

    @GetMapping("/projectStart")
    public String projectStart(@AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO,
                               Model mv,
                               Principal principal) {

        int code = memberAndAuthorityDTO.getMemberDTO().getUserCode();

        ProjectMakeDTO projectMakeDTO = projectMakeService.selectMakingProject(code);


        List<String> categories = Arrays.asList("음료", "주류", "베이커리", "해외음식", "채소", "해산물", "과일", "냉동식품", "소스", "디저트");

        System.out.println("memberAndAuthorityDTO = " + memberAndAuthorityDTO);

        mv.addAttribute("option", categories);
        mv.addAttribute("project", projectMakeDTO);

        return "/content/project/projectMake/projectStart";

    }

    @PostMapping("/projectStart")
    public String projectStart2(@ModelAttribute ProjectMakeDTO projectMakeDTO) {

        System.out.println("postMapping projectMakeDTO = " + projectMakeDTO); // 값 잘 들어왔는지 확인

        ProjectMakeDTO projectMakeDTO2 = projectMakeService.whatIsYourProjectCode(projectMakeDTO); // 이미 임시저장한 프로젝트를 가지고 있는지 확인

        if (projectMakeDTO2 == null) {
            System.out.println("저장된 프로젝트가 없군요! 새로 작성하겠습니다");
            projectMakeService.projectStart(projectMakeDTO); // category insert
            ProjectMakeDTO projectMakeDTO123 = projectMakeService.whatIsYourProjectCode(projectMakeDTO); // 다시 값을 가져옴

        } else if (projectMakeDTO2 != null) {
            System.out.println("이미 작성하던 프로젝트가 있군요! 해당 페이지로 이동합니다.");
            projectMakeService.projectStartUpdate(projectMakeDTO);
        }

        return "/content/project/projectMake/projectManage";

    }


    @GetMapping("projectManage")
    public String projectManage() {

        return "/content/project/projectMake/projectManage";

    }

    @GetMapping("projectManageform")
    public String projectManageform() {

        return "/content/project/projectMake/projectManageform";

    }

    @GetMapping("basicInfo")
    public String basicInfo(@AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO,
                            Model mv) {

        int code = memberAndAuthorityDTO.getMemberDTO().getUserCode();

        ProjectMakeDTO projectMakeDTO = projectMakeService.selectMakingProject(code);
        ProjectMakeFileDTO projectMakeFileDTO = projectMakeService.selectFileProject(code);

        System.out.println("memberAndAuthorityDTO = " + memberAndAuthorityDTO);

        mv.addAttribute("project", projectMakeDTO);
        mv.addAttribute("projectFile", projectMakeFileDTO);

        return "/content/project/projectManage/basicInfo";

    }

    @PostMapping("basicInfo")
    public String basicInfo2(@ModelAttribute ProjectMakeDTO projectMakeDTO,
                             @RequestParam("mainPicture") MultipartFile mainPicture,
                             RedirectAttributes rttr) throws ThumbnailRegistException {

        int code = projectMakeDTO.getSellerCode(); // 사용자 코드 추출

        ProjectMakeFileDTO projectMakeFileDTO = projectMakeService.selectFileProject(code); // 이미 입력한 대표 사진이 있는지 확인

        if (projectMakeFileDTO != null) {
            projectMakeService.deleteMainPicture(code); //  있는 경우 기존 대표 이미지 삭제
        }
        System.out.println("mainPicture = " + mainPicture);

        String rootLocation = ROOT_LOCATION + IMAGE_DIR;

        String fileUploadDirectory = rootLocation + "origin/Representative_image";
        String thumbnailDirectory = rootLocation + "Representative_image";

        File directory = new File(fileUploadDirectory);
        File directory2 = new File(thumbnailDirectory);

        log.info("[ThumbnailController] fileUploadDirectory : " + directory);
        log.info("[ThumbnailController] thumbnailDirectory : " + directory2);

        /* 파일 저장경로가 존재하지 않는 경우 디렉토리를 생성한다. */
        if (!directory.exists() || !directory2.exists()) {

            /* 폴더를 한 개만 생성할거면 mkdir, 상위 폴더도 존재하지 않으면 한 번에 생성하란 의미로 mkdirs를 이용한다. */
            log.info("[ThumbnailController] 폴더 생성 : " + directory.mkdirs());
            log.info("[ThumbnailController] 폴더 생성 : " + directory2.mkdirs());
        }

        /* 업르도 파일 하나하나에 대한 정보를 담을 리스트 */
        List<Map<String, String>> fileList = new ArrayList<>();

        List<MultipartFile> paramFileList = new ArrayList<>();
        paramFileList.add(mainPicture);
        log.info("[ThumbnailController] mainPicture : " + mainPicture);
//        paramFileList.add(thumbnailImg2);
//        log.info("[ThumbnailController] thumbnailImg2 : " + thumbnailImg2);
//        paramFileList.add(thumbnailImg3);
//        log.info("[ThumbnailController] thumbnailImg3 : " + thumbnailImg3);
//        paramFileList.add(thumbnailImg4);
//        log.info("[ThumbnailController] thumbnailImg4 : " + thumbnailImg4);


        try {
            for (MultipartFile paramFile : paramFileList) {
                if (paramFile.getSize() > 0) {
                    String originFileName = paramFile.getOriginalFilename();
                    log.info("[ThumbnailController] originFileName : " + originFileName);

                    String ext = originFileName.substring(originFileName.lastIndexOf("."));
                    String savedFileName = UUID.randomUUID().toString().replace("-", "") + ext;
                    log.info("[ThumbnailController] 변경한 이름 : " + savedFileName);
                    log.info("[ThumbnailController] paramFile : " + fileUploadDirectory + "/" + savedFileName);
                    paramFile.transferTo(new File(fileUploadDirectory + "/" + savedFileName));

                    /* DB에 업로드한 파일의 정보를 저장하는 비지니스 로직 수행 */
                    /* 필요한 정보를 Map에 담는다. */
                    Map<String, String> fileMap = new HashMap<>();
                    fileMap.put("originFileName", originFileName);
                    fileMap.put("savedFileName", savedFileName);
                    fileMap.put("savePath", thumbnailDirectory);

                    /* 제목 사진과 나머지 사진을 구분하고 썸네일도 생성한다. */
                    int width = 0;
                    int height = 0;

                    String fieldName = paramFile.getName();
                    log.info("[ThumbnailController] 필드 name : " + fieldName);

                    fileMap.put("fileType", "Representative_image");

                    /* 썸네일로 변환 할 사이즈를 지정한다. */
                    width = 300;
                    height = 150;

                    /* 썸네일로 변환 후 저장한다. */
                    Thumbnails.of(fileUploadDirectory + "/" + savedFileName).size(width, height)
                            .toFile(thumbnailDirectory + "/thumbnail_" + savedFileName);

                    /* 나중에 웹서버에서 접근 가능한 경로 형태로 썸네일의 저장 경로도 함께 저장한다. */
                    fileMap.put("thumbnailPath", "/thumbnail_" + savedFileName);

                    fileList.add(fileMap);
                }
            }

            log.info("[ThumbnailController] fileList =============================: " + fileList);

            /* 서비스를 요청할 수 있도록 BoardDTO에 담는다. */

            projectMakeDTO.setAttachmentList(new ArrayList<ProjectMakeFileDTO>());
            List<ProjectMakeFileDTO> list = projectMakeDTO.getAttachmentList();
            for (int i = 0; i < fileList.size(); i++) {
                Map<String, String> file = fileList.get(i);

                ProjectMakeFileDTO tempFileInfo = new ProjectMakeFileDTO();
                tempFileInfo.setOriginFileName(file.get("originFileName"));
                tempFileInfo.setChangeFileName(file.get("thumbnailPath"));
                tempFileInfo.setFilePath(file.get("savePath"));
                tempFileInfo.setType(file.get("fileType"));

                list.add(tempFileInfo);
            }

            log.info("[ThumbnailController] projectMakeDTO : " + projectMakeDTO);

            projectMakeService.registThumbnail(projectMakeDTO);

            rttr.addFlashAttribute("message", "사진 게시판 등록에 성공하셨습니다.");

        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();

            /* 어떤 종류의 Exception이 발생 하더라도실패 시 파일을 삭제해야 한다. */
            int cnt = 0;
            for (int i = 0; i < fileList.size(); i++) {
                Map<String, String> file = fileList.get(i);

                File deleteFile = new File(fileUploadDirectory + "/" + file.get("savedFileName"));
                boolean isDeleted1 = deleteFile.delete();

                File deleteThumbnail = new File(thumbnailDirectory + "/thumbnail_" + file.get("savedFileName"));
                boolean isDeleted2 = deleteThumbnail.delete();

                if (isDeleted1 && isDeleted2) {
                    cnt++;
                }
            }

            if (cnt == fileList.size()) {
                log.info("[ThumbnailController] 업로드에 실패한 모든 사진 삭제 완료!");
                e.printStackTrace();
            } else {
                e.printStackTrace();
            }
        }

        log.info("[ThumbnailController] ========================================================= end");

        return "redirect:/projectMake/projectManage";
    }

    @GetMapping("projectInfo")
    public String projectInfo(@AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO,
                              Model mv) {

        int code = memberAndAuthorityDTO.getMemberDTO().getUserCode();

        ProjectMakeDTO projectMakeDTO = projectMakeService.selectMakingProject(code);
        BusinessMakeDTO businessMakeDTO = projectMakeService.selectBusiness(code);
        List<BusinessFileMakeDTO> businessFileMakeDTO = projectMakeService.selectBusinessFile(code);


        System.out.println("memberAndAuthorityDTO = " + memberAndAuthorityDTO);

        mv.addAttribute("project", projectMakeDTO);
        mv.addAttribute("business", businessMakeDTO);
        mv.addAttribute("businessFile", businessFileMakeDTO);

        return "/content/project/projectManage/projectInfo";

    }

    @PostMapping("projectInfo")
    public String projectInfo2(@ModelAttribute ProjectMakeDTO projectMakeDTO,
                               @ModelAttribute BusinessMakeDTO businessMakeDTO,
                               @RequestParam("businessFile") List<MultipartFile> mainPicture,
                               RedirectAttributes rttr) throws ThumbnailRegistException {
        System.out.println("projectMakeDTO = " + projectMakeDTO); // type 이랑 targetAmount 이랑 sellerType 받기 위함

        System.out.println("businessMakeDTO = " + businessMakeDTO); // busiEmail 받기 위함

        businessMakeDTO.setSellCode(projectMakeDTO.getSellerCode()); // 기준이 될 유저코드 전달

        projectMakeService.typeAndTargetUpdate(projectMakeDTO); // project의 type 이랑 targetAmount 이랑 sellerType update

        BusinessMakeDTO businessMakeDTO1 = projectMakeService.alreadyExist(businessMakeDTO); // 기존에 만들어둔 business가 있는지 확인

        if (businessMakeDTO1 == null) {
            System.out.println("저장된 프로젝트가 없군요! 새로 작성하겠습니다");
            projectMakeService.businessInsert(businessMakeDTO); // business insert

        } else if (businessMakeDTO1 != null) {
            System.out.println("이미 작성하던 프로젝트가 있군요! 해당 페이지로 이동합니다.");
            projectMakeService.busiEmailUpdate(businessMakeDTO); // business update
        }
//        int code = projectMakeDTO.getSellerCode(); // 사용자 코드 추출
//
//        ProjectMakeFileDTO projectMakeFileDTO = projectMakeService.selectFileProject(code); //
//
//        if(projectMakeFileDTO != null){
//            projectMakeService.deleteMainPicture(code); // 기존 대표이미지를 지우고 다시 삽입
//        }

        String rootLocation = ROOT_LOCATION + IMAGE_DIR;

        String fileUploadDirectory = rootLocation + "origin/businessFile";
        String thumbnailDirectory = rootLocation + "businessFile";

        File directory = new File(fileUploadDirectory);
        File directory2 = new File(thumbnailDirectory);

        log.info("[ThumbnailController] fileUploadDirectory : " + directory);
        log.info("[ThumbnailController] thumbnailDirectory : " + directory2);

        /* 파일 저장경로가 존재하지 않는 경우 디렉토리를 생성한다. */
        if (!directory.exists() || !directory2.exists()) {

            /* 폴더를 한 개만 생성할거면 mkdir, 상위 폴더도 존재하지 않으면 한 번에 생성하란 의미로 mkdirs를 이용한다. */
            log.info("[ThumbnailController] 폴더 생성 : " + directory.mkdirs());
            log.info("[ThumbnailController] 폴더 생성 : " + directory2.mkdirs());
        }

        /* 업르도 파일 하나하나에 대한 정보를 담을 리스트 */
        List<Map<String, String>> fileList = new ArrayList<>();

        List<MultipartFile> paramFileList = new ArrayList<>();
        for (int i = 0; i < mainPicture.size(); i++) {
            paramFileList.add(mainPicture.get(i));
        }
        log.info("[ThumbnailController] mainPicture : " + mainPicture);
//        paramFileList.add(thumbnailImg2);
//        log.info("[ThumbnailController] thumbnailImg2 : " + thumbnailImg2);
//        paramFileList.add(thumbnailImg3);
//        log.info("[ThumbnailController] thumbnailImg3 : " + thumbnailImg3);
//        paramFileList.add(thumbnailImg4);
//        log.info("[ThumbnailController] thumbnailImg4 : " + thumbnailImg4);


        try {
            for (MultipartFile paramFile : paramFileList) {
                if (paramFile.getSize() > 0) {
                    String originFileName = paramFile.getOriginalFilename();
                    log.info("[ThumbnailController] originFileName : " + originFileName);

                    String ext = originFileName.substring(originFileName.lastIndexOf("."));
                    String savedFileName = UUID.randomUUID().toString().replace("-", "") + ext;
                    log.info("[ThumbnailController] 변경한 이름 : " + savedFileName);
                    log.info("[ThumbnailController] paramFile : " + fileUploadDirectory + "/" + savedFileName);
                    paramFile.transferTo(new File(fileUploadDirectory + "/" + savedFileName));

                    /* DB에 업로드한 파일의 정보를 저장하는 비지니스 로직 수행 */
                    /* 필요한 정보를 Map에 담는다. */
                    Map<String, String> fileMap = new HashMap<>();
                    fileMap.put("originFileName", originFileName);
                    fileMap.put("savedFileName", savedFileName);
                    fileMap.put("savePath", thumbnailDirectory);

                    /* 제목 사진과 나머지 사진을 구분하고 썸네일도 생성한다. */
                    int width = 0;
                    int height = 0;

                    String fieldName = paramFile.getName();
                    log.info("[ThumbnailController] 필드 name : " + fieldName);

                    fileMap.put("fileType", "Business_license");

                    /* 썸네일로 변환 할 사이즈를 지정한다. */
                    width = 300;
                    height = 150;

                    /* 썸네일로 변환 후 저장한다. */
                    Thumbnails.of(fileUploadDirectory + "/" + savedFileName).size(width, height)
                            .toFile(thumbnailDirectory + "/businessLicense_" + savedFileName);

                    /* 나중에 웹서버에서 접근 가능한 경로 형태로 썸네일의 저장 경로도 함께 저장한다. */
                    fileMap.put("thumbnailPath", "/businessLicense_" + savedFileName);

                    fileList.add(fileMap);
                }
            }

            log.info("[ThumbnailController] fileList =============================: " + fileList);

            /* 서비스를 요청할 수 있도록 BoardDTO에 담는다. */

            projectMakeDTO.setAttachmentList(new ArrayList<ProjectMakeFileDTO>());
            List<ProjectMakeFileDTO> list = projectMakeDTO.getAttachmentList();
            for (int i = 0; i < fileList.size(); i++) {
                Map<String, String> file = fileList.get(i);

                ProjectMakeFileDTO tempFileInfo = new ProjectMakeFileDTO();
                tempFileInfo.setOriginFileName(file.get("originFileName"));
                tempFileInfo.setChangeFileName(file.get("thumbnailPath"));
                tempFileInfo.setFilePath(file.get("savePath"));
                tempFileInfo.setType(file.get("fileType"));

                list.add(tempFileInfo);
            }

            log.info("[ThumbnailController] projectMakeDTO : " + projectMakeDTO);

            projectMakeService.registBusinessLicense(projectMakeDTO);

            rttr.addFlashAttribute("message", "사진 게시판 등록에 성공하셨습니다.");

        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();

            /* 어떤 종류의 Exception이 발생 하더라도실패 시 파일을 삭제해야 한다. */
            int cnt = 0;
            for (int i = 0; i < fileList.size(); i++) {
                Map<String, String> file = fileList.get(i);

                File deleteFile = new File(fileUploadDirectory + "/" + file.get("savedFileName"));
                boolean isDeleted1 = deleteFile.delete();

                File deleteThumbnail = new File(thumbnailDirectory + "/businessLicense_" + file.get("savedFileName"));
                boolean isDeleted2 = deleteThumbnail.delete();

                if (isDeleted1 && isDeleted2) {
                    cnt++;
                }
            }

            if (cnt == fileList.size()) {
                log.info("[ThumbnailController] 업로드에 실패한 모든 사진 삭제 완료!");
                e.printStackTrace();
            } else {
                e.printStackTrace();
            }
        }

        log.info("[ThumbnailController] ========================================================= end");


        return "redirect:/projectMake/projectInfo";

    }

    @GetMapping("payChoice")
    public String payChoice(@AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO,
                            Model mv) {

        int code = memberAndAuthorityDTO.getMemberDTO().getUserCode();

        ProjectMakeDTO projectMakeDTO = projectMakeService.selectMakingProject(code);

        System.out.println("memberAndAuthorityDTO = " + memberAndAuthorityDTO);

        mv.addAttribute("project", projectMakeDTO);

        return "/content/project/projectManage/payChoice";

    }

    @PostMapping("payChoice")
    public String payChoice2(@ModelAttribute ProjectMakeDTO projectMakeDTO) {
        System.out.println("projectMakeDTO = " + projectMakeDTO); // code 이랑 plan 받기 위함

        projectMakeService.planUpdate(projectMakeDTO); // project update

        return "redirect:/projectMake/payChoice";

    }

    @GetMapping("projectStory")
    public String projectStory(@AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO,
                               Model mv) {

        int code = memberAndAuthorityDTO.getMemberDTO().getUserCode();

        ProjectMakeDTO projectMakeDTO = projectMakeService.selectMakingProject(code);

        System.out.println("memberAndAuthorityDTO = " + memberAndAuthorityDTO);

        mv.addAttribute("project", projectMakeDTO);


        return "/content/project/projectManage/projectStory";

    }

    @PostMapping("projectStory")
    public String projectStory2(@ModelAttribute ProjectMakeDTO projectMakeDTO
    ) {

        System.out.println("projectMakeDTO = " + projectMakeDTO); // 키값이랑 summary 잘 들어왔나 확인

        projectMakeService.updateSummary(projectMakeDTO);


        return "redirect:/projectMake/projectStory";


    }

    @GetMapping("sellerInfo")
    public String sellerInfo() {
        return "/content/project/projectManage/sellerInfo";

    }

    @GetMapping("/projectAgree")
    public String projectAgree(@AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO,
                               Model mv) {

        int code = memberAndAuthorityDTO.getMemberDTO().getUserCode();

        ProjectMakeDTO projectMakeDTO = projectMakeService.selectMakingProject(code);

        System.out.println("memberAndAuthorityDTO = " + memberAndAuthorityDTO);

        mv.addAttribute("project", projectMakeDTO);

        return "/content/project/projectManage/projectAgree";

    }

    @PostMapping("/projectAgree")
    public String projectAgree2(@AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO) {

        int code = memberAndAuthorityDTO.getMemberDTO().getUserCode(); // 코드 가져오기
        projectMakeService.policyUpdate(code); // make project update

        // projectMake 먼저 프로젝트에 삽입
        ProjectMakeDTO projectMakeDTO = projectMakeService.selectMakingProject(code); //사용자 코드로 기존의 내용 조회
        projectMakeService.moveProject(projectMakeDTO); // 값 옮기기

        // projectFileMake 삽입
        List<ProjectMakeFileDTO> projectMakeFileDTO = projectMakeService.selectAllFileProject(code); // 사용자 코드로 기존의 projectMakeFile 조회
        projectMakeService.moveProjectFile(projectMakeFileDTO);

        //business 삽입 (유저코드로 삽입)
        BusinessMakeDTO businessMakeDTO = projectMakeService.selectBusiness(code);
        projectMakeService.moveBusiness(businessMakeDTO);

        //business file 삽입 (비지니스 코드로 삽입)


        return "/content/project/projectManage/projectAgree";

    }


    @GetMapping("/summernote")
    public String summernote(@AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO,
                             Model mv) {

        int code = memberAndAuthorityDTO.getMemberDTO().getUserCode();

        ProjectMakeDTO projectMakeDTO = projectMakeService.selectMakingProject(code);

        System.out.println("projectMakeDTO = " + projectMakeDTO);

        System.out.println("memberAndAuthorityDTO = " + memberAndAuthorityDTO);

        mv.addAttribute("project", projectMakeDTO);


        return "/content/project/projectManage/summernote";
    }

    @PostMapping("/summernote")
    public String summernote2(@RequestParam String summernote,
                              @RequestParam String uploadedImages,
                              RedirectAttributes rttr,
                              @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO) throws JsonProcessingException {


        System.out.println("uploadedImages = " + uploadedImages);
        if (uploadedImages == null || uploadedImages == "" || uploadedImages.isBlank() || uploadedImages.isEmpty()) {
            System.out.println("조건이 부합하지 않으므로 썸머노트만 저장합니다");
            int sCode = memberAndAuthorityDTO.getMemberDTO().getUserCode();

            ProjectMakeDTO projectMakeDTO = new ProjectMakeDTO(sCode, summernote);
            projectMakeService.updateProjectContent(projectMakeDTO); // 써머노트 DB에 저장
        } else {


            List<UploadedImagesDTO> uploadedImageList = objectMapper.readValue(uploadedImages, new TypeReference<List<UploadedImagesDTO>>() {
            });
            log.info("이제 JSON으로 고친 값...");
            System.out.println("uploadedImageList = " + uploadedImageList);

            List<ProjectMakeFileDTO> projectMakeFileDTOS = new ArrayList<>();

            ProjectMakeFileDTO projectMakeFileDTO = null;

            int sCode = memberAndAuthorityDTO.getMemberDTO().getUserCode();

            for (UploadedImagesDTO im : uploadedImageList) {
                projectMakeFileDTO = new ProjectMakeFileDTO(im.getSourceName(), sCode, im.getConvertPath(), im.getSavePath());

                projectMakeFileDTOS.add(projectMakeFileDTO);
            }

            System.out.println("projectMakeFileDTOS = " + projectMakeFileDTOS);
            projectMakeService.projectStoryImages(projectMakeFileDTOS);


            ProjectMakeDTO projectMakeDTO = new ProjectMakeDTO(sCode, summernote);
            projectMakeService.updateProjectContent(projectMakeDTO); // 써머노트 DB에 저장

        }


        return "redirect:/projectMake/projectStory";
    }

    @PostMapping(value = "/uploadSummernoteImageFile", produces = "application/json")
    @ResponseBody
    public Map<String, String> uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {
        log.info("");
        log.info("");
        log.info("[BoardWriteController] uploadSummernoteImageFile =====... start");
        String rootLocation = ROOT_LOCATION + IMAGE_DIR;
        // C:/hedgehog/img

        String fileUploadDirectory = rootLocation + "Representative_image";
        String thumnailDirectory = rootLocation + "Representative_image";

        File directory = new File(fileUploadDirectory);
        File directory2 = new File(thumnailDirectory);

        log.info("~~~~~~~~~~~~~~~~~~~~~fileUploadDirectory" + fileUploadDirectory);
        log.info("****************************thumnailDirectory" + thumnailDirectory);

        if (!directory.exists() || !directory2.exists()) {
            log.info("*************************** 폴더 생성" + directory.mkdirs());
            log.info("*************************** 폴더 생성2" + directory2.mkdirs());
        }

        Map<String, String> returnMap = new HashMap<>();
        String originalFileName = multipartFile.getOriginalFilename(); // source_name에 저장됨
        String ext = originalFileName.substring(originalFileName.lastIndexOf(".")); // source_name 에서 확장자를 가져옴
        String convertName = UUID.randomUUID().toString().replace("-", "") + ext; // convert_name. 새롭게 만든 파일이름
        log.info("원본 파일 명... 올릴당시... source_name : " + originalFileName);
        log.info("변환 파일 명... convert_name : " + convertName);
        File originalFile = new File(fileUploadDirectory + "/" + convertName);
        log.info("드라이브에 저장된 경로... : " + fileUploadDirectory + "/" + convertName);

        String convertPath = "/Detailed_image_" + convertName;
        log.info("변환파일 경로(실제로 사용하는 사진) : " + convertPath);
        log.info("변환파일 저장 경로 : " + thumnailDirectory + convertPath);
        File convertFile = new File(thumnailDirectory + convertPath);

        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, originalFile);

            int maxWidth = 640;
            int maxHeight = 640;

            Thumbnails.Builder<File> thumbnailBuilder = Thumbnails.of(originalFile);

            int originalWidth = (int) ImageIO.read(originalFile).getWidth();
            int originalHeight = (int) ImageIO.read(originalFile).getHeight();
            log.info("원본 사진의 너비... : " + originalWidth);
            log.info("원본 사진의 높이... : " + originalHeight);

            if (originalWidth <= maxWidth && originalHeight <= maxHeight) {
                thumbnailBuilder.size(originalWidth, originalHeight);
            } else {
                thumbnailBuilder.size(maxWidth, maxHeight).keepAspectRatio(true);
            }

            thumbnailBuilder
                    .toFile(convertFile);

            returnMap.put("convertPath", convertPath);
            returnMap.put("savePath", fileUploadDirectory);
            returnMap.put("sourceName", originalFileName);
            returnMap.put("convertName", convertName);
            returnMap.put("url", "/thumbPath" + convertPath);
            returnMap.put("responseCode", "success");
        } catch (IOException e) {
            FileUtils.deleteQuietly(originalFile);
            FileUtils.deleteQuietly(convertFile);
            e.printStackTrace();
        }

        log.info("[BoardWriteController] uploadSummernoteImageFile ======== return \n {}", returnMap);
        log.info("[BoardWriteController] uploadSummernoteImageFile ======== end");

        return returnMap;
    }

    @GetMapping("/businessInfo")
    public String businessInfo() {


        return "/content/project/projectManage/businessInfo";

    }
    @PostMapping("/businessInfo")
    public String businessInfo2(@ModelAttribute BusinessMakeDTO businessMakeDTO) {

        


        return "/content/project/projectManage/businessInfo";

    }
}
