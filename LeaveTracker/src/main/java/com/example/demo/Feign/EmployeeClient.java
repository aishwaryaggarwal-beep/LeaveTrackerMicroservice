package com.example.demo.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Entity.UserDTO;

//import com.example.demo.entity.Employee;

@FeignClient("USERSERVICE")
public interface EmployeeClient {
    
	@GetMapping("/user/{username}")
	UserDTO getUserByUsername(@PathVariable String username);

}
