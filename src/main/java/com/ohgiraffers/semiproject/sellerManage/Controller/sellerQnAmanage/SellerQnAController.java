package com.ohgiraffers.semiproject.sellerManage.Controller.sellerQnAmanage;

import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.sellerManage.model.dto.SellerManageQnADTO;
import com.ohgiraffers.semiproject.sellerManage.model.service.SellerQnAmangeService;
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
public class SellerQnAController {


    private final SellerQnAmangeService sellerQnAmangeService;

    public SellerQnAController(SellerQnAmangeService sellerQnAmangeService) {
        this.sellerQnAmangeService = sellerQnAmangeService;
    }

    @GetMapping("/QnACom")
    public String getQnALocation(){
        return "/content/sellerManage/sellerQnAmanage/sellerQnAAnswerComp";
    }




    @GetMapping("/QnAing")
    public String sellerProjectQnAWritingLocation(){
        return "content/sellerManage/sellerQnAmanage/sellerQnAAnswering";
    }



    @GetMapping("/QnAmanage")
    public String sellerQnAmange(
            Model model,
            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO) {

        log.info("[SellerQnAmanageController] QnAmanage ================================== start");
        log.info("[SellerQnAmanageController] QnAmanage  ================================== {} ", memberAndAuthorityDTO);

        List<SellerManageQnADTO> sellerManageQnA = sellerQnAmangeService.sellerQnA();
        model.addAttribute("manageQnA",sellerManageQnA);


        return "content/sellerManage/sellerQnAmanage/sellerQnAmanage";
    }


}

