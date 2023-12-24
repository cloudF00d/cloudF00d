package com.ohgiraffers.semiproject.order.controller;

import com.ohgiraffers.semiproject.common.exception.payment.DeliverInfoException;
import com.ohgiraffers.semiproject.common.exception.payment.PaymentInfoException;
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

  @PostMapping("/buypage")
  public String paymentPage(
          Model model,
          @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO,
          @RequestParam("hdCounterValue") int hdCounterValue,
          @RequestParam("hdTotalPrice") int hdTotalPrice,
          @RequestParam("hdCouponPrice") int hdCouponPrice,
          @RequestParam("hdDeliveryCost") int hdDeliveryCost,
          @RequestParam("hdGunWon") int hdGunWon,
          @RequestParam("hdProject") String hdProject,
          @RequestParam("hdOptionType") String hdOptionType,
          @ModelAttribute PaymentDTO payment,
          @ModelAttribute DeliverDTO deliver

  ) throws PaymentPageException, PaymentInfoException, DeliverInfoException {
    String userId = memberAndAuthorityDTO.getMemberDTO().getUserId();
    int userCode = memberAndAuthorityDTO.getMemberDTO().getUserCode();
    int deliverCode = deliver.getCode();
    String status = payment.getStatus();
    int code = payment.getCode();
    int amount = hdGunWon;

    System.out.println("amount========================================== " + amount);
    String method = payment.getMethod();
    Date time = payment.getTime();



    System.out.println(userId + "============================================================ userId");
    System.out.println("userCode ============================================================ " + userCode);

    System.out.println("hdCounterValue ========================= " + hdCounterValue);
    System.out.println("hdOptionType ================================= " + hdOptionType);

    log.info("[OrderController] paymentPage ================================== start");
    log.info("[OrderController] paymentPage ================================== " + memberAndAuthorityDTO);

    List<UserDTO> paymentHistory = paymentService.paymentPage(userId);
    model.addAttribute("buypage", paymentHistory);
    model.addAttribute("hdCounterValue", hdCounterValue);
    model.addAttribute("hdTotalPrice", hdTotalPrice);
    model.addAttribute("hdCouponPrice", hdCouponPrice);
    model.addAttribute("hdDeliveryCost", hdDeliveryCost);
    model.addAttribute("hdGunWon", hdGunWon);
    model.addAttribute("hdProject", hdProject);
    model.addAttribute("hdOptionType", hdOptionType);

    paymentService.paymentDeliverInfo(deliver, userCode);


    paymentService.paymentInfo(deliverCode ,status, code, amount, method, time);




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
