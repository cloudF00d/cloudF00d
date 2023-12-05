package com.ohgiraffers.semiproject.sellerManage.sellerQnAmanage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller/*")
public class SellerQnAController {

    @GetMapping("/QnA")
    public String getQnALocation(){
        return "/content/sellerManage/sellerQnAmanage/sellerQnAAnswerComp";
    }
}
