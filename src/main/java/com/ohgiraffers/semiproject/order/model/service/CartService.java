package com.ohgiraffers.semiproject.order.model.service;

import com.ohgiraffers.semiproject.common.exception.cart.CartRegistException;
import com.ohgiraffers.semiproject.order.model.dao.CartMapper;
import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.dto.SelectOptionDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartInsertDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectOptionDTO;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class CartService {

    private final CartMapper Mapper;

    public CartService(CartMapper mapper) {
        Mapper = mapper;
    }

    public List<CartDTO> cart() {

        List<CartDTO> cart = Mapper.cartPage();
        System.out.println("cart = " + cart);

        return cart;
    }


    public void addToCart(ProjectOptionDTO selectedOption, HttpSession session) throws CartRegistException {
//        세션에서 cart라는 이름으로 저장된 cartDTO객체 가져온다.
        CartDTO cart = (CartDTO) session.getAttribute("cart");

//        샂용자의 세션에서 장바구니 가져오고 없으면 장바구니 생성
        if (cart == null) {
            cart = new CartDTO();
        }

        int result = Mapper.addToCart(selectedOption);
        if(!(result > 0)) {
            throw new CartRegistException("장바구니 등록에 실패하셨습니다.");
        }


        session.setAttribute("cart", cart);
    }
}
