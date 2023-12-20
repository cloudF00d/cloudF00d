package com.ohgiraffers.semiproject.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.semiproject.common.exception.cart.CartRegistException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.dto.SelectOptionDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartInsertDTO;
import com.ohgiraffers.semiproject.order.model.service.CartService;
import com.ohgiraffers.semiproject.project.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectOptionDTO;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.bytecode.annotation.MemberValue;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@Slf4j
@RequestMapping("/order/")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /*
    @GetMapping("cart")
    public String cart(){
        return "/content/order/cart";
    }
    */

    @GetMapping("cart")
    public String cart(
            Model model,
            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO) {


        log.info("[OrderController] cartPage ================================== start");
        log.info("[OrderController] cartPage  ================================== {} ", memberAndAuthorityDTO);


        List<CartInsertDTO> cartPage = cartService.cart();
        model.addAttribute("cart", cartPage);


        return "/content/order/cart";
    }


//    @PostMapping("cart")
//    public String addToCart(@RequestParam int projectCode,
//                            @RequestParam int optionCode,
//                            HttpSession session, Model m,
//                            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO)
//                             throws CartRegistException {
////        m.addAttribute("projectCode",projectCode);
////        m.addAttribute("optionType",optionType);
////        m.addAttribute("optionCode",optionCode);
////        System.out.println(optionCode+"========================================optionCode");
//
////        ProjectOptionDTO projectOption = selectedOption;
////
////        // CartDTO 객체 생성 및 설정
//
//        int userCode = memberAndAuthorityDTO.getMemberDTO().getUserCode();
//
//        CartDTO cart = new CartDTO();
//        cart.getMemberCode().setUserCode(userCode);
//        cart.getProjectOptionCode().setOptionCode(optionCode);
//        cart.getProjectCode().setCode(projectCode);
//        cartService.addToCart(cart);
//
//
//
//        return "redirect:/order/cart";
//    }

//    @PostMapping("cart")
//    public String addToCart(@RequestParam int projectCode,
//                            @RequestParam int optionCode,
//                            HttpSession session, Model m,
//                            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO)
//            throws CartRegistException {
//
//        int userCode = memberAndAuthorityDTO.getMemberDTO().getUserCode();
//
//        MemberDTO memberDTO = new MemberDTO();
//        memberDTO.setUserCode(userCode); // MemberDTO 객체에 userCode 설정
//
//        CartDTO cart = new CartDTO();
//        cart.setMemberCode(memberDTO); // 초기화된 MemberDTO 객체를 CartDTO에 설정
//        cart.getProjectOptionCode().setOptionCode(optionCode);
//        cart.getProjectCode().setCode(projectCode);
//        cartService.addToCart(cart);
//
//        return "redirect:/order/cart";
//
//    }


//    @PostMapping("cart")
//    @ResponseBody
//    public String addToCart(@RequestParam int projectCode,
//                            @RequestParam int optionCode,
//                            HttpSession session, Model m,
//                            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO)
//            throws CartRegistException {
//
//        int userCode = memberAndAuthorityDTO.getMemberDTO().getUserCode();
//
//        MemberDTO memberDTO = new MemberDTO();
//        memberDTO.setUserCode(userCode); // MemberDTO 객체에 userCode 설정
//
//        ProjectOptionDTO projectOptionDTO = new ProjectOptionDTO();
//        projectOptionDTO.setOptionCode(optionCode); // ProjectOptionDTO 객체에 optionCode 설정
//
//        ProjectDTO projectDTO = new ProjectDTO();
//        projectDTO.setCode(projectCode);
//
//        CartDTO cart = new CartDTO();
//        cart.setMemberCode(memberDTO); // 초기화된 MemberDTO 객체를 CartDTO에 설정
//        cart.setProjectOptionCode(projectOptionDTO); // 초기화된 ProjectOptionDTO 객체를 CartDTO에 설정
//        cart.setProjectCode(projectDTO); // - 이 부분도 필요에 따라 유사하게 수정 필요
//        System.out.println("cart = " + cart);
//        cartService.addToCart(cart);
//
//        return "redirect:/order/cart";
//    }

    @PostMapping("cart")
    public String addToCart(@RequestParam int projectCode,
                            @RequestParam int optionCode,
                            HttpSession session, Model m,
                            @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO)
            throws CartRegistException {




        int userCode = memberAndAuthorityDTO.getMemberDTO().getUserCode();

        Map<String, Object> addToCart = new HashMap<>();
        addToCart.put("userCode", userCode);
        addToCart.put("projectCode", projectCode);
        addToCart.put("optionCode", optionCode);
        System.out.println(projectCode + "===============================projectCode");
        cartService.insertCart(addToCart);

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUserCode(userCode); // MemberDTO 객체에 userCode 설정

        ProjectOptionDTO projectOptionDTO = new ProjectOptionDTO();
        projectOptionDTO.setOptionCode(optionCode); // ProjectOptionDTO 객체에 optionCode 설정

        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setCode(projectCode);

//        CartDTO cart = new CartDTO();
//        cart.setMemberCode(memberDTO); // 초기화된 MemberDTO 객체를 CartDTO에 설정
//        cart.setProjectOptionCode(projectOptionDTO); // 초기화된 ProjectOptionDTO 객체를 CartDTO에 설정
//        cart.setProjectCode(projectDTO); // - 이 부분도 필요에 따라 유사하게 수정 필요
//        System.out.println("cart = " + cart);
//        cartService.addToCart(cart);

        return "redirect:/order/cart";
    }
}
