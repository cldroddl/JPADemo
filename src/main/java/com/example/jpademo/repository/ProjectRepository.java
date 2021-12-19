package com.example.jpademo.repository;

import com.example.jpademo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProjectRepository extends JpaRepository<Project, Long>, ProjectRepositoryCustom, QuerydslPredicateExecutor<Project> {
}