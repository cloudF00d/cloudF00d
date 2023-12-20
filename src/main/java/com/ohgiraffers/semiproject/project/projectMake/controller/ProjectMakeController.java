package com.ohgiraffers.semiproject.project.projectMake.controller;

import com.ohgiraffers.semiproject.common.exception.thumbnail.ThumbnailRegistException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.project.projectMake.model.dto.BusinessMakeDTO;
import com.ohgiraffers.semiproject.project.projectMake.model.dto.ProjectFileDTO;
import com.ohgiraffers.semiproject.project.projectMake.model.dto.ProjectMakeDTO;
import com.ohgiraffers.semiproject.project.projectMake.model.dto.ProjectMakeFileDTO;
import com.ohgiraffers.semiproject.project.projectMake.model.service.ProjectMakeService;
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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.sql.Date;
import java.util.*;

@Controller
@Slf4j
@RequestMapping("/projectMake")
public class ProjectMakeController {
    @Value("img")
    private String IMAGE_DIR;

    @Value("C:/uploadfile/")
    private String ROOT_LOCATION;

    private final ProjectMakeService projectMakeService;

    public ProjectMakeController(ProjectMakeService projectMakeService) {
        this.projectMakeService = projectMakeService;
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

        System.out.println("memberAndAuthorityDTO = " + memberAndAuthorityDTO);

        mv.addAttribute("project", projectMakeDTO);

        return "/content/project/projectManage/basicInfo";

    }

    @PostMapping("basicInfo")
    public String basicInfo2(@ModelAttribute ProjectMakeDTO projectMakeDTO,
                             @RequestParam("mainPicture") MultipartFile mainPicture,
                             RedirectAttributes rttr) throws ThumbnailRegistException {

        System.out.println("mainPicture = " + mainPicture);

        String rootLocation = ROOT_LOCATION + IMAGE_DIR;

        String fileUploadDirectory = rootLocation + "/upload/original";
        String thumbnailDirectory = rootLocation + "/Representative_image";

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
                    fileMap.put("savePath", fileUploadDirectory);

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

        System.out.println("memberAndAuthorityDTO = " + memberAndAuthorityDTO);

        mv.addAttribute("project", projectMakeDTO);
        mv.addAttribute("business", businessMakeDTO);

        return "/content/project/projectManage/projectInfo";

    }

    @PostMapping("projectInfo")
    public String projectInfo2(@ModelAttribute ProjectMakeDTO projectMakeDTO,
                               @ModelAttribute BusinessMakeDTO businessMakeDTO) {

        System.out.println("projectMakeDTO = " + projectMakeDTO); // type 이랑 targetAmount 받기 위함

        System.out.println("businessMakeDTO = " + businessMakeDTO); // busiEmail 받기 위함

        businessMakeDTO.setSellCode(projectMakeDTO.getSellerCode()); // 기준이 될 유저코드 전달

        projectMakeService.typeAndTargetUpdate(projectMakeDTO); // project update

        BusinessMakeDTO businessMakeDTO1 = projectMakeService.alreadyExist(businessMakeDTO); // 기존에 만들어둔 business가 있는지 확인

        if (businessMakeDTO1 == null) {
            System.out.println("저장된 프로젝트가 없군요! 새로 작성하겠습니다");
            projectMakeService.businessInsert(businessMakeDTO); // business insert

        } else if (businessMakeDTO1 != null) {
            System.out.println("이미 작성하던 프로젝트가 있군요! 해당 페이지로 이동합니다.");
            projectMakeService.busiEmailUpdate(businessMakeDTO); // business update
        }


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
    public String projectStory() {
        return "/content/project/projectManage/projectStory";

    }

    @PostMapping("projectStory")
    public String projectStory2(@ModelAttribute ProjectMakeDTO projectMakeDTO,
                                @RequestParam("picture") MultipartFile mainPicture,
                                RedirectAttributes rttr) throws ThumbnailRegistException {

        System.out.println("mainPicture = " + mainPicture);

        String rootLocation = ROOT_LOCATION + IMAGE_DIR;

        String fileUploadDirectory = rootLocation + "/upload/original";
        String thumbnailDirectory = rootLocation + "/Representative_image";

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
                    fileMap.put("savePath", fileUploadDirectory);

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

        int code = memberAndAuthorityDTO.getMemberDTO().getUserCode();
        projectMakeService.policyUpdate(code); // project update


        return "/content/project/projectManage/projectAgree";

    }


    @GetMapping("/summernote")
    public String summernote() {

        return "/content/project/projectManage/summernote";
    }

    @PostMapping("/summernote")
    public void summernote2(@RequestParam String summernote,
                                           @RequestParam("mainPicture") MultipartFile multipartFile) {

//        System.out.println("summernote = " + summernote);
//
//            log.info("");
//            log.info("");
//            log.info("[BoardWriteController] uploadSummernoteImageFile =====... start");
//            String rootLocation = ROOT_LOCATION + IMAGE_DIR;
//            // C:/hedgehog/img
//
//            String thumnailDirectory = rootLocation + "/Representative";
//
//            File directory = new File(thumnailDirectory);
//
//            log.info("****************************thumnailDirectory" + thumnailDirectory);
//
//            if (!directory.exists()) {
//                log.info("*************************** 폴더 생성" + directory.mkdirs());
//            }
//
//        /* 업르도 파일 하나하나에 대한 정보를 담을 리스트 */
//        List<Map<String, String>> fileList = new ArrayList<>();
//
//
//        List<MultipartFile> paramFileList = new ArrayList<>();
//        paramFileList.add(thumbnailImg1);
//        log.info("[ThumbnailController] thumbnailImg1 : " + thumbnailImg1);
//        paramFileList.add(thumbnailImg2);
//        log.info("[ThumbnailController] thumbnailImg2 : " + thumbnailImg2);
//        paramFileList.add(thumbnailImg3);
//        log.info("[ThumbnailController] thumbnailImg3 : " + thumbnailImg3);
//        paramFileList.add(thumbnailImg4);
//        log.info("[ThumbnailController] thumbnailImg4 : " + thumbnailImg4);
//
//        try {
//                InputStream fileStream = multipartFile.getInputStream();
//                FileUtils.copyInputStreamToFile(fileStream, originalFile);
//
//                int maxWidth = 640;
//                int maxHeight = 640;
//
//                Thumbnails.Builder<File> thumbnailBuilder = Thumbnails.of(originalFile);
//
//                int originalWidth = (int) ImageIO.read(originalFile).getWidth();
//                int originalHeight = (int) ImageIO.read(originalFile).getHeight();
//                log.info("원본 사진의 너비... : " + originalWidth);
//                log.info("원본 사진의 높이... : " + originalHeight);
//
//                if (originalWidth <= maxWidth && originalHeight <= maxHeight) {
//                    thumbnailBuilder.size(originalWidth, originalHeight);
//                } else {
//                    thumbnailBuilder.size(maxWidth, maxHeight).keepAspectRatio(true);
//                }
//
//                thumbnailBuilder
//                        .toFile(convertFile);
//
//                returnMap.put("convertPath", convertPath);
//                returnMap.put("savePath", fileUploadDirectory);
//                returnMap.put("sourceName", originalFileName);
//                returnMap.put("convertName", convertName);
//                returnMap.put("url", "/thumbPath" + convertPath);
//                returnMap.put("responseCode", "success");
//            } catch (IOException e) {
//                FileUtils.deleteQuietly(originalFile);
//                FileUtils.deleteQuietly(convertFile);
//                e.printStackTrace();
//            }
//
//            log.info("[BoardWriteController] uploadSummernoteImageFile ======== return \n {}", returnMap);
//            log.info("[BoardWriteController] uploadSummernoteImageFile ======== end");
//
//            return returnMap;
        }
}
