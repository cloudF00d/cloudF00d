package com.ohgiraffers.semiproject.project.product.controller;

import com.ohgiraffers.semiproject.project.product.model.dto.ProDTO;
import com.ohgiraffers.semiproject.project.product.model.service.ProductService;
import com.ohgiraffers.semiproject.sellerManage.Controller.sellerProject.SellerProject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @GetMapping("productStory")
    public ModelAndView productStory(ModelAndView mv){
//    List<ProDTO> productStory = ProductService.selectAllproductStoryList();
//        mv.addObject("storyList", productStory);
//        mv.setViewName("content/project/product/productPage");
////        mv.addObject("pro", SellerProject);


        return mv;
    }

    @GetMapping("productPage")
    public String productPage(){

        return "/content/project/product/productPage";
    }

    @GetMapping("productQnA")
    public String productQnA(){

        return "/content/project/product/productQnA";
    }
}
