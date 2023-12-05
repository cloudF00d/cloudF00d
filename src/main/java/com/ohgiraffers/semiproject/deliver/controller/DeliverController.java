package com.ohgiraffers.semiproject.deliver.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deliver/*")
public class DeliverController {

    @GetMapping("userdetail")
    public String userdetail(){
        return "content/deliver/userDeliver/userDeliverDetailPage/userDeliverDetail";
    }


    @GetMapping("usermain")
    public String usermain(){
        return "content/deliver/userDeliver/userMainPage/userDeliverMainPage";
    }


    @GetMapping("sellerdetail")
    public String sellerdetail(){
        return "content/deliver/sellerDeliver/sellerDeliverDetailPage/sellerDeliverDtail";
    }


    @GetMapping("sellermain")
    public String sellermain(){
        return "content/deliver/sellerDeliver/sellerMainPage/sellerDeliverMainPage";
    }

}
