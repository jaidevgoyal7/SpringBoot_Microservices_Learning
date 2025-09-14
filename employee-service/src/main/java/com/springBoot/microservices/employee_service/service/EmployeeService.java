package com.springBoot.microservices.employee_service.service;

import com.springBoot.microservices.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
}
