package com.ohgiraffers.semiproject.project.pungdingButton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pundingButton")
public class mainPundingController{
    @GetMapping("mainPunding")
    public String mainPunding() {



        return "content/project/pundingButton/mainPunding";
    }
}
