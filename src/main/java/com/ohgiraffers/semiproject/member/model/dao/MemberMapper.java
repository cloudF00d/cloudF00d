package com.ohgiraffers.semiproject.member.model.dao;

import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int insertMember(MemberDTO member);

    MemberAndAuthorityDTO findByMemberId(String userId);

    String selectMemberById(String userId);

    int updateMember(MemberAndAuthorityDTO member);

    int deleteMember(MemberAndAuthorityDTO member);
}
