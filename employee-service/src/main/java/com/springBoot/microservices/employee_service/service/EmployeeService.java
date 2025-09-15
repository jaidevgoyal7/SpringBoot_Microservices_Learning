package com.springBoot.microservices.employee_service.service;

import com.springBoot.microservices.employee_service.dto.APIResponseDto;
import com.springBoot.microservices.employee_service.dto.EmployeeDto;
import lombok.AllArgsConstructor;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
