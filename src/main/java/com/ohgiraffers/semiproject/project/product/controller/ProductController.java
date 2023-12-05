package com.ohgiraffers.semiproject.project.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductController {

    @GetMapping("productStory")
    public String productStory(){

        return "/content/project/product/productStory";
    }

    @GetMapping("productPage")
    public String productPage(){

        return "/content/project/product/productPage";
    }

}
