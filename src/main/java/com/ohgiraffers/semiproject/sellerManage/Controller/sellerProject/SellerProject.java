package com.ohgiraffers.semiproject.sellerManage.Controller.sellerProject;

import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageProjectDTO;
import com.ohgiraffers.semiproject.sellerManage.model.service.SellerProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@Slf4j
@RequestMapping("/sellerManage/*")
public class SellerProject {

    private final SellerProjectService sellerProjectService;

    public SellerProject(SellerProjectService sellerProjectService) {
        this.sellerProjectService = sellerProjectService;
    }

    @GetMapping("Project")
    public String sellerProjectLocation(
            Model model,
            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO) {

        log.info("[SellerManageProjectController] sellerProject ================================== start");
        log.info("[SellerManageProjectController] sellerProject  ================================== {} ", memberAndAuthorityDTO);

        List<SellerManageProjectDTO> sellerProject = sellerProjectService.sellerProject();
        model.addAttribute("Project", sellerProject);

        return "content/sellerManage/sellerProject/sellerProjectSearch";
    }


    @GetMapping("ProjectDetail")
    public String sellerDetailLocation(){
        return "content/sellerManage/sellerProject/sellerProjectDetail";
    }

}
