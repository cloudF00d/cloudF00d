package com.ohgiraffers.semiproject.manager.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/manager/project")
public class ManagerProjectController {

    @GetMapping("/complaintDetail")
    public String complaintDetail(){return "content/manager/project/complaintDetail";}
    @GetMapping("/complaintMain")
    public String complaintMain(){return "content/manager/project/complaintMain";}
    @GetMapping("/declineDetail")
    public String declineDetail(){return "content/manager/project/declineDetail";}
    @GetMapping("/declineMain")
    public String declineMain(){return "content/manager/project/declineMain";}
    @GetMapping("/newDetail")
    public String newDetail(){return "content/manager/project/newDetail";}
    @GetMapping("/newMain")
    public String newMain(){



        return "content/manager/project/newMain";}
    @GetMapping("/reDetail")
    public String reDetail(){return "content/manager/project/reDetail";}
    @GetMapping("/reMain")
    public String reMain(){return "content/manager/project/reMain";}



}

