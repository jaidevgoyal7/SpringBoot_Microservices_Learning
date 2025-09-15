package com.springBoot.microservices.employee_service;

import com.springBoot.microservices.employee_service.dto.DepartmentDto;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

//	@Bean
//	public RestTemplate restTemplate() { return new RestTemplate(); }

//	@Bean
//	public WebClient webClient() { return WebClient.builder().build(); }

	@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
	public interface DepartmentServiceAPIClient {
		@GetMapping("api/departments/{departmentCode}")
		DepartmentDto getDepartment(@PathVariable String departmentCode);
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
