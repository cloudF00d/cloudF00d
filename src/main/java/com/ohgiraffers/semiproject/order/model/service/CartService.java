package com.ohgiraffers.semiproject.order.model.service;

import com.ohgiraffers.semiproject.order.model.dao.CartMapper;
import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartInsertDTO;
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
}
