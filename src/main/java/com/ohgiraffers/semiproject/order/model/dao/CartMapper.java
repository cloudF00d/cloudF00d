package com.ohgiraffers.semiproject.order.model.dao;
import com.ohgiraffers.semiproject.order.model.dto.CartInsertDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CartMapper {

    List<CartInsertDTO> cartPage();
}
