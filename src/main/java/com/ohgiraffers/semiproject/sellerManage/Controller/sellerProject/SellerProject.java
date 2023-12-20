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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
            @RequestParam(required = false) String nation3, //검색할 컬럼 선택
            @RequestParam(required = false) String searchValue, // 검색어 입력하는곳 받기

            Model model,
            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO) {

        log.info("[SellerManageProjectController] sellerProject ================================== start");
        log.info("[SellerManageProjectController] sellerProject  ================================== {} ", memberAndAuthorityDTO);
        System.out.println("nation 3 ===============" + nation3);
        System.out.println("검색어searchValue ================" + searchValue);

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("nation3", nation3); // 검색설정
        searchMap.put("searchValue", searchValue); // 검색어

        sellerProjectService.selectTotalCount(searchMap);


        List<SellerManageProjectDTO> sellerProject = sellerProjectService.sellerProject();
        model.addAttribute("Project", sellerProject);



        return "content/sellerManage/sellerProject/sellerProjectSearch";
    }


    @GetMapping("ProjectDetail")
    public String sellerDetailLocation(
            Model model,
            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO){
        log.info("[SellerManageProjectDetailController] ProjectDetail ================================== start");
        log.info("[SellerManageProjectDetailController] ProjectDetail  ================================== {} ", memberAndAuthorityDTO);

        SellerManageProjectDTO sellerProjectDetail = sellerProjectService.sellerProjectDetail();
        model.addAttribute("projectDetail",sellerProjectDetail);

        return "content/sellerManage/sellerProject/sellerProjectDetail";
    }

}
