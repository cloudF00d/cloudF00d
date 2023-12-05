package com.ohgiraffers.semiproject.project.projectMake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("project")
public class ProjectController {

    @GetMapping("projectManage")
    public String projectManage(){

        return "/content/project/projectMake/projectManage";
    }

    @GetMapping("projectMake")
    public String projectMake(){

        return "/content/project/projectMake/projectMake";
    }

    @GetMapping("projectApply")
    public String projectApply(){

        return "/content/project/projectMake/projectApply";
    }


    @GetMapping("projectStory")
    public String projectStroy(){

        return "/content/project/projectMake/projectManage/projectStory";
    }

    @GetMapping("projectInfo")
    public String projectInfo(){

        return "/content/project/projectMake/projectManage/projectInfo";
    }

    @GetMapping("sellerInfo")
    public String sellerInfo(){

        return "/content/project/projectMake/projectManage/sellerInfo";
    }

    @GetMapping("basicInfo")
    public String basicInfo(){

        return "/content/project/projectMake/projectManage/basicInfo";
    }

    @GetMapping("payChoice")
    public String payChoice(){

        return "/content/project/projectMake/projectManage/payChoice";
    }
}
