package com.ohgiraffers.semiproject.order.model.service;

import com.ohgiraffers.semiproject.order.model.dao.CartMapper;
import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.dto.SelectOptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class CartService {

    private final CartMapper Mapper;

    public CartService(CartMapper mapper) {
        Mapper = mapper;
    }

    public CartDTO cart() {

        CartDTO cart = Mapper.cartPage();

        return cart;
    }


}
