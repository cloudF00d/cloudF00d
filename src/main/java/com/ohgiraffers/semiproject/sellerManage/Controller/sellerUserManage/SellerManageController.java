package com.ohgiraffers.semiproject.sellerManage.Controller.sellerUserManage;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sellerManage/*")
public class SellerManageController {

    @GetMapping("sample")
    public String sellerLocation() {
        return "content/board/sellerQnA/sellerMainPage/sellerQnAmainpage";
    }

    @GetMapping("sellerUserManage")
    public String sellerUserLocation() {
        return "content/sellerManage/sellerUserManage/sellerUserManage";
    }


}