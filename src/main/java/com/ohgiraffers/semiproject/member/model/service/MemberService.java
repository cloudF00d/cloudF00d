package com.ohgiraffers.semiproject.member.model.service;

import com.ohgiraffers.semiproject.common.exception.member.MemberJoinException;
import com.ohgiraffers.semiproject.common.exception.member.MemberModifyException;
import com.ohgiraffers.semiproject.common.exception.member.MemberRemoveException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;

public interface MemberService {




    void joinMember(MemberDTO memberDTO) throws MemberJoinException;

    boolean selectMemberById(String userId);

    void modifyMember(MemberAndAuthorityDTO member) throws MemberModifyException;

    void removeMember(MemberAndAuthorityDTO member) throws MemberRemoveException;

    int sendEmail(String email);

    boolean checkMail(String checkMail);
}
