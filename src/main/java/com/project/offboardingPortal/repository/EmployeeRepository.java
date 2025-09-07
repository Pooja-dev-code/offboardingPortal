package com.project.offboardingPortal.repository;

import com.project.offboardingPortal.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    // checks if employee exists by using empID.
    boolean existsByEmpId(int empId);

    // Fetches the managed entity by empId so that Hibernate tracks changes.
    Optional<EmployeeEntity> findByEmpId(int empId);

}
