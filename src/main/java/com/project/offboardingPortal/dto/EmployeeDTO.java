package com.project.offboardingPortal.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private int empId;
    private String empName;
    private String projectTeam;
    private String dateOfJoining;
    private String manager;
    private String hr;
    private String role;

    @JsonManagedReference
    private ResignationResponseDTO resignation; // Nested DTO

    @JsonManagedReference
    private RecruitmentDTO recruitment;         // Nested DTO
}
