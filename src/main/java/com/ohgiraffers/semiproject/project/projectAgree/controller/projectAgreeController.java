package com.ohgiraffers.semiproject.project.projectAgree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/projectAgree")
public class projectAgreeController {

    @GetMapping("/projectAgree")
    public String projectAgree(){

        return "/content/project/projectAgree/projectAgree";

    }

}
