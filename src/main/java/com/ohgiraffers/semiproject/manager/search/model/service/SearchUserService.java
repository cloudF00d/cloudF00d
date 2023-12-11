package com.ohgiraffers.semiproject.manager.search.model.service;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.search.model.dao.SearchUserMapper;
import com.ohgiraffers.semiproject.manager.search.model.dto.CartDTO;
import com.ohgiraffers.semiproject.manager.search.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.manager.search.model.dto.UserDTO;
import com.ohgiraffers.semiproject.manager.search.model.dto.UserReportHistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchUserService {

    @Autowired
    private SearchUserMapper Mapper;

    public List<UserDTO> findAllUser(SelectCriteria selectCriteria) {
        List<UserDTO> userDTOS = Mapper.findAllUser(selectCriteria);

        return userDTOS;
    }


    public List<CartDTO> userBuy(Long no) {
        List<CartDTO> cartDTOS = Mapper.userBuy(no);
        return cartDTOS;
    }

    public List<UserReportHistoryDTO> userReport(Long no) {
        List<UserReportHistoryDTO> userReportHistoryDTOS = Mapper.userReport(no);

        return userReportHistoryDTOS;
    }

    public List<ProjectDTO> userFundingProject(Long no) {
        List<ProjectDTO> projectDTOS = Mapper.userFundingProject(no);

        return projectDTOS;
    }

    public UserDTO findOneUser(Long no) {
        UserDTO userDTO = Mapper.findOneUser(no);

        return userDTO;
    }


    public int selectTotalCount(Map<String, String> searchMap) {

        int result = Mapper.selectTotalCount(searchMap);

        return result;
    }
}
