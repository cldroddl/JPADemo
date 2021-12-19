package com.example.jpademo.dto;

import com.example.jpademo.entity.ProjectPosition;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class ProjectDto {
    private Long id;

    private String name;

    private List<ProjectPosition> projectPositions = new ArrayList<>();

    private Long applyCount;

    @QueryProjection
    public ProjectDto(Long id, String name, Long applyCount) {
        this.id = id;
        this.name = name;
        this.applyCount = applyCount;
    }
}
