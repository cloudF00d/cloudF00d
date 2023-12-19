package com.ohgiraffers.semiproject.project.projectMake.controller;

import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.project.projectMake.model.dto.ProjectMakeDTO;
import com.ohgiraffers.semiproject.project.projectMake.model.service.ProjectMakeService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/projectMake")
public class ProjectMakeController {

    private final ProjectMakeService projectMakeService;

    public ProjectMakeController(ProjectMakeService projectMakeService) {
        this.projectMakeService = projectMakeService;
    }

    @GetMapping("projectApply")
    public String projectApply(){

        return "/content/project/projectMake/projectApply";

    }

    @GetMapping("/projectStart")
    public String projectStart(@AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO,
                               Model mv,
                               Principal principal){

        int code = memberAndAuthorityDTO.getMemberDTO().getUserCode();

        ProjectMakeDTO projectMakeDTO = projectMakeService.selectMakingProject(code);


        List<String> categories = Arrays.asList("음료", "주류", "베이커리", "해외음식", "채소", "해산물", "과일", "냉동식품", "소스", "디저트");

        System.out.println("memberAndAuthorityDTO = " + memberAndAuthorityDTO);

        mv.addAttribute("option", categories);
        mv.addAttribute("project", projectMakeDTO);

        return "/content/project/projectMake/projectStart";

    }

    @PostMapping("/projectStart")
    public String projectStart2(@ModelAttribute ProjectMakeDTO projectMakeDTO){

        System.out.println("postMapping projectMakeDTO = " + projectMakeDTO); // 값 잘 들어왔는지 확인

        ProjectMakeDTO projectMakeDTO2 = projectMakeService.whatIsYourProjectCode(projectMakeDTO); // 이미 임시저장한 프로젝트를 가지고 있는지 확인

        if (projectMakeDTO2 == null) {
            System.out.println("저장된 프로젝트가 없군요! 새로 작성하겠습니다");
            projectMakeService.projectStart(projectMakeDTO); // category insert
            ProjectMakeDTO projectMakeDTO123 = projectMakeService.whatIsYourProjectCode(projectMakeDTO); // 다시 값을 가져옴

        } else if (projectMakeDTO2 != null){
            System.out.println("이미 작성하던 프로젝트가 있군요! 해당 페이지로 이동합니다.");
            projectMakeService.projectStartUpdate(projectMakeDTO);
        }

        return "/content/project/projectMake/projectManage";

    }



    @GetMapping("projectManage")
    public String projectManage(){

        return "/content/project/projectMake/projectManage";

    }

    @GetMapping("projectManageform")
    public String projectManageform(){

        return "/content/project/projectMake/projectManageform";

    }

    @GetMapping("basicInfo")
    public String basicInfo(Model mv){
        return "/content/project/projectManage/basicInfo";

    }
    @PostMapping("basicInfo")
    public String basicInfo2(@ModelAttribute ProjectMakeDTO projectMakeDTO,
                             RedirectAttributes re){

        projectMakeService.basicInfoUpdate(projectMakeDTO); // basic 화면에서 넣은 값 입력


        return "redirect:/projectMake/projectManage";

    }
    @GetMapping("projectInfo")
    public String projectInfo(){
        return "/content/project/projectManage/projectInfo";

    }

    @PostMapping("projectInfo")
    public String projectInfo2(@RequestParam(value = "fundingType", required = false)
                                   String fundingType){

        System.out.println("fundingType = " + fundingType);
        return "/content/project/projectManage/projectInfo";

    }

    @GetMapping("payChoice")
    public String payChoice(){
        return "/content/project/projectManage/payChoice";

    }

    @GetMapping("projectStory")
    public String projectStory(){
        return "/content/project/projectManage/projectStory";

    }
    @GetMapping("sellerInfo")
    public String sellerInfo(){
        return "/content/project/projectManage/sellerInfo";

    }

    @GetMapping("/projectAgree")
    public String projectAgree(){

        return "/content/project/projectManage/projectAgree";

    }



}
