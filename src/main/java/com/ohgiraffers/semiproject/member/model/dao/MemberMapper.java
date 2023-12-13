package com.ohgiraffers.semiproject.member.model.dao;

import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.member.model.dto.UserAndEmailDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    int insertMember(MemberDTO member);

    MemberAndAuthorityDTO findByMemberId(String userId);

    String selectMemberById(String userId);

    int updateMember(MemberAndAuthorityDTO member);

    int deleteMember(MemberAndAuthorityDTO member);


    int sendEmail(UserAndEmailDTO userAndEmailDTO);

    UserAndEmailDTO checkMail(String checkMail);

    int selectLastInsertUserCode();

    int insertAuthor(int userCode);
}
