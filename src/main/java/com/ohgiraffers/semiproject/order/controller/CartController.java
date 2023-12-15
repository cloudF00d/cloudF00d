package com.ohgiraffers.semiproject.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.service.CartService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
@RequestMapping("order")
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
        log.info("[OrderController] paymentPage ================================== {} ", memberAndAuthorityDTO);


        CartDTO cartPage = cartService.cart();
        model.addAttribute("cart", cartPage);

        return "/content/order/cart";
    }



//    @PostMapping("cart")
//    public String addToCart(@RequestParam("selectedOption") String selectedOption,
//                            HttpSession session, Model model){
//        log.info("Selected option: {}", selectedOption);
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            // JSON 문자열을 Java 객체로 변환
//            SelectedOptionDTO selectedOption = objectMapper.readValue(selectedOptionJson, SelectedOptionDTO.class);
//
//            // 변환된 객체를 사용하여 비즈니스 로직 수행
//            // 예: cartService.addToCart(selectedOption, session);
//
//        } catch (JsonProcessingException e) {
//            log.error("Error parsing selected option JSON", e);
//            // 에러 처리 로직
//        }
//
//        return "redirect:/order/cart";
//    }

}
