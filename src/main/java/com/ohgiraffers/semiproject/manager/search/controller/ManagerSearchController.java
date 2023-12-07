package com.ohgiraffers.semiproject.manager.search.controller;

import com.ohgiraffers.semiproject.manager.search.model.dto.UserDTO;
import com.ohgiraffers.semiproject.manager.search.model.dto.UserDetailDTO;
import com.ohgiraffers.semiproject.manager.search.model.service.SearchUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
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
    public ModelAndView userDetail(ModelAndView mv){

        List<UserDetailDTO> userDetailDTOS = searchUserService.userDetail();

        mv.addObject("userDetail", userDetailDTOS);
        mv.setViewName("/content/manager/search/userDetail");


        return mv;
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

