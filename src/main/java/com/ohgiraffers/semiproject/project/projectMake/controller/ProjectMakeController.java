package com.ohgiraffers.semiproject.project.projectMake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("projectMake")
public class ProjectMakeController {

    @GetMapping("projectApply")
    public String projectApply(){

        return "/content/project/projectMake/projectApply";

    }

    @GetMapping("projectMake")
    public String projectMake(){

        return "/content/project/projectMake/projectMake";

    }

    @GetMapping("projectManage")
    public String projectManage(){

        return "/content/project/projectMake/projectManage";

    }

    @GetMapping("projectManageform")
    public String projectManageform(){

        return "/content/project/projectMake/projectManageform";

    }
}
