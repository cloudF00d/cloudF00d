package com.ohgiraffers.semiproject.order.model.dao;

import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.order.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.order.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {
   List<UserDTO> user1();

   int member(MemberDTO member);

//    결제 페이지
   



//    결제 취소


}
