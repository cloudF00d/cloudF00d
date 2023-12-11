package com.ohgiraffers.semiproject.order.model.dao;

import com.ohgiraffers.semiproject.order.model.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CartMapper {

    CartDTO cartPage();
}
