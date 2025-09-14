package com.springBoot.microservices.employee_service.service.impl;

import com.springBoot.microservices.employee_service.dto.EmployeeDto;
import com.springBoot.microservices.employee_service.entity.Employee;
import com.springBoot.microservices.employee_service.repository.EmployeeRepository;
import com.springBoot.microservices.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee savedEmployee = employeeRepository.save(modelMapper.map(employeeDto,Employee.class));
        return modelMapper.map(savedEmployee,EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        return modelMapper.map(employee,EmployeeDto.class);
    }
}
