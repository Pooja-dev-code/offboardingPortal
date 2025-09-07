package com.project.offboardingPortal.repository;

import com.project.offboardingPortal.entity.ResignationRequestsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResignationRequestsRepository extends JpaRepository<ResignationRequestsEntity, Integer> {
}
