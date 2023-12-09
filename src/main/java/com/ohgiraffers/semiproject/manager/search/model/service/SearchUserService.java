package com.ohgiraffers.semiproject.manager.search.model.service;

import com.ohgiraffers.semiproject.manager.search.model.dao.SearchUserMapper;
import com.ohgiraffers.semiproject.manager.search.model.dto.CartDTO;
import com.ohgiraffers.semiproject.manager.search.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.manager.search.model.dto.UserDTO;
import com.ohgiraffers.semiproject.manager.search.model.dto.UserReportHistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchUserService {

    @Autowired
    private SearchUserMapper Mapper;

    public List<UserDTO> findAllUser() {
        List<UserDTO> userDTOS = Mapper.findAllUser();

        return userDTOS;
    }


    public List<CartDTO> userBuy(long no) {
        List<CartDTO> cartDTOS = Mapper.userBuy(no);
        return cartDTOS;
    }

    public List<UserReportHistoryDTO> userReport(long no) {
        List<UserReportHistoryDTO> userReportHistoryDTOS = Mapper.userReport(no);

        return userReportHistoryDTOS;
    }

    public List<ProjectDTO> userFundingProject(long no) {
        List<ProjectDTO> projectDTOS = Mapper.userFundingProject(no);

        return projectDTOS;
    }

    public UserDTO findOneUser(long no) {
        UserDTO userDTO = Mapper.findOneUser(no);

        return userDTO;
    }




}
