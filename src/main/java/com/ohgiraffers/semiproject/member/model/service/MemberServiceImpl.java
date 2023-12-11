package com.ohgiraffers.semiproject.member.model.service;

import com.ohgiraffers.semiproject.common.exception.member.MemberJoinException;
import com.ohgiraffers.semiproject.common.exception.member.MemberModifyException;
import com.ohgiraffers.semiproject.common.exception.member.MemberRemoveException;
import com.ohgiraffers.semiproject.member.model.dao.MemberMapper;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberMapper mapper;


    public MemberServiceImpl(PasswordEncoder passwordEncoder, MemberMapper mapper) {
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }



    @Override
    @Transactional
    public void joinMember(MemberDTO member) throws MemberJoinException {

        log.info("[MemberService] Insert Member : " + member);
        int result = mapper.insertMember(member);

        log.info("[MemberService] Insert result : " + ((result > 0) ? "회원가입 성공" : "회원가입 실패"));

        if(!(result > 0 )){
            throw new MemberJoinException("회원 가입에 실패하였습니다.");
        }
    }

    @Override
    public boolean selectMemberById(String userId) {

        String result = mapper.selectMemberById(userId);

        return result != null? true : false;
    }

    @Override
    public void modifyMember(MemberAndAuthorityDTO member) throws MemberModifyException {
        int result = mapper.updateMember(member);

        if(!(result > 0)) {
            throw new MemberModifyException("회원 정보 수정에 실패하셨습니다.");
        }
    }

    @Override
    public void removeMember(MemberAndAuthorityDTO member) throws MemberRemoveException {
        int result = mapper.deleteMember(member);

        if(!(result > 0)) {
            throw new MemberRemoveException("회원 탈퇴에 실패하셨습니다.");
        }
    }



}
