package com.ohgiraffers.semiproject.sellerManage.Controller.sellerUserManage;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/sellerManage/*")
public class SellerManageController {


    @GetMapping("UserManage")
    public String sellerUserLocation() {

        return "content/sellerManage/sellerUserManage/sellerUserManage";
    }

}