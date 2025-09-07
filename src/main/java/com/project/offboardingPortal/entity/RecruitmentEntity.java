package com.project.offboardingPortal.entity;

import com.project.offboardingPortal.enums.ResignationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RecruitmentTable")
public class RecruitmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int recruitmentId;
    private String JD_url;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResignationStatus finalStatus;

    private LocalDate lastWorkingDay;
    private int hrId;

    @OneToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "empId")
    private EmployeeEntity employee;
}
