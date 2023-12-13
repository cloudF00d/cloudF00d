package com.ohgiraffers.semiproject.manager.model.dao;

import com.ohgiraffers.semiproject.common.paging.SelectCriteria;
import com.ohgiraffers.semiproject.manager.model.dto.InquiryDTO;
import com.ohgiraffers.semiproject.manager.model.dto.NoticeDTO;
import com.ohgiraffers.semiproject.manager.model.dto.UserReportDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {


    int selectTotalCount(Map<String, String> searchMap);

    List<NoticeDTO> findAllNotice(SelectCriteria selectCriteria);

    NoticeDTO findOneNotice(Long no);

    int selectTotalInquiryCount(Map<String, String> searchMap);

    List<InquiryDTO> findAllInquiry(SelectCriteria selectCriteria);

    InquiryDTO findOneInquiry(Long no);

    int selectTotalUserComplaintCount(Map<String, String> searchMap);

    List<UserReportDTO> findAllUserComplaint(SelectCriteria selectCriteria);
}
