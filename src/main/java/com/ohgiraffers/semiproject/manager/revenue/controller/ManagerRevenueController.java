package com.ohgiraffers.semiproject.manager.revenue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/revenue")
public class ManagerRevenueController {

    @GetMapping("/detail")
    public String revenueDetail() {
        return "content/manager/revenue/detail";
    }
    @GetMapping("/main")
    public String revenueMain() {
        return "content/manager/revenue/main";
    }
}
