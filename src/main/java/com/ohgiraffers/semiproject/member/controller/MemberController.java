package com.ohgiraffers.semiproject.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {




    @GetMapping("login")
    public String login(){


        return "/content/member/login/login";

    }

    @GetMapping("join")
    public String join(){


        return "/content/member/login/join";

    }

    @GetMapping("changeInfo")
    public String getChangeInfoLocation(){
        return "/content/member/login/changeInfo";
    }
}
