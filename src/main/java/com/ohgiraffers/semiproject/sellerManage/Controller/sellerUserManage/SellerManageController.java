package com.ohgiraffers.semiproject.sellerManage.Controller.sellerUserManage;


import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerUserMangeDTO;
import com.ohgiraffers.semiproject.sellerManage.model.service.SellerUserManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/sellerManage/*")
public class SellerManageController {

    private final SellerUserManageService sellerUserService;

    public SellerManageController(SellerUserManageService sellerUserService) {
        this.sellerUserService = sellerUserService;
    }

    @GetMapping("UserManage")
    public String sellerUserLocation(
            Model model,
            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO) {

        log.info("[SellerManageUserManageController] UserManage ================================== start");
        log.info("[SellerManageUserManageController] UserManage  ================================== {} ", memberAndAuthorityDTO);


        List<SellerUserMangeDTO>sellerUser =  sellerUserService.sellerUser();
        model.addAttribute("sellerUser",sellerUser);


        return "content/sellerManage/sellerUserManage/sellerUserManage";
    }

}