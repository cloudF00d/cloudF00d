package com.ohgiraffers.semiproject.board.QnAcontroller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class QnAController {


    @GetMapping("sellermain")
    public String sellerMain(){

        return "content/board/sellerQnA/sellerMainPage/sellerQnAmainpage";
    }


    @GetMapping("sellerclose")
    public String sellerClose(){

        return "content/board/sellerQnA/sellerQnAanswer/sellerQnAAnswerClose";
    }


    @GetMapping("sellerRE")
    public String sellerRE(){

        return "content/board/sellerQnA/sellerQnAanswer/sellerQnAnswerRE";
    }


    @GetMapping("sellerwrite")
    public String sellerWrite(){

        return "content/board/sellerQnA/sellerWritePage/sellerQnAwrite";
    }


    @GetMapping("userwrite")
    public String userWrite(){

        return "content/board/userQnA/userWritePage/userQnAwrite";
    }


    @GetMapping("userclose")
    public String userClose(){

        return "content/board/userQnA/userQnAanswer/userQnAAnswerComp";
    }


    @GetMapping("userRE")
    public String userRE(){

        return "content/board/userQnA/userQnAanswer/userQnQAnswerRE";
    }




    @GetMapping("usermain")
    public String userMain(){

        return "content/board/userQnA/userMainPage/userQnAmainpage";
    }


}
