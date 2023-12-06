package com.ohgiraffers.semiproject.project.projectManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("projectManage")
public class projectManageController {

    @GetMapping("basicInfo")
    public String basicInfo(){
        return "/content/project/projectManage/basicInfo";

    }
    @GetMapping("projectInfo")
    public String projectInfo(){
        return "/content/project/projectManage/projectInfo";

    }

    @GetMapping("payChoice")
    public String payChoice(){
        return "/content/project/projectManage/payChoice";

    }

    @GetMapping("projectStory")
    public String projectStory(){
        return "/content/project/projectManage/projectStory";

    }
    @GetMapping("sellerInfo")
    public String sellerInfo(){
        return "/content/project/projectManage/sellerInfo";

    }





}









/*
<!DOCTYPE html>
<html lang="en"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="~{layouts/layout}">
<th:block  layout:fragment="content">
*/

// <th:block th:replace="/fragments/sellersidebar.html"></th:block>
