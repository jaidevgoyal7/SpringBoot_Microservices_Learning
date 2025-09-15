package com.springBoot.microservices.employee_service.service.impl;

import com.springBoot.microservices.employee_service.EmployeeServiceApplication;
import com.springBoot.microservices.employee_service.dto.APIResponseDto;
import com.springBoot.microservices.employee_service.dto.DepartmentDto;
import com.springBoot.microservices.employee_service.dto.EmployeeDto;
import com.springBoot.microservices.employee_service.entity.Employee;
import com.springBoot.microservices.employee_service.repository.EmployeeRepository;
import com.springBoot.microservices.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;

//    private WebClient webClient;

    private EmployeeServiceApplication.DepartmentServiceAPIClient departmentServiceAPIClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee savedEmployee = employeeRepository.save(modelMapper.map(employeeDto,Employee.class));
        return modelMapper.map(savedEmployee,EmployeeDto.class);
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

//        DepartmentDto  departmentDto = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class
//        ).getBody();

//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = departmentServiceAPIClient.getDepartment(employee.getDepartmentCode());

        return new APIResponseDto(modelMapper.map(employee, EmployeeDto.class), departmentDto);
    }
}
