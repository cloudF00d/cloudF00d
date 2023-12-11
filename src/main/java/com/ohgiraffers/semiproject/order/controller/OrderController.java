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
//                                  @ModelAttribute PaymentHistoryDTO paymentHistory//
                                   Model model,
                                    @RequestParam int no
//                                  @RequestParam int totalPrice, //쿠폰 적용 금액//
//                                  @RequestParam int cost, //택배비
//                                  @RequestParam String firstname, //성
//                                  @RequestParam String lastname, //이름
//                                  @RequestParam String adrs, //주소
//                                  @RequestParam String detailedAdrs //상세주소
                                    ) throws PaymentPageException {

    log.info("");
    log.info("");
    log.info("[OrderController] paymentPage ================================== start");

//    int amount = totalPrice + cost;
//   paymentHistory.getPayment().setAmount(amount);
//
//    String name = firstname + lastname;
//    paymentHistory.getCart().getMemberCode().setName(name);
//
//    String address = adrs + "$" + detailedAdrs;
//    paymentHistory.getCart().getMemberCode().setName(address);

    PaymentHistoryDTO paymentHistory = paymentService.paymentPage(no);
    model.addAttribute("buypage",paymentHistory);


    return "redirect:/content/order/buypage";


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
