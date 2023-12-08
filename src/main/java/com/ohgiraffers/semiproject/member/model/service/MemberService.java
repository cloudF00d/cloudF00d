package com.ohgiraffers.semiproject.member.model.service;

import com.ohgiraffers.semiproject.common.exception.member.MemberJoinException;
import com.ohgiraffers.semiproject.common.exception.member.MemberModifyException;
import com.ohgiraffers.semiproject.common.exception.member.MemberRemoveException;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;

public interface MemberService {
    public void joinMember(MemberAndAuthorityDTO member) throws MemberJoinException;

    public boolean selectMemberById(String userId);

    public void modifyMember(MemberAndAuthorityDTO member) throws MemberModifyException;

    public void removeMember(MemberAndAuthorityDTO member) throws MemberRemoveException;
}
