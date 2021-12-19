package com.example.jpademo.repository;

import com.example.jpademo.entity.ApplyPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ApplyPositionRepository extends JpaRepository<ApplyPosition, Long>, ApplyPositionRepositoryCustom, QuerydslPredicateExecutor<ApplyPosition> {
}