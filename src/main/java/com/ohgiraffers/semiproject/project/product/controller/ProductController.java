package com.ohgiraffers.semiproject.project.product.controller;

import com.ohgiraffers.semiproject.project.product.model.dto.TotalStoryDTO;
import com.ohgiraffers.semiproject.project.product.model.service.ProductServiceimpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.List;


@Controller
@RequestMapping("product")
@Slf4j
public class ProductController {

    @Value("${image.image-dir}")
    private String IMAGE_DIR;

    @Value("${spring.servlet.multipart.location}")
    private String ROOT_LOCATION;

    @Getter
    private final ProductServiceimpl productServiceimpl;

    public ProductController(ProductServiceimpl productServiceimpl) {
        this.productServiceimpl = productServiceimpl;
    }



    @GetMapping("productStory")
    public ModelAndView productStory(ModelAndView mv) {

        log.info("");
        log.info("");
        log.info("[ThumbnailController] ========================================================= start");


        List<TotalStoryDTO> thumbnailList = ProductServiceimpl.totalStoryList();
        log.info("[ThumbnailController] thumbnailList : " + thumbnailList);

        mv.addObject("thumbnailList", thumbnailList);

        mv.setViewName("content/project/product/productStory");

        log.info("[ThumbnailController] ========================================================= end");

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
