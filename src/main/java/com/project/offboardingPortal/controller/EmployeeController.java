package com.project.offboardingPortal.controller;

import com.project.offboardingPortal.dto.EmployeeDTO;
import com.project.offboardingPortal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO dto = employeeService.saveEmployee(employeeDTO);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDTO> fetchEmployeeById(@PathVariable int empId){
        EmployeeDTO employeeDTO = employeeService.fetchEmployeeByID(empId);
        return ResponseEntity.ok(employeeDTO);
    }
}
