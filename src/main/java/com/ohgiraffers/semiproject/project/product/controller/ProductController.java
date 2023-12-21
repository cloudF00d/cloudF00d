package com.ohgiraffers.semiproject.project.product.controller;

import com.ohgiraffers.semiproject.common.exception.project.StoryRegistException;
import com.ohgiraffers.semiproject.project.product.model.dto.ProfileImageDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectFileDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectOptionDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.TotalStoryDTO;
import com.ohgiraffers.semiproject.project.product.model.service.ProductService;
import com.ohgiraffers.semiproject.project.product.model.service.ProductServiceimpl;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("productStory")
//    public



    @GetMapping("productStory")
    public ModelAndView productStory(ModelAndView mv,
                                     @RequestParam Long no

                                                                )  {

        log.info("");
        log.info("");
        log.info("[ThumbnailController] ========================================================= start");

        TotalStoryDTO thumbnailList = productService.totalStoryList(no);
        ProfileImageDTO profileImage = productService.profileimage(no);

        List<ProjectOptionDTO> projectOption = productService.optionList(no);
        List<ProjectFileDTO> projectFile = productService.projectimage(no);






        log.info("[ThumbnailController] thumbnailList : " + thumbnailList);
        mv.addObject("thumbnailList", thumbnailList);
        mv.addObject("profileImage",profileImage);

        mv.addObject("projectOption", projectOption);
        mv.addObject("projectFile",projectFile);
        log.info("[ThumbnailController] ========================================================= end");

        mv.setViewName("content/project/product/productStory");

        log.info("[ThumbnailController] ========================================================= end");

        return mv;
    }



    @GetMapping("productPage")
    public ModelAndView productPage(ModelAndView mv,
                                         @RequestParam Long no
                                            ){
        log.info("");
        log.info("");
        log.info("[ThumbnailController] ========================================================= start");

        TotalStoryDTO thumbnailList = productService.totalStoryList(no);
        ProfileImageDTO profileImage = productService.profileimage(no);

        List<ProjectOptionDTO> projectOption = productService.optionList(no);
        List<ProjectFileDTO> projectFile = productService.projectimage(no);





        log.info("[ThumbnailController] thumbnailList : " + thumbnailList);
        mv.addObject("thumbnailList", thumbnailList);
        mv.addObject("profileImage",profileImage);

        mv.addObject("projectOption", projectOption);
        mv.addObject("projectFile",projectFile);
        log.info("[ThumbnailController] ========================================================= end");

        mv.setViewName("content/project/product/productPage");

        log.info("[ThumbnailController] ========================================================= end");

        return mv;
    }

    @GetMapping("productQnA")
    public String productQnA(){

        return "/content/project/product/productQnA";
    }
}