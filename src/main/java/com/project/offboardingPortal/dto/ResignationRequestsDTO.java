package com.project.offboardingPortal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Used when the employee submits a resignation (API input), it Only includes fields the employee can provide
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResignationRequestsDTO {

    private int empId;
    private String reasonForResignation;
    private boolean needEarlyRelease;
    private String earlyReleaseDate;   // Optional, if employee requests
    private String earlyReleaseReason;
}
