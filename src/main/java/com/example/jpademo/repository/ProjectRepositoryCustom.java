package com.example.jpademo.repository;

import com.example.jpademo.dto.ProjectDto;

import java.util.List;

public interface ProjectRepositoryCustom {
    List<ProjectDto> selectProjectsWithSubQuery();
    List<ProjectDto> selectProjectsWithJoin();
}
