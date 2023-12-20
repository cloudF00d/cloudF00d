package com.ohgiraffers.semiproject.order.controller;

import com.ohgiraffers.semiproject.common.exception.payment.MemberOrderPageException;
import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;

import com.ohgiraffers.semiproject.order.model.dto.*;
import com.ohgiraffers.semiproject.order.model.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.ListIterator;

@Controller
@RequestMapping("/order/")
@Slf4j
public class OrderController {


  private final PaymentService paymentService;

  public OrderController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }


  @GetMapping("buypage")
    public String buypage(){
      return "/content/order/buypage";
  }

  @PostMapping("buypage")
  public String paymentPage(
          Model model,
          Principal principal,
          @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO,
          @RequestParam int hdCounterValue,
          @RequestParam int hdTotalPrice,
          @RequestParam int hdCouponPrice,
          @RequestParam int hdDeliveryCost,
          @RequestParam int hdGunWon


          ) throws PaymentPageException{
    String userId = principal.getName();
    System.out.println(userId + "============================================================ userId");



    System.out.println("hdCounterValue = " + hdCounterValue);



    log.info("[OrderController] paymentPage ================================== start");
    log.info("[OrderController] paymentPage ================================== " + memberAndAuthorityDTO);



    List<UserDTO> paymentHistory = paymentService.paymentPage();
    model.addAttribute("buypage",paymentHistory);
    model.addAttribute("counterProduct", hdCounterValue);
    model.addAttribute("hdTotalPrice", hdTotalPrice);
    model.addAttribute("hdCouponPrice", hdCouponPrice);
    model.addAttribute("hdDeliveryCost", hdDeliveryCost);
    model.addAttribute("hdGunWon", hdGunWon);




   return "/content/order/buypage";
  }






  @GetMapping("buyok")
    public String buyok(){
        return "/content/order/buyok";
    }



    @GetMapping("watchlist")
    public String watchlist(){
        return "/content/order/watchlist";
    }
}
