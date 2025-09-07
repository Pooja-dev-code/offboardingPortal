package com.project.offboardingPortal.repository;

import com.project.offboardingPortal.entity.RecruitmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentRepository extends JpaRepository<RecruitmentEntity, Integer> {
}
