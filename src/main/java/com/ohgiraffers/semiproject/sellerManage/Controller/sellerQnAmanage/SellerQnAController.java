package com.ohgiraffers.semiproject.sellerManage.Controller.sellerQnAmanage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sellerManage/*")
public class SellerQnAController {

    @GetMapping("/QnACom")
    public String getQnALocation(){
        return "/content/sellerManage/sellerQnAmanage/sellerQnAAnswerComp";
    }




    @GetMapping("/QnAing")
    public String sellerProjectQnAWritingLocation(){
        return "content/sellerManage/sellerQnAmanage/sellerQnAAnswering";
    }

    @GetMapping("/QnAmanage")
    public String sellerQnAmange(){
        return "content/sellerManage/sellerQnAmanage/sellerQnAmanage";
    }


}

