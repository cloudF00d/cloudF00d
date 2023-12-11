package com.ohgiraffers.semiproject.project.product.model.dto;

import lombok.*;


public class TotalStoryDTO {
    private PrivateBusinessDTO privateBusinessDTO;
    private ProfileImageDTO profileImageDTO;
    private ProjectDTO projectDTO;
    private ProjectFileDTO projectFileDTO;
    private ProjectOptionDTO projectOptionDTO;
    private ProjectUserDTO projectUserDTO;

    public TotalStoryDTO() {
    }

    public TotalStoryDTO(PrivateBusinessDTO privateBusinessDTO, ProfileImageDTO profileImageDTO, ProjectDTO projectDTO, ProjectFileDTO projectFileDTO, ProjectOptionDTO projectOptionDTO, ProjectUserDTO projectUserDTO) {
        this.privateBusinessDTO = privateBusinessDTO;
        this.profileImageDTO = profileImageDTO;
        this.projectDTO = projectDTO;
        this.projectFileDTO = projectFileDTO;
        this.projectOptionDTO = projectOptionDTO;
        this.projectUserDTO = projectUserDTO;
    }

    public PrivateBusinessDTO getPrivateBusinessDTO() {
        return privateBusinessDTO;
    }

    public void setPrivateBusinessDTO(PrivateBusinessDTO privateBusinessDTO) {
        this.privateBusinessDTO = privateBusinessDTO;
    }

    public ProfileImageDTO getProfileImageDTO() {
        return profileImageDTO;
    }

    public void setProfileImageDTO(ProfileImageDTO profileImageDTO) {
        this.profileImageDTO = profileImageDTO;
    }

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public ProjectFileDTO getProjectFileDTO() {
        return projectFileDTO;
    }

    public void setProjectFileDTO(ProjectFileDTO projectFileDTO) {
        this.projectFileDTO = projectFileDTO;
    }

    public ProjectOptionDTO getProjectOptionDTO() {
        return projectOptionDTO;
    }

    public void setProjectOptionDTO(ProjectOptionDTO projectOptionDTO) {
        this.projectOptionDTO = projectOptionDTO;
    }

    public ProjectUserDTO getProjectUserDTO() {
        return projectUserDTO;
    }

    public void setProjectUserDTO(ProjectUserDTO projectUserDTO) {
        this.projectUserDTO = projectUserDTO;
    }

    @Override
    public String toString() {
        return "TotalStoryDTO{" +
                "privateBusinessDTO=" + privateBusinessDTO +
                ", profileImageDTO=" + profileImageDTO +
                ", projectDTO=" + projectDTO +
                ", projectFileDTO=" + projectFileDTO +
                ", projectOptionDTO=" + projectOptionDTO +
                ", projectUserDTO=" + projectUserDTO +
                '}';
    }
}
