package com.springBoot.microservices.department_service.service;

import com.springBoot.microservices.department_service.dto.DepartmentDto;
import org.springframework.stereotype.Service;


public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String departmentCode);

}
