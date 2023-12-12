package com.ohgiraffers.semiproject.manager.model.service;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dao.SearchUserMapper;
import com.ohgiraffers.semiproject.manager.model.dto.*;
import com.ohgiraffers.semiproject.manager.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class SearchUserService implements SearchUserServiceInter{

    private SearchUserMapper Mapper;

    public SearchUserService(SearchUserMapper mapper) {
        Mapper = mapper;
    }

    @Override
    public List<UserDTO> findAllUser(SelectCriteria selectCriteria) {
        List<UserDTO> userDTOS = Mapper.findAllUser(selectCriteria);

        return userDTOS;
    }

    @Override
    public List<CartDTO> userBuy(Long no) {
        List<CartDTO> cartDTOS = Mapper.userBuy(no);
        return cartDTOS;
    }
    @Override
    public List<UserReportHistoryDTO> userReport(Long no) {
        List<UserReportHistoryDTO> userReportHistoryDTOS = Mapper.userReport(no);

        return userReportHistoryDTOS;
    }
    @Override
    public List<ProjectDTO> userFundingProject(Long no) {
        List<ProjectDTO> projectDTOS = Mapper.userFundingProject(no);

        return projectDTOS;
    }
    @Override
    public UserDTO findOneUser(Long no) {
        UserDTO userDTO = Mapper.findOneUser(no);

        return userDTO;
    }

    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = Mapper.selectTotalCount(searchMap);

        return result;
    }




    public void userUpdate(List<CartDTO> cartDTOS,
                           List<UserReportHistoryDTO> userReportHistoryDTOS,
                           List<ProjectDTO> projectDTOS,
                           UserDTO userDTO,
                           PrivateBusinessDTO privateBusinessDTO) {
//        int cartUpdate = Mapper.cartUpdate(cartDTOS);
//        int reportHistory = Mapper.reportUpdate(userReportHistoryDTOS);
//        int project = Mapper.projectUpdate(projectDTOS);
        int userUpdate = Mapper.userUpdate(userDTO);
        int businessUpdate = Mapper.businessUpdate(privateBusinessDTO);


    }

    public List<UserDTO> findAllSeller(SelectCriteria selectCriteria) {

        List<UserDTO> userDTOS = Mapper.findAllSeller(selectCriteria);

        return userDTOS;
    }

    public int selectTotalSellerCount(Map<String, String> searchMap) {

        int result = Mapper.selectTotalSellerCount(searchMap);

        return result;
    }

    public PrivateBusinessDTO companyInfo(Long no) {

        PrivateBusinessDTO userDTO = Mapper.companyInfo(no);

        return userDTO;
    }

    public List<UserReportHistoryDTO> findAllComplaint() {
        List<UserReportHistoryDTO> userReportHistoryDTOS = Mapper.findAllComplaint();

        return userReportHistoryDTOS;
    }
}
