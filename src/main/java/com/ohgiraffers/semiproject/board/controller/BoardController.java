package com.ohgiraffers.semiproject.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class BoardController {

    @GetMapping("noticeboard")
    public String defaultLocation(){
        return "content/board/noticeboard/noticeMain";
    }

    @GetMapping("")
    public String complaintBoard() {
        return "content/board/noticeboard/complaintAnswered";
    }
}

