package com.ohgiraffers.semiproject.board.controller;

import com.ohgiraffers.semiproject.board.model.service.BoardService;
import com.ohgiraffers.semiproject.common.paging.Pagenation;
import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dto.InquiryDTO;
import com.ohgiraffers.semiproject.manager.model.dto.NoticeDTO;
import com.ohgiraffers.semiproject.manager.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.manager.model.dto.UserReportDTO;
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
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/complaintDetail")
    public String complaintDetail(@RequestParam Long no,
                                  @RequestParam Long status,
                                  Model mv) {
            String path = null;
            System.out.println("status ============= " + status);

            if (status == 0 || status == null) {
                System.out.println("답변기록이 없으므로 작성페이지로 넘어갑니다");
                InquiryDTO userDTOS = boardService.findOneInquiry(no);

                mv.addAttribute("detail", userDTOS);

                path = "/content/board/complaintboard/complaintBefore";


            } else if (status > 0 ) {
                System.out.println("답변기록이 있으므로 조회 페이지로 넘어갑니다.");

                InquiryDTO inquiryDTO = boardService.findOneInquiry(no);

                mv.addAttribute("detail", inquiryDTO);

                path = "/content/board/complaintboard/complaintAnswered";

            }
            else {
                System.out.println("둘 다 아니라고 뜨는뎁쇼???");
            }
            if (path == null) {
                System.out.println("status 안들어감");
            }

            return path;


        }

    @GetMapping("/complaintMain")
    public ModelAndView complaintBoard(
            @RequestParam(required = false, defaultValue = "number") String nation1, // 정렬 컬럼 선택
            @RequestParam(required = false, defaultValue = "desc") String nation2, // 정렬 방식 선택
            @RequestParam(required = false, defaultValue = "all") String authority,
            @RequestParam(required = false) String searchValue, // 검색어 입력하는곳 받기
            @RequestParam(required = false) String nation3, //검색할 컬럼 선택
            @RequestParam(value = "currentPage", defaultValue = "1") int pageNo, // 보여질 페이지 넘버, 기본이 1
            ModelAndView mv) {

        System.out.println("nation 1 ===============" + nation1);
        System.out.println("nation 2 ===============" + nation2);
        System.out.println("nation 3 ===============" + nation3);
        System.out.println("authority ============== " + authority);
        System.out.println("검색어searchValue ================" + searchValue);


        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("nation1", nation1);
        searchMap.put("nation2", nation2);
        searchMap.put("nation3", nation3);
        searchMap.put("authority", authority);
        searchMap.put("searchValue", searchValue);
        // 키와 밸류로 찾을 값 넣어주기

        int totalCount = boardService.selectTotalUserComplaintCount(searchMap);
        // 전체 게시물 수?

        /* 한 페이지에 보여 줄 게시물 수 */
        int limit = 3;        //얘도 파라미터로 전달받아도 된다.

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (nation3 != null && !"".equals(nation3)) {
            // 선택지가 null 이 아니고 공백이 아니라면
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, nation1, nation2, authority, nation3, searchValue);
            // 선택지도 있는 생성자에 넣어라
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, nation1, nation2, authority);
            // 아니면 선택지가 없는 생성자에 넣어라
        }

        System.out.println("selectCriteria = " + selectCriteria);


        List<UserReportDTO> userDTOS = boardService.findAllUserComplaint(selectCriteria);


        mv.addObject("selectCriteria", selectCriteria);
//        페이징 처리에 대한 정보가 담겨있는 DTO를 넘겨 쿼리문에서 사용하기 위함
        mv.addObject("userComplaint", userDTOS);
        mv.setViewName("content/board/complaintboard/complaintMain");

        return mv;


//        "/content/manager/search/userMain";
    }

    @GetMapping("/complaintProjectAnswered")
    public String complaintProjectMain() {
        return "content/board/complaintboard/complaintProjectMain";
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

    @GetMapping("/inquiryDetail")
    public String inquiryDetail(@RequestParam Long no,
                                @RequestParam Long status,
                                Model mv) {
        String path = null;
        System.out.println("status ============= " + status);

        if (status == 0 || status == null) {
            System.out.println("답변기록이 없으므로 작성페이지로 넘어갑니다");
            InquiryDTO userDTOS = boardService.findOneInquiry(no);

            mv.addAttribute("detail", userDTOS);

            path = "/content/board/inquiryboard/inquiryAnswering";


        } else if (status > 0 ) {
            System.out.println("답변기록이 있으므로 조회 페이지로 넘어갑니다.");

            InquiryDTO inquiryDTO = boardService.findOneInquiry(no);

            mv.addAttribute("detail", inquiryDTO);

            path = "/content/board/inquiryboard/inquiryAnswered";

        }
        else {
            System.out.println("둘 다 아니라고 뜨는뎁쇼???");
        }
        if (path == null) {
            System.out.println("status 안들어감");
        }

        return path;


    }

    @GetMapping("/inquiryMain")
    public ModelAndView inquiryMain(
            @RequestParam(required = false, defaultValue = "code") String nation1, // 정렬 컬럼 선택
            @RequestParam(required = false, defaultValue = "desc") String nation2, // 정렬 방식 선택
            @RequestParam(required = false, defaultValue = "all") String authority,
            @RequestParam(required = false) String searchValue, // 검색어 입력하는곳 받기
            @RequestParam(required = false) String nation3, //검색할 컬럼 선택
            @RequestParam(value = "currentPage", defaultValue = "1") int pageNo, // 보여질 페이지 넘버, 기본이 1
            ModelAndView mv) {

        System.out.println("nation 1 ===============" + nation1);
        System.out.println("nation 2 ===============" + nation2);
        System.out.println("nation 3 ===============" + nation3);
        System.out.println("authority ============== " + authority);
        System.out.println("검색어searchValue ================" + searchValue);


        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("nation1", nation1);
        searchMap.put("nation2", nation2);
        searchMap.put("nation3", nation3);
        searchMap.put("authority", authority);
        searchMap.put("searchValue", searchValue);
        // 키와 밸류로 찾을 값 넣어주기

        int totalCount = boardService.selectTotalInquiryCount(searchMap);
        // 전체 게시물 수?

        /* 한 페이지에 보여 줄 게시물 수 */
        int limit = 3;        //얘도 파라미터로 전달받아도 된다.

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        SelectCriteria selectCriteria = null;

        if (nation3 != null && !"".equals(nation3)) {
            // 선택지가 null 이 아니고 공백이 아니라면
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, nation1, nation2, authority, nation3, searchValue);
            // 선택지도 있는 생성자에 넣어라
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, nation1, nation2, authority);
            // 아니면 선택지가 없는 생성자에 넣어라
        }

        System.out.println("selectCriteria = " + selectCriteria);


        List<InquiryDTO> userDTOS = boardService.findAllInquiry(selectCriteria);


        mv.addObject("selectCriteria", selectCriteria);
//        페이징 처리에 대한 정보가 담겨있는 DTO를 넘겨 쿼리문에서 사용하기 위함
        mv.addObject("inquiry", userDTOS);
        mv.setViewName("content/board/inquiryboard/inquiryMain");

        return mv;


//        "/content/manager/search/userMain";
    }


    @GetMapping("/inquiryWrite")
    public String inquiryWrite() {
        return "content/board/memberInquiryWrite/MemberinquriryWrite";
    }


    @GetMapping("/noticeMain")
    public ModelAndView noticeMain(
            @RequestParam(required = false, defaultValue = "code") String nation1, // 정렬 컬럼 선택
            @RequestParam(required = false, defaultValue = "desc") String nation2, // 정렬 방식 선택
            @RequestParam(required = false) String nation3, //검색할 컬럼 선택
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

        int totalCount = boardService.selectTotalCount(searchMap);
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


        List<NoticeDTO> userDTOS = boardService.findAllNotice(selectCriteria);


        mv.addObject("selectCriteria", selectCriteria);
//        페이징 처리에 대한 정보가 담겨있는 DTO를 넘겨 쿼리문에서 사용하기 위함
        mv.addObject("notice", userDTOS);
        mv.setViewName("content/board/noticeboard/noticeMain");

        return mv;


//        "/content/manager/search/userMain";
    }

    @GetMapping("/noticeWrited")
    public String noticeWrited(@RequestParam Long no, Model mv){

        System.out.println("no ======================== " + no);


        NoticeDTO noticeDTO = boardService.findOneNotice(no);
        mv.addAttribute("notice", noticeDTO);

        return "/content/board/noticeboard/noticeWrited";
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

