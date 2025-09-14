package com.springBoot.microservices.department_service.service.impl;

import com.springBoot.microservices.department_service.dto.DepartmentDto;
import com.springBoot.microservices.department_service.entity.Department;
import com.springBoot.microservices.department_service.repository.DepartmentRepository;
import com.springBoot.microservices.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        Department savedDepartment = departmentRepository.save(department);
        return modelMapper.map(savedDepartment, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return modelMapper.map(department, DepartmentDto.class);
    }
}
