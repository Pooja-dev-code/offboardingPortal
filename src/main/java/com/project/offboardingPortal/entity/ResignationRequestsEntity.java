package com.project.offboardingPortal.entity;
import com.project.offboardingPortal.enums.ResignationStatus;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Resignation_Requests")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResignationRequestsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String reasonForResignation;

    private boolean needEarlyRelease;
    private LocalDate earlyReleaseDate;
    private String earlyReleaseReason;

    // Auto-calculated: 2 months from today if no early release
    private LocalDate lastWorkingDay;

    @Enumerated(EnumType.STRING)  // saves enum name (not ordinal) into DB
    @Column(nullable = false)
    private ResignationStatus finalStatus;
    private String feedback;  //received from respective emp's manager

    @OneToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "empId")
    private EmployeeEntity employee;

}
