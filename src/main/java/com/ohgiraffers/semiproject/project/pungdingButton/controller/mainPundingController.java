package com.ohgiraffers.semiproject.project.pungdingButton.controller;

import com.ohgiraffers.semiproject.common.paging.Pagenation;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.main.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.main.model.dto.ProjectListDTO;
import com.ohgiraffers.semiproject.main.model.service.MainService;
import com.ohgiraffers.semiproject.manager.model.dto.UserDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pundingButton")
public class mainPundingController{

    private final MainService mainService;

    public mainPundingController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("mainPunding")
    public ModelAndView mainPunding(@RequestParam(required = false, defaultValue = "all") String nation1, // 정렬 컬럼 선택
                              @RequestParam(required = false, defaultValue = "all") String nation2, // 정렬 방식 선택
                              @RequestParam(required = false, defaultValue = "all") String nation3, //검색할 컬럼 선택
//                              @RequestParam(required = false, defaultValue = "all") String authority,
                              // 전체, 사용자, 판매자, 신고자 선택
                              @RequestParam(required = false) String searchValue, // 검색어 입력하는곳 받기
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

        int totalCount = mainService.selectTotalCount(searchMap);
        // 전체 게시물 수?

        /* 한 페이지에 보여 줄 게시물 수 */
        int limit = 6;        //얘도 파라미터로 전달받아도 된다.

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

        List<List<ProjectDTO>> userDTOS = mainService.findAllProject(selectCriteria);

        mv.addObject("selectCriteria", selectCriteria);
//        페이징 처리에 대한 정보가 담겨있는 DTO를 넘겨 쿼리문에서 사용하기 위함
        mv.addObject("project", userDTOS);
        mv.setViewName("/content/project/pundingButton/mainPunding");

        return mv;
    }

    @PostMapping("/saveLike")
    @ResponseBody
//    시큐리티로 유저 정보 가져오기
    public String saveLike(@AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO){
        System.out.println("MemberAndAuthorityDTO" + memberAndAuthorityDTO);
        try {
//        클릭한 요소 값 받기 -> 좋아요 했는지 안 했는지 중복체크, (있으면 - delete / 없으면 - insert)
//
//        좋아요 데이터베이스 저장 (비즈니스 로직)
//        LikeDTO 생성? - @RequestBody LikeDTO likeDTO
//        좋아요 정보 - 데이터베이스 저장 - boolean????

        return "좋아요가 성공적으로 저장되었습니다.";
    } catch (Exception e) {
        e.printStackTrace();
        return "좋아요 저장 중 오류가 발생했습니다.";
    }

    }
}


