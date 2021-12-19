package com.example.jpademo.repository;

import com.example.jpademo.dto.ProjectDto;

import static com.example.jpademo.entity.QProject.project;
import static com.example.jpademo.entity.QProjectPosition.projectPosition;
import static com.example.jpademo.entity.QApplyPosition.applyPosition;

import com.example.jpademo.dto.QProjectDto;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProjectRepositoryCustomImpl implements ProjectRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ProjectDto> selectProjectsWithSubQuery() {
        List<ProjectDto> listDto = jpaQueryFactory
                .select(new QProjectDto(
                        project.id,
                        project.name,
                        ExpressionUtils.as(
                                JPAExpressions
                                        .select(applyPosition.count())
                                        .from(applyPosition)
                                        .where(applyPosition.projectPosition.in(
                                                JPAExpressions
                                                        .select(projectPosition)
                                                        .from(projectPosition)
                                                        .where(projectPosition.project.eq(project))
                                        ))
                                , "applyCount"
                        ))
                )
                .from(project)
                .fetch();
        return listDto;
//        List<ProjectDto> listDto = jpaQueryFactory
//                .select(Projections.fields(ProjectDto.class,
//                    project.id,
//                    project.name,
//                    ExpressionUtils.as(
//                        JPAExpressions
//                            .select(applyPosition.count())
//                            .from(applyPosition)
//                            .where(applyPosition.projectPosition.in(
//                                    JPAExpressions
//                                        .select(projectPosition)
//                                        .from(projectPosition)
//                                        .where(projectPosition.project.eq(project))
//                            ))
//                        , "applyCount"
//                    )
//                ))
//                .from(project)
//                .fetch();
//        return listDto;
    }

    @Override
    public List<ProjectDto> selectProjectsWithJoin() {
        List<ProjectDto> list = jpaQueryFactory
                .select(new QProjectDto(project.id,
                        project.name,
                        applyPosition.id.count()))
                .from(project)
                .leftJoin(projectPosition)
                .on(project.eq(projectPosition.project))
                .leftJoin(applyPosition)
                .on(projectPosition.eq(applyPosition.projectPosition))
//                .groupBy(project)
                .groupBy(project, projectPosition.project.id)
                .fetch();
        return list;
    }
}
