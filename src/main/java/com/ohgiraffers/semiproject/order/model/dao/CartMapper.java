package com.ohgiraffers.semiproject.order.model.dao;

import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import com.ohgiraffers.semiproject.order.model.dto.CartInsertDTO;
import com.ohgiraffers.semiproject.project.product.model.dto.ProjectOptionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface CartMapper {


     int addToCart(CartDTO cart);

    List<CartInsertDTO> cartPage();

    int insertCart(Map<String, Object> addToCart);
}
