package com.ohgiraffers.semiproject.manager.search.model.dao;

import com.ohgiraffers.semiproject.manager.search.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchUserMapper {
    /*
    * 사용자 조회 기능
    * 1. 게시판 형태의 폼에 모든 글을 출력한다.
    * 2. 그 중 글을 클릭하면 글의 상세페이지를 출력하는 창으로 넘어간다.
    * 3. 삭제할 수 있다?
    * 4. 수정할 수 있다?
    * 5. 정지할 수 있다?
    * */

    List<UserDTO> findAllUser();

    List<PaymentHistoryDTO> userDetail();

    List<CartDTO> userBuy(long no);

    List<UserReportHistoryDTO> userReport(long no);

    List<ProjectDTO> userFundingProject(long no);

    UserDTO findOneUser(long no);



}
