package com.ohgiraffers.semiproject.manager.controller;

import com.ohgiraffers.semiproject.common.paging.Pagenation;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dto.*;
import com.ohgiraffers.semiproject.manager.model.service.ManageRevenueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/manager/revenue")
public class ManagerRevenueController {

    private final ManageRevenueService manageRevenueService;

    public ManagerRevenueController(ManageRevenueService manageRevenueService) {
        this.manageRevenueService = manageRevenueService;
    }

    @GetMapping("/detail")
    public String revenueDetail(@RequestParam(name = "no") Long no, Model mv) {

        ProjectDTO userDTOS = manageRevenueService.findOneProject(no);
        mv.addAttribute("project", userDTOS);

        return "/content/manager/revenue/detail";
    }
    @GetMapping("/main")
    public ModelAndView revenueMain(
            @RequestParam(required = false, defaultValue = "code", name = "nation1") String nation1, // 정렬 컬럼 선택
            @RequestParam(required = false, defaultValue = "asc", name = "nation2") String nation2, // 정렬 방식 선택
            @RequestParam(required = false, name = "nation3") String nation3, //검색할 컬럼 선택
            @RequestParam(required = false, name = "searchValue") String searchValue, // 검색어 입력하는곳 받기
            @RequestParam(value = "currentPage", defaultValue = "1") int pageNo, // 보여질 페이지 넘버, 기본이 1
            ModelAndView mv) {

        System.out.println("nation 1 ===============" + nation1);
        System.out.println("nation 2 ===============" + nation2);
        System.out.println("nation 3 ===============" + nation3);
        System.out.println("검색어searchValue ================" + searchValue);


        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("nation1", nation1);
        searchMap.put("nation2", nation2);
        searchMap.put("nation3", nation3);
        searchMap.put("searchValue", searchValue);
        // 키와 밸류로 찾을 값 넣어주기

        int totalCount = manageRevenueService.selectTotalCount(searchMap);
        // 전체 게시물 수?

        /* 한 페이지에 보여 줄 게시물 수 */
        int limit = 3;        //얘도 파라미터로 전달받아도 된다.

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (nation3 != null && !"".equals(nation3)) {
            // 선택지가 null 이 아니고 공백이 아니라면
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, nation1, nation2, null, nation3, searchValue);
            // 선택지도 있는 생성자에 넣어라
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, nation1, nation2, null);
            // 아니면 선택지가 없는 생성자에 넣어라
        }

        System.out.println("selectCriteria = " + selectCriteria);


        List<ProjectDTO> userDTOS = manageRevenueService.findAllProject(selectCriteria);


        mv.addObject("selectCriteria", selectCriteria);
//        페이징 처리에 대한 정보가 담겨있는 DTO를 넘겨 쿼리문에서 사용하기 위함
        mv.addObject("project", userDTOS);
        mv.setViewName("content/manager/revenue/main");

        return mv;


//        "/content/manager/search/userMain";
    }
}
