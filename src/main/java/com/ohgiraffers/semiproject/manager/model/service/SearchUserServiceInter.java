package com.ohgiraffers.semiproject.manager.model.service;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dto.*;

import java.util.List;
import java.util.Map;

public interface SearchUserServiceInter {

    // 모든 사용자 조회
    List<UserDTO> findAllUser(SelectCriteria selectCriteria);

    // 구매목록 조회
     List<CartDTO> userBuy(Long no);

     List<UserReportHistoryDTO> userReport(Long no);

     List<ProjectDTO> userFundingProject(Long no);

     UserDTO findOneUser(Long no);

     int selectTotalCount(Map<String, String> searchMap);

}
