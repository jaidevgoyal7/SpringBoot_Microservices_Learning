package com.springBoot.microservices.employee_service.controller;

import com.springBoot.microservices.employee_service.dto.APIResponseDto;
import com.springBoot.microservices.employee_service.dto.EmployeeDto;
import com.springBoot.microservices.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable Long employeeId){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
}
