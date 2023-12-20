package com.ohgiraffers.semiproject.order.controller;

import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartInsertDTO;
import com.ohgiraffers.semiproject.order.model.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


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


        List<CartDTO> cartPage = cartService.cart();
        model.addAttribute("cart", cartPage);

        return "/content/order/cart";
    }


}
