package com.project.offboardingPortal.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.offboardingPortal.enums.ResignationStatus;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentDTO {

    private int recruitmentId;
    private String JD_url;
    private ResignationStatus finalStatus;

    private LocalDate lastWorkingDay;
    private int hrId;

    @JsonBackReference  // Recruitment → Employee (back reference)
    private EmployeeDTO employee;
}
