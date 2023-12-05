package com.ohgiraffers.semiproject.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {


    @GetMapping("login")
    public String login() {


        return "/content/member/login/login";

    }

    @GetMapping("join")
    public String join() {


        return "/content/member/login/join";

    }

    @GetMapping("findId")
    public String findId() {


        return "/content/member/login/findId";

    }


    @GetMapping("findPwd")
    public String findPwd() {


        return "/content/member/login/findPwd";

    }


    @GetMapping("changeInfo")
    public String changeInfo() {


        return "/content/member/login/changeInfo";

    }


    @GetMapping("sellerWithdrawal")
    public String sellerWithdrawal() {


        return "/content/member/memberWithdrawal/seller/sellerWithdrawal";

    }

    @GetMapping("userWithdrawal")
    public String userWithdrawal() {


        return "/content/member/memberWithdrawal/user/userWithdrawal";

    }

    @GetMapping("myInfo")
    public String myInfo() {


        return "/content/member/login/myInfo";


    }
}
