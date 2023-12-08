package com.ohgiraffers.semiproject.member.controller;

import com.ohgiraffers.semiproject.common.exception.member.MemberJoinException;
import com.ohgiraffers.semiproject.common.exception.member.MemberModifyException;
import com.ohgiraffers.semiproject.common.exception.member.MemberRemoveException;
import com.ohgiraffers.semiproject.common.util.SessionUtil;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.member.model.service.MemberServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("member")
@Slf4j
public class MemberController {

    private final PasswordEncoder passwordEncoder;
    private final MemberServiceImpl memberService;

    public MemberController(PasswordEncoder passwordEncoder, MemberServiceImpl memberService) {
        this.passwordEncoder = passwordEncoder;
        this.memberService = memberService;
    }
    @GetMapping("login")
    public String login() {


        return "/content/member/login/login";

    }

    @GetMapping("join")
    public String join() {


        return "/content/member/login/join";

    }
    @PostMapping("join")
    public String joinMember(@ModelAttribute MemberDTO member,
                               @RequestParam String zipCode,
                               @RequestParam String address1,
                               @RequestParam String address2,
                               RedirectAttributes rttr) throws MemberJoinException {





        String address = zipCode + "$" + address1 + "$" + address2;
        member.setPhone(member.getPhone().replace("-",""));
        member.setAddress(address);
        member.setUserPwd(passwordEncoder.encode(member.getUserPwd()));

        log.info("[MemberController] joinMember request Member : " + member);

        memberService.joinMember(member);

        rttr.addFlashAttribute("message", "회원 가입에 성공하였습니다.");

        log.info("[MemberController] joinMember ========================================================== end");

        return "redirect:/";
    }

    @PostMapping("idDupCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO member) {

        log.info("");
        log.info("");
        log.info("[MemberController] checkDuplication ========================================================== start");

        String result = "사용 가능한 아이디 입니다.";
        log.info("[MemberController] Request Check ID : " + member.getUserId());

        if("".equals(member.getUserId())) {
            log.info("[MemberController] No Input User ID");
            result = "아이디를 입력해 주세요";
        } else if(memberService.selectMemberById(member.getUserId())) {
            log.info("[MemberController] Already Exist");
            result = "중복된 아이디가 존재합니다.";
        }

        log.info("[MemberController] checkDuplication ========================================================== end");

        return ResponseEntity.ok(result);
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

    @PostMapping("changeInfo")
    public String modifyMember(@ModelAttribute MemberAndAuthorityDTO member,
                               @RequestParam String zipCode,
                               @RequestParam String address1,
                               @RequestParam String address2,
                               HttpServletRequest request,
                               HttpServletResponse response,
                               RedirectAttributes rttr) throws MemberModifyException {

        log.info("");
        log.info("");
        log.info("[MemberController] modifyMember ========================================================== start");

        String address = zipCode + "$" + address1 + "$" + address2;
        member.getMemberDTO().setPhone(member.getMemberDTO().getPhone().replace("-",""));
        member.getMemberDTO().setAddress(address);
        member.getMemberDTO().setUserPwd(passwordEncoder.encode(member.getMemberDTO().getUserPwd()));

        log.info("[MemberController] modifyMember request Member : " + member);

        memberService.modifyMember(member);

        // 회원정보 수정후 로그아웃 프로세스 진행
        SessionUtil.invalidateSession(request, response);

        rttr.addFlashAttribute("message", "회원 정보 수정에 성공하셨습니다. 다시 로그인해주세요.");

        log.info("[MemberController] modifyMember ========================================================== end");

        return "redirect:/";
    }


    @GetMapping("delete")
    public String deleteMember(@ModelAttribute MemberAndAuthorityDTO member,
                               RedirectAttributes rttr,
                               HttpServletRequest request,
                               HttpServletResponse response) throws MemberRemoveException {

        log.info("");
        log.info("");
        log.info("[MemberController] deleteMember ========================================================== start");

        String userId = request.getParameter("id");
        member.getMemberDTO().setUserId(userId);

        log.info("[MemberController] member : " + member);
        memberService.removeMember(member);

        // 회원 탈퇴후 로그아웃 프로세스 진행
        SessionUtil.invalidateSession(request, response);

        rttr.addFlashAttribute("message", "회원 탈퇴에 성공하셨습니다. 로그아웃됩니다.");

        log.info("[MemberController] deleteMember ========================================================== end");

        return "redirect:/";
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
