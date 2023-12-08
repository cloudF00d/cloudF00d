package com.ohgiraffers.semiproject.manager.search.model.service;

import com.ohgiraffers.semiproject.manager.search.model.dao.SearchUserMapper;
import com.ohgiraffers.semiproject.manager.search.model.dto.CartDTO;
import com.ohgiraffers.semiproject.manager.search.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.manager.search.model.dto.UserDTO;
import com.ohgiraffers.semiproject.manager.search.model.dto.UserReportHistoryDTO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchUserService {

    @Autowired
    private SearchUserMapper Mapper;

    public List<UserDTO> findAllUser() {
        List<UserDTO> userDTOS = Mapper.findAllUser();

        return userDTOS;
    }


    public List<CartDTO> userBuy() {
        List<CartDTO> cartDTOS = Mapper.userBuy();
        return cartDTOS;
    }

    public List<UserReportHistoryDTO> userReport() {
        List<UserReportHistoryDTO> userReportHistoryDTOS = Mapper.userReport();

        return userReportHistoryDTOS;
    }

    public List<ProjectDTO> userFundingProject() {
        List<ProjectDTO> projectDTOS = Mapper.userFundingProject();

        return projectDTOS;
    }

    public UserDTO findOneUser() {
        UserDTO userDTO = Mapper.findOneUser();

        return userDTO;
    }




}
