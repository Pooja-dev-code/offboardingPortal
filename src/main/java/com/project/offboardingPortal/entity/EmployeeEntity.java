package com.project.offboardingPortal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "Employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true, nullable = false)
    private int empId;
    private String empName;
    private String projectTeam;
    private LocalDate dateOfJoining;

    // Autofilled from Capacity Dashboard
    private String manager;
    private String hr;
    private String role; // "Manager", "Senior Analyst", "Analyst", etc.

    // One Employee can submit one Resignation.
    //this is non-owning side ->hence no forigen key created in this table.
    //since resignation belongs to an employee -> hence resignation is the owning side-> will hold forigen key column in resignation table.
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    //cascade type is applied on the parent side
    //Resignation only exists if an Employee submits it.
    //If the employee is deleted from the system, their resignation should also go away.
    private ResignationRequestsEntity resginationRequestsEntity;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private RecruitmentEntity recruitmentEntity;
}
