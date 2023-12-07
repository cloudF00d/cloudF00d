package com.ohgiraffers.semiproject.sellerManage.Controller.sellerProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/sellerManage/*")
public class SellerProject {


    @GetMapping("Project")
    public String sellerProjectLocation(){
        return "content/sellerManage/sellerProject/sellerProjectSearch";
    }



    @GetMapping("ProjectDetail")
    public String sellerDetailLocation(){
        return "content/sellerManage/sellerProject/sellerProjectDetail";
    }

}
