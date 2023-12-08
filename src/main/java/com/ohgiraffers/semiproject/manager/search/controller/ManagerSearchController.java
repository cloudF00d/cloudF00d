package com.ohgiraffers.semiproject.manager.search.controller;

import com.ohgiraffers.semiproject.manager.search.model.dto.*;
import com.ohgiraffers.semiproject.manager.search.model.service.SearchUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/manager/search")
public class ManagerSearchController {
    private final SearchUserService searchUserService;

    public ManagerSearchController(SearchUserService searchUserService) {
        this.searchUserService = searchUserService;
    }

    @GetMapping("/complaintDetail")
    public String complaintDetail(){
        return "/content/manager/search/complaintDetail";
    }
    @GetMapping("/complaintMain")
    public String complaintMain(){ return "/content/manager/search/complaintMain";}
    @GetMapping("/sellerDetail")
    public String sellerDetail(){
        return "/content/manager/search/sellerDetail";
    }
    @GetMapping("/sellerMain")
    public String sellerMain(){
        return "/content/manager/search/sellerMain";
    }
    @GetMapping("/userDetail")
    public String userDetail(@RequestParam("userCode") int no, Model mv){

        log.info("controller userDetail start===========================");

        List<CartDTO> cartDTOS = searchUserService.userBuy(no);
        List<UserReportHistoryDTO> userReportHistoryDTOS = searchUserService.userReport(no);
        List<ProjectDTO> projectDTOS = searchUserService.userFundingProject(no);
        UserDTO userDTOS = searchUserService.findOneUser(no);

        mv.addAttribute("userInfo", userDTOS);
        mv.addAttribute("userBuy", cartDTOS);
        mv.addAttribute("userReport", userReportHistoryDTOS);
        mv.addAttribute("userFunding", projectDTOS);


        log.info("controller userDetail end ===============================");

        return "/content/manager/search/userDetail";
    }
    @GetMapping("/userMain")
    public ModelAndView userMain(ModelAndView mv){
        List<UserDTO> userDTOS = searchUserService.findAllUser();

        mv.addObject("searchUser", userDTOS);
        mv.setViewName("/content/manager/search/userMain");

        return mv;


//        "/content/manager/search/userMain";
    }
}

