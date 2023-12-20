package com.ohgiraffers.semiproject.sellerManage.Controller.sellerUserManage;


import com.ohgiraffers.semiproject.sellerManage.model.service.sellerMangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/sellerManage/*")
public class SellerManageController {


//    final private sellerMangeService sellerMangeService;
//
//    public SellerManageController(com.ohgiraffers.semiproject.sellerManage.model.service.sellerMangeService sellerMangeService) {
//        this.sellerMangeService = sellerMangeService;
//    }

    @GetMapping("UserManage")
    public String sellerUserLocation(
//            Model model
                        ) {


//        log.info("[SellerManageController] userManage ================================== start");





        return "content/sellerManage/sellerUserManage/sellerUserManage";
    }


}