package com.ohgiraffers.semiproject.manager.model.service;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dao.ManageProjectMapper;
import com.ohgiraffers.semiproject.manager.model.dto.ApprovalHistoryDTO;
import com.ohgiraffers.semiproject.manager.model.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class ManageProjectService implements ManageProjectServiceInter{


    private final ManageProjectMapper mapper;

    public ManageProjectService(ManageProjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int selectTotalCount(Map<String, String> searchMap) {
        int result = mapper.selectTotalCount(searchMap);

        return result;
    }

    @Override
    public List<ProjectDTO> findAllProject(SelectCriteria selectCriteria) {
        List<ProjectDTO> userDTOS = mapper.findAllProject(selectCriteria);

        return userDTOS;
    }

    @Override
    public ProjectDTO findOneProject(Long no) {
        ProjectDTO projectDTO = mapper.findOneProject(no);

        return projectDTO;
    }

    @Override
    public String findStatus(Long no) {
        int status1 = mapper.findStatus(no);
        String status = null;

        System.out.println("status ========================== " + status);

        if(status1 == 1){
            char result = mapper.status(no);
            System.out.println("result =============== " + result);
            if(result == 'N'){
                status = "반려";
            } else if (result == 'Y') {
                status = "승인";
            }

        } else if (status1 == 0){
            status = "신규";
        }

        return status;
    }
}
