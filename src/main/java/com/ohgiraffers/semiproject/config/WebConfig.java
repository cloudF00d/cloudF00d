package com.ohgiraffers.semiproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/");

        // 이미지 불러올 수 있도록 세팅
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///C:/uploadfile/storyimg/");
        // 프로젝트 스토리 첫번째 들어갈 사진 경로
        registry.addResourceHandler("/thumbPath/**")
                .addResourceLocations("file:///C:/uploadfile/Representative_image/");
        // 이게 판매자 사진 경로
        registry.addResourceHandler("/imagePath/**")
                .addResourceLocations("file:///C:/uploadfile/profileimg/");

    }

//    @Value("${img.macurl}")
//    private String macPath;
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/templates/", "classpath:/static/");
//
//        // 이미지 불러올 수 있도록 세팅
//        registry.addResourceHandler("/upload/**")
//                .addResourceLocations("file:///C:/uploadfile/storyimg/");
////        MAC
////        registry.addResourceHandler("/upload/**")
////                .addResourceLocations("file:///" + macPath);
//        // 프로젝트 스토리 첫번째 들어갈 사진 경로
//        registry.addResourceHandler("/thumbPath/**")
//                .addResourceLocations("file:///C:/uploadfile/Representative_image/");
////        MAC
////        registry.addResourceHandler("/thumbPath/**")
////                .addResourceLocations("file:///" + macPath);
//
////        System.out.println("macPath ===================== " + macPath);
//        // 이게 판매자 사진 경로
//        registry.addResourceHandler("/imagePath/**")
//                .addResourceLocations("file:///C:/uploadfile/profileimg/");
////        MAC.
////        registry.addResourceHandler("/imagePath/**")
////                .addResourceLocations("file:///" + macPath);
//    }
}
