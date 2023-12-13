package com.ohgiraffers.semiproject.member.model.service;

import com.ohgiraffers.semiproject.common.exception.member.MemberJoinException;
import com.ohgiraffers.semiproject.common.exception.member.MemberModifyException;
import com.ohgiraffers.semiproject.common.exception.member.MemberRemoveException;
import com.ohgiraffers.semiproject.member.emailsender.EmailSender;
import com.ohgiraffers.semiproject.member.model.dao.MemberMapper;
import com.ohgiraffers.semiproject.member.model.dto.MemberAndAuthorityDTO;
import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.member.model.dto.UserAndEmailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberMapper mapper;





    public MemberServiceImpl(PasswordEncoder passwordEncoder, MemberMapper mapper) {
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }
    private String generateRandomString(int length) {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }




    @Transactional
    @Override
    public void joinMember(MemberDTO memberDTO) throws MemberJoinException {




        log.info("[MemberService] Insert Member : " + memberDTO);
        int result = mapper.insertMember(memberDTO);

        int userCode = mapper.selectLastInsertUserCode(); // tbl_user 에서 마지막 입력한 pk 값.
        System.out.println(userCode+"==============================userCode============================================");
        log.info(String.valueOf(result));
        log.info(String.valueOf(userCode));
//        throw new MemberJoinException("임시 오류");

        int result1 = mapper.insertAuthor(userCode); // tbl_authority_list에 넣는 값. // insert #{userCode}, 권한명

        System.out.println("result1.getUserId()========== : ");

        log.info("[MemberService] Insert result : " + ((result > 0) ? "회원가입 성공" : "회원가입 실패"));
        log.info("[MemberService] Insert result : " + ((result1 > 0) ? "권한주기 성공" : "회원가입 실패"));

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


    @Override
    @Transactional
    public int sendEmail(String email) {
        EmailSender es = new EmailSender();
        String randomStr = generateRandomString(6);
        es.emailSend(email,randomStr);
    // 데이터베이스에 추가
        UserAndEmailDTO userAndEmailDTO = new UserAndEmailDTO();
        userAndEmailDTO.setEmailCerti(randomStr);

        int result = mapper.sendEmail(userAndEmailDTO);
        // 로직
        System.out.println("userAndEmailDTO = " + userAndEmailDTO); // 시퀀스 번호가 다시 조회되어서 출력

        return userAndEmailDTO.getEmailCode();

    }

    @Override
    public boolean checkMail(String checkMail) {
        UserAndEmailDTO userAndEmailDTO = mapper.checkMail(checkMail);

        System.out.println(userAndEmailDTO.getEmailCode());

        // 이메일 인증 코드를 통해 조회된 데이터가 없으면 false 반환
        if (userAndEmailDTO.getEmailCerti() == null) {
            return false;
        }

        // 대소문자를 구분하지 않고 비교
        return userAndEmailDTO.getEmailCerti().equalsIgnoreCase(checkMail);
    }

}
