package com.ohgiraffers.semiproject.sellerManage.sellerUserManage;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class SellerManageController {

    @GetMapping("sample")
    public String sellerLocation(){
        return "content/board/sellerQnA/sellerMainPage/sellerQnAmainpage";
    }

    @GetMapping("sellerUserManage")
    public String sellerUserLocation(){
        return "content/seller Manage/sellerUserManage/sellerUserManage";
    }


    @GetMapping("sellerProject")
    public String sellerProjectLocation(){
        return "content/seller Manage/sellerProject/sellerProjectSearch";
    }


    @GetMapping("sellerProjectQnAing")
    public String sellerProjectQnAWritingLocation(){
        return "content/seller Manage/sellerQnAmanage/sellerQnAAnswering";
    }



    @GetMapping ("sellerProjectQnAComp")
    public String sellerProjectQnAComp(){
        return "content/seller Manage/sellerQnAmanage/sellerQnAAnswering";
    }
}
