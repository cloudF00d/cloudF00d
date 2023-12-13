package com.ohgiraffers.semiproject.board.model.service;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dao.BoardMapper;
import com.ohgiraffers.semiproject.manager.model.dao.ManageProjectMapper;
import com.ohgiraffers.semiproject.manager.model.dto.InquiryDTO;
import com.ohgiraffers.semiproject.manager.model.dto.NoticeDTO;
import com.ohgiraffers.semiproject.manager.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.manager.model.dto.UserReportDTO;
import com.ohgiraffers.semiproject.manager.model.service.ManageProjectServiceInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class BoardService implements BoardServiceInter {


    private final BoardMapper mapper;

    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int selectTotalCount(Map<String, String> searchMap) {
        int result = mapper.selectTotalCount(searchMap);

        return result;
    }

    @Override
    public List<NoticeDTO> findAllNotice(SelectCriteria selectCriteria) {
        List<NoticeDTO> noticeDTOS = mapper.findAllNotice(selectCriteria);

        return noticeDTOS;
    }

    @Override
    public NoticeDTO findOneNotice(Long no) {
        NoticeDTO noticeDTO = mapper.findOneNotice(no);

        return noticeDTO;
    }

    @Override
    public int selectTotalInquiryCount(Map<String, String> searchMap) {
        int result = mapper.selectTotalInquiryCount(searchMap);

        return result;
    }

    @Override
    public List<InquiryDTO> findAllInquiry(SelectCriteria selectCriteria) {
        List<InquiryDTO> inquiryDTOS = mapper.findAllInquiry(selectCriteria);

        System.out.println("inquiryDTOS ============================ " + inquiryDTOS);

        return inquiryDTOS;
    }

    @Override
    public InquiryDTO findOneInquiry(Long no) {

        InquiryDTO inquiryDTO = mapper.findOneInquiry(no);

        return inquiryDTO;

    }

    @Override
    public int selectTotalUserComplaintCount(Map<String, String> searchMap) {
        int result = mapper.selectTotalUserComplaintCount(searchMap);
        return result;
    }

    @Override
    public List<UserReportDTO> findAllUserComplaint(SelectCriteria selectCriteria) {
        List<UserReportDTO> userReportDTOS = mapper.findAllUserComplaint(selectCriteria);

        return userReportDTOS;
    }
}
