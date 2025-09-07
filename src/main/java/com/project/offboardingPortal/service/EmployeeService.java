package com.project.offboardingPortal.service;

import com.project.offboardingPortal.dto.EmployeeDTO;
import com.project.offboardingPortal.entity.EmployeeEntity;
import com.project.offboardingPortal.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeDTO saveEmployee(EmployeeDTO dto) {
        EmployeeEntity entity;

        if (employeeRepository.existsByEmpId(dto.getEmpId())) {
            entity = employeeRepository.findByEmpId(dto.getEmpId()).get(); //first it return Optional<EmployeeEntity>
            // then using .get() it extracts the entity from Optional(Optional.get()).
            entity.setEmpName(dto.getEmpName());
            entity.setProjectTeam(dto.getProjectTeam());
            entity.setDateOfJoining(LocalDate.parse(dto.getDateOfJoining()));
            entity.setManager(dto.getManager());
            entity.setHr(dto.getHr());
            entity.setRole(dto.getRole());
        } else {
            entity = new EmployeeEntity();
            entity.setEmpId(dto.getEmpId());
            entity.setEmpName(dto.getEmpName());
            entity.setProjectTeam(dto.getProjectTeam());
            entity.setDateOfJoining(LocalDate.parse(dto.getDateOfJoining()));
            entity.setManager(dto.getManager());
            entity.setHr(dto.getHr());
            entity.setRole(dto.getRole());
        }
        EmployeeEntity savedEntity = employeeRepository.save(entity);
        //convert entity back to dto for response
        EmployeeDTO employeeDTO = modelMapper.map(savedEntity, EmployeeDTO.class);
        return employeeDTO;
    }

    public EmployeeDTO fetchEmployeeByID(int empID){
        Optional<EmployeeEntity> employeeEntity =employeeRepository.findByEmpId(empID);

        return modelMapper.map(employeeEntity,EmployeeDTO.class);
    }



}
