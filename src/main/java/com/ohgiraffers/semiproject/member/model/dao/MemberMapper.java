package com.ohgiraffers.semiproject.member.model.dao;

import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int insertMember(MemberAndAuthorityDTO member);

    MemberAndAuthorityDTO findByMemberId(String userId);

    String selectMemberById(String userId);

    int updateMember(MemberAndAuthorityDTO member);

    int deleteMember(MemberAndAuthorityDTO member);
}
