package com.ohgiraffers.semiproject.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/complaintMain")
    public String complaintBoard() {
        return "content/board/complaintboard/complaintMain";
    }

    @GetMapping("/complaintAnswered")
    public String complaintBoardAnswered() {
        return "content/board/complaintboard/complaintAnswered";
    }

    @GetMapping("/complaintBefore")
    public String complaintBoardBefore() {
        return "content/board/complaintboard/complaintBefore";
    }

    @GetMapping("/inquiryAnswered")
    public String inquiryAnswered() {
        return "content/board/inquiryboard/inquiryAnswered";
    }

    @GetMapping("/inquiryAnswering")
    public String inquiryAnswering() {
        return "content/board/inquiryboard/inquiryAnswering";
    }

    @GetMapping("/inquiryMain")
    public String inquiryMain() {
        return "content/board/inquiryboard/inquiryMain";
    }


    @GetMapping("/inquiryWrite")
    public String inquiryWrite() {
        return "content/board/memberInquiryWrite/MemberinquriryWrite";
    }


    @GetMapping("/noticeMain")
    public String noticeMain() {
        return "content/board/noticeboard/noticeMain";
    }

    @GetMapping("/noticeWrited")
    public String noticeWrited() {
        return "content/board/noticeboard/noticeWrited";
    }

    @GetMapping("/noticeWriting")
    public String noticeWriting() {
        return "content/board/noticeboard/noticeWriting";
    }

    @GetMapping("/userNotice")
    public String userNoticeMain() {
        return "content/board/noticeboard/userNoticeMain";
    }

    @GetMapping("/sellerNotice")
    public String sellerNoticeMain() {
        return "content/board/noticeboard/sellerNoticeMain";
    }


}

