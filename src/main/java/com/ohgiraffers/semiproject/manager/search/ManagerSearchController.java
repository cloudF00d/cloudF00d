package com.ohgiraffers.semiproject.manager.search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/content/manager/search")
public class ManagerSearchController {

    @GetMapping("/userMain")
    public String defaultLocation(){
        return "/content/manager/search/userMain";
    }
}

