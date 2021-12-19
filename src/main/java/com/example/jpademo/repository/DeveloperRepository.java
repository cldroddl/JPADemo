package com.example.jpademo.repository;

import com.example.jpademo.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DeveloperRepository extends JpaRepository<Developer, Long>, QuerydslPredicateExecutor<Developer>, DeveloperRepositoryCustom {
}