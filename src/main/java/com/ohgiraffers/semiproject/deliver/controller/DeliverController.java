package com.ohgiraffers.semiproject.deliver.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deliver/*")
public class DeliverController {

    @GetMapping("userdetail")
    public String userdetail(){
        return "content/deliver/uerDeliver/userDeliverDetailPage/userDeliverDetail";
    }
}
