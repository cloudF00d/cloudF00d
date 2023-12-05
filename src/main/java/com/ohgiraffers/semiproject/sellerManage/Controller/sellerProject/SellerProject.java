package com.ohgiraffers.semiproject.sellerManage.Controller.sellerProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/sellerManage/*")
public class SellerProject {


    @GetMapping("sellerProject")
    public String sellerProjectLocation(){
        return "content/sellerManage/sellerProject/sellerProjectSearch";
    }


}
