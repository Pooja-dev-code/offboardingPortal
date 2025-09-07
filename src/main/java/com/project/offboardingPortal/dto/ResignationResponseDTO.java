package com.project.offboardingPortal.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Used when sending data back (API output), it Includes all info, including employee details
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResignationResponseDTO {

    private int empId;
    private String reasonForResignation;
    private boolean needEarlyRelease;
    private String earlyReleaseDate;   // LocalDate → String (yyyy-MM-dd)
    private String earlyReleaseReason;
    private String lastWorkingDay;     // LocalDate → String
    private String finalStatus;        // Enum → String
    private String feedback;

    @JsonBackReference   // Resignation → Employee (back reference)
    private EmployeeDTO employee;
}
