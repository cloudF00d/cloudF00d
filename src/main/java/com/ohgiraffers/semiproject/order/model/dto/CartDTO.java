package com.ohgiraffers.semiproject.order.model.dto;

import com.ohgiraffers.semiproject.member.model.dto.MemberDTO;
import com.ohgiraffers.semiproject.project.model.dto.ProjectDTO;
import com.ohgiraffers.semiproject.project.model.dto.ProjectOptionDTO;
import lombok.Getter;

@Getter
public class CartDTO {


    private int code;

    private MemberDTO memberCode;

    private ProjectDTO  projectCode;

    private ProjectOptionDTO projectOptionCode;

    private String status;

    public CartDTO() {
    }

    public CartDTO(int code, MemberDTO memberCode, ProjectDTO projectCode, ProjectOptionDTO projectOptionCode, String status) {
        this.code = code;
        this.memberCode = memberCode;
        this.projectCode = projectCode;
        this.projectOptionCode = projectOptionCode;
        this.status = status;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMemberCode(MemberDTO memberCode) {
        this.memberCode = memberCode;
    }

    public void setProjectCode(ProjectDTO projectCode) {
        this.projectCode = projectCode;
    }

    public void setProjectOptionCode(ProjectOptionDTO projectOptionCode) {
        this.projectOptionCode = projectOptionCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "code=" + code +
                ", memberCode=" + memberCode +
                ", projectCode=" + projectCode +
                ", projectOptionCode=" + projectOptionCode +
                ", status='" + status + '\'' +
                '}';
    }


}


