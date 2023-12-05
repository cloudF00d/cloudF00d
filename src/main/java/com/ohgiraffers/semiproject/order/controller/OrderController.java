package com.ohgiraffers.semiproject.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {


  @GetMapping("buypage")
    public String buypage(){
      return "/content/order/buypage";
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
