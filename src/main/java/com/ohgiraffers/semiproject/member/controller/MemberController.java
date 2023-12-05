package com.ohgiraffers.semiproject.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {




    @GetMapping("login")
    public String login(){


        return "/content/member/login/login.html";

    }

    @GetMapping("join")
    public String join(){


        return "/content/member/login/join.html";

    }

    @GetMapping("findId")
    public String findId(){


        return "/content/member/login/findId.html";

    }


    @GetMapping("findPwd")
    public String findPwd(){


        return "/content/member/login/findPwd.html";

    }


    @GetMapping("changeInfo")
    public String changeInfo(){


        return "/content/member/login/changeInfo.html";

    }

    @GetMapping("changeseller")
    public String changeseller(){


        return "/content/member/login/changeseller.html";

    }

    @GetMapping("sellerWithdrawal")
    public String sellerWithdrawal(){


        return "/content/member/login/sellerWithdrawal.html";

    }

    @GetMapping("userWithdrawal")
    public String userWithdrawal(){


        return "/content/member/login/userWithdrawal.html";

    }


}
