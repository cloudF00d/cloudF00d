package com.ohgiraffers.semiproject.order.controller;

import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;

import com.ohgiraffers.semiproject.order.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.order.model.dto.PaymentHistoryDTO;
import com.ohgiraffers.semiproject.order.model.dto.UserDTO;
import com.ohgiraffers.semiproject.order.model.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order/")
@Slf4j
public class OrderController {


  private final PaymentService paymentService;

  public OrderController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }


//  @GetMapping("buypage")
//    public String buypage(){
//      return "/content/order/buypage";
//  }

  @GetMapping("buypage")
  public String paymentPage(
          Model model,
          @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO
//          @RequestParam String firstname,
//          @RequestParam String lastname,
//          @RequestParam String adrs,
//          @RequestParam String detailedAdrs

          ) throws PaymentPageException, MemberOrderPageException {


    log.info("[OrderController] paymentPage ================================== start");
    log.info("[OrderController] paymentPage ================================== {} ", memberAndAuthorityDTO);

//    log.info("[OrderController] paymentPage ================================== {} ", memberAndAuthorityDTO.getAuthorityDTO().getAuthorityName());
    List<UserDTO> paymentHistory = paymentService.paymentPage();
    model.addAttribute("buypage",paymentHistory);


//    MemberDTO member = paymentService.member();
//    model.addAttribute("buyepage",member);
//    String name = firstname + "$" + lastname;
//    member.setName(name);
//    String address = adrs + "$" + detailedAdrs;
//    member.setAddress(address);


//    return "/content/order/buypage";
  }






  @GetMapping("buyok")
    public String buyok(){
        return "/content/order/buyok";
    }

    @GetMapping("cart")
    public String cart(){
        return "/content/order/cart";
    }

    @GetMapping("watchlist")
    public String watchlist(){
        return "/content/order/watchlist";
    }
}
