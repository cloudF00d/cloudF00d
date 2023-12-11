package com.ohgiraffers.semiproject.manager.search.model.service;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.search.model.dto.CartDTO;
import com.ohgiraffers.semiproject.manager.search.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.manager.search.model.dto.UserDTO;
import com.ohgiraffers.semiproject.manager.search.model.dto.UserReportHistoryDTO;

import java.util.List;
import java.util.Map;

public interface SearchUserServiceInter {

    // 모든 사용자 조회
    public List<UserDTO> findAllUser(SelectCriteria selectCriteria);

    // 구매목록 조회
    public List<CartDTO> userBuy(Long no);

    public List<UserReportHistoryDTO> userReport(Long no);

    public List<ProjectDTO> userFundingProject(Long no);

    public UserDTO findOneUser(Long no);

    public int selectTotalCount(Map<String, String> searchMap);
}
