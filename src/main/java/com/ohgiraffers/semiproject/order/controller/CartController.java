package com.ohgiraffers.semiproject.order.controller;


import com.ohgiraffers.semiproject.common.exception.cart.CartRegistException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.dto.SelectOptionDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartInsertDTO;
import com.ohgiraffers.semiproject.order.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.order.model.service.CartService;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectOptionDTO;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;


@Controller
@Slf4j
@RequestMapping("/order/")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping("/cart")
    public String cart(
            Model model,
            @ModelAttribute ProjectDTO projectTitle,
            Principal principal
            ) {
    String userId = principal.getName();

    String title = projectTitle.getTitle();
        System.out.println(userId + "============================================================ userId");

        log.info("[OrderController] cartPage ================================== start");
        log.info("[OrderController] cartPage  ================================== {} ", userId);



        List<CartInsertDTO> cartPage = cartService.cart(userId);
        model.addAttribute("cart", cartPage);
        model.addAttribute("cart", cartPage);





        return "/content/order/cart";
    }



    @PostMapping("cart")
    public String addToCart(@ModelAttribute ProjectOptionDTO selectedOption, HttpSession session, Model model) throws CartRegistException {
        // 이제 selectedOption 객체를 사용하여 필요한 작업을 수행합니다.
        // 예:
//        int projectCode = selectedOption.getProjectCode();
//        int optionCode = selectedOption.getOptionCode();

        // 로직 수행...
        System.out.println("post cart 시작 합니다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        log.info("Received selectedOption========================");
        log.info("Received selectedOption: {}", selectedOption);
        log.info("Received selectedOption========================");

        cartService.addToCart(selectedOption, session);
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            // JSON 문자열을 Java 객체로 변환
//            selectedOption = objectMapper.readValue(selectedOptionJson,ProjectOptionDTO.class);
//
//            // 변환된 객체를 사용하여 비즈니스 로직 수행
//              cartService.addToCart(selectedOption, session);
//
//        } catch (JsonProcessingException e) {
//            log.error("Error parsing selected option JSON", e);
//            // 에러 처리 로직
//        }
        return "redirect:/order/cart";
    }

}
