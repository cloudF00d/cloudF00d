package com.ohgiraffers.semiproject.manager.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/content/manager/project")
public class ManagerProjectController {

    @GetMapping("/complaintMain")
    public String defaultLocation(){
        return "/content/manager/project/complaintMain";
    }
}

