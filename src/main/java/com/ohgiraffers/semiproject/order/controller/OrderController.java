package com.ohgiraffers.semiproject.order.controller;

import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;
import com.ohgiraffers.semiproject.order.model.dto.PaymentDTO;
import com.ohgiraffers.semiproject.order.model.dto.PaymentHistoryDTO;
import com.ohgiraffers.semiproject.order.model.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("order")
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
//                                  @ModelAttribute PaymentHistoryDTO paymentHistory
                                   Model model


                                    ) throws PaymentPageException {


    log.info("[OrderController] paymentPage ================================== start");



    PaymentHistoryDTO paymentHistory = paymentService.paymentPage();
    model.addAttribute("buypage",paymentHistory);


    return "redirect:/content/order/buypage";



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
