package com.ohgiraffers.semiproject.order.controller;

import com.ohgiraffers.semiproject.common.exception.payment.DeliverInfoException;
import com.ohgiraffers.semiproject.common.exception.payment.PaymentInfoException;
import com.ohgiraffers.semiproject.common.exception.payment.PaymentPageException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.order.model.dto.*;
import com.ohgiraffers.semiproject.order.model.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
          @RequestParam("hdDeliveryCost") int hdDeliveryCost,
          @RequestParam("hdGunWon") int hdGunWon,
          @RequestParam("hdProject") String hdProject,
          @RequestParam("hdOptionType") String hdOptionType,
          @ModelAttribute PaymentDTO payment,
          @ModelAttribute DeliverDTO deliver,
          @ModelAttribute CartInsertDTO cart,
          @ModelAttribute MemberDTO member

          ) throws PaymentPageException {
    String userId = memberAndAuthorityDTO.getMemberDTO().getUserId();
    int userCode = memberAndAuthorityDTO.getMemberDTO().getUserCode();
    int deliverCode = deliver.getCode();
    String status = payment.getStatus();
    int cartCode = cart.getCartCode();


    int code = payment.getCode();
    int amount = hdGunWon;
    int count = hdCounterValue;
    String projectTitle = hdProject;
    String optionType = hdOptionType;


    System.out.println("amount========================================== " + amount);
    String method = payment.getMethod();
    Date time = payment.getTime();

    System.out.println("optionType ================================ " + optionType);
    System.out.println("projectTitle =================================== " + projectTitle);

    System.out.println("cartCode ============================== " + cartCode);
    System.out.println("count ============================= " + count);
    System.out.println(userId + "============================================================ userId");
    System.out.println("userCode ============================================================ " + userCode);

    System.out.println("hdCounterValue ========================= " + hdCounterValue);
    System.out.println("hdOptionType ================================= " + hdOptionType);

    log.info("[OrderController] paymentPage ================================== start");
    log.info("[OrderController] paymentPage ================================== " + memberAndAuthorityDTO);

    paymentService.paymentCount(count,cartCode); //수량 업데이트



    List<UserDTO> paymentHistory = paymentService.paymentPage(userId,cartCode);
    model.addAttribute("buypage", paymentHistory);
    model.addAttribute("count", hdCounterValue);
    model.addAttribute("hdTotalPrice", hdTotalPrice);
    model.addAttribute("hdDeliveryCost", hdDeliveryCost);
    model.addAttribute("hdGunWon", hdGunWon);
    model.addAttribute("projectTitle", projectTitle);
    model.addAttribute("optionType", optionType);

    System.out.println("paymentHistory =================== " + paymentHistory);
    System.out.println("cartCode ============================== " + cartCode);






    return "/content/order/buypage";
  }






  @GetMapping("buyok")
  public String buyok(){
    return "/content/order/buyok";
  }

  @PostMapping ("buyok")
    public String buyok(
          Model model,
          @AuthenticationPrincipal MemberAndAuthorityDTO memberAndAuthorityDTO,
          @RequestParam("CounterValue") int CounterValue,
          @RequestParam("Project") String Project,
          @RequestParam("OptionType") String OptionType,
          @RequestParam("TotalPrice") int TotalPrice,
          @RequestParam("DeliveryCost") int DeliveryCost,
          @RequestParam("GunWon") int GunWon,
          @ModelAttribute PaymentDTO payment,
          @ModelAttribute DeliverDTO deliver,
          @RequestParam String searchZipCode,
          @RequestParam String adrs,
          @RequestParam String detailedAdrs,
          @ModelAttribute MemberDTO member

          ) throws DeliverInfoException, PaymentInfoException {

    int hdCounterValue = CounterValue;
    String hdProject = Project;
    String hdOptionType = OptionType;
    int hdTotalPrice = TotalPrice;
    int hdDeliveryCost = DeliveryCost;
    int hdGunWon = GunWon;

    int deliverCode = deliver.getCode();
    String status = payment.getStatus();

    int code = payment.getCode();
    int amount = hdGunWon;
    String method = payment.getMethod();
    Date time = payment.getTime();


    System.out.println("hdCounterValue ======================= " + hdCounterValue);
    System.out.println("hdProject ============================== " + hdProject);
    System.out.println("hdOptionType ============================= " + hdOptionType);

    System.out.println("memberAndAuthorityDTO ======================= " + memberAndAuthorityDTO);
          String userId = memberAndAuthorityDTO.getMemberDTO().getUserId();
          int userCode = memberAndAuthorityDTO.getMemberDTO().getUserCode();
    System.out.println("userId =================================== " + userId);
    System.out.println("userId =================================== " + userCode);


    paymentService.paymentDeliverInfo(deliver, userCode);

    paymentService.paymentInfo(deliverCode ,status, code, amount, method, time);

    List<PaymentHistoryDTO> buyHistoryInfo = paymentService.butHistory();
    model.addAttribute("buyHistoryInfo", buyHistoryInfo);
    model.addAttribute("hdCounterValue", hdCounterValue);
    model.addAttribute("hdTotalPrice", hdTotalPrice);
    model.addAttribute("hdDeliveryCost", hdDeliveryCost);
    model.addAttribute("hdGunWon", hdGunWon);
    model.addAttribute("hdProject", hdProject);
    model.addAttribute("hdOptionType", hdOptionType);


    String userName = memberAndAuthorityDTO.getMemberDTO().getUserName();
    System.out.println("userName ================ " + userName);

    String address = String.join("@", searchZipCode, adrs, detailedAdrs);
    member.setAddress(address);
    member.setPhone(member.getPhone().replace("-", ""));
    System.out.println("member ======================================= " + member);


    paymentService.deliverInfoUpdate(member);


    return "/content/order/buyok";
    }



    @GetMapping("watchlist")
    public String watchlist(){
        return "/content/order/watchlist";
    }
}
