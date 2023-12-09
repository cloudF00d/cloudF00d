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
    public String userDetail(@RequestParam long no, Model mv){
        // 궁금한 점 : js로 넘길때는 userCode를 쓰는 행이 있기에 가능했지만
        // 만약 userCode를 쓰는 행이 없는 상태이고 tr 자체에 클릭 시 페이지 이동 + 파라미터 값 넘기기를 할 순 없나?
        // jsp 에선 <a태그를 써서 하는게 되던데 html에선 tr사이에 a태그 못씀

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
    public ModelAndView userMain(
           // @RequestParam(value="currentPage", defaultValue = "1") int pageNo,

                                     ModelAndView mv){

        int limit = 3; // 한 페이지에 보여질 게시물 수
        int buttonAmount = 5; // 한번에 보여질 페이징 버튼의 개수
        List<UserDTO> userDTOS = searchUserService.findAllUser();

        mv.addObject("searchUser", userDTOS);
        mv.setViewName("/content/manager/search/userMain");

        return mv;


//        "/content/manager/search/userMain";
    }
}

