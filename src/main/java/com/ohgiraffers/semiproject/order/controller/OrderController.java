package com.ohgiraffers.semiproject.order.controller;

import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;

import com.ohgiraffers.semiproject.order.model.dto.*;
import com.ohgiraffers.semiproject.order.model.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
          @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO,
          @RequestParam int hdCounterValue,
          @RequestParam int hdTotalPrice,
          @RequestParam int hdCouponPrice,
          @RequestParam int hdDeliveryCost,
          @RequestParam int hdGunWon,
          @RequestParam CartDTO cartInfo
        ) throws PaymentPageException{
    String userId = memberAndAuthorityDTO.getMemberDTO().getUserId();

    System.out.println(userId + "============================================================ userId");



    String title = cartInfo.getProjectCode().getTitle();

    System.out.println("hdCounterValue = " + hdCounterValue);
    System.out.println("title =============================== " + title);


    log.info("[OrderController] paymentPage ================================== start");
    log.info("[OrderController] paymentPage ================================== " + memberAndAuthorityDTO);

    List<UserDTO> paymentHistory = paymentService.paymentPage(userId,title);
    model.addAttribute("buypage", paymentHistory);
    model.addAttribute("counterProduct", hdCounterValue);
    model.addAttribute("hdTotalPrice", hdTotalPrice);
    model.addAttribute("hdCouponPrice", hdCouponPrice);
    model.addAttribute("hdDeliveryCost", hdDeliveryCost);
    model.addAttribute("hdGunWon", hdGunWon);
    model.addAttribute("title", title);

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
