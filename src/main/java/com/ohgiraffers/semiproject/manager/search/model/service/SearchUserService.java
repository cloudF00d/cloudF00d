package com.ohgiraffers.semiproject.manager.search.model.service;

import com.ohgiraffers.semiproject.manager.search.model.dao.SearchUserMapper;
import com.ohgiraffers.semiproject.manager.search.model.dto.UserDTO;
import com.ohgiraffers.semiproject.manager.search.model.dto.UserDetailDTO;
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

    public List<UserDetailDTO> userDetail() {
        List<UserDetailDTO> userDetailDTOS = Mapper.userDetail();

        return userDetailDTOS;
    }

}
