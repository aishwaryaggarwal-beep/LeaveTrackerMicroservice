package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.entity.UserDTO;
import com.example.demo.feign.AuthClient;
import com.example.demo.repository.EmployeeRepository;

@Component
public class EmployeeService {
     @Autowired
     private EmployeeRepository employeeRepository;
     
     @Autowired
     AuthClient authClient;

     public List<Employee> getAllEmployees() {
         return employeeRepository.findAll();
     }

     public Optional<Employee> getEmployeeById(int id) {
         return employeeRepository.findById(id);
     }

     
     public Employee addEmployee(Employee employee) {
    	 
         Employee saved =  employeeRepository.save(employee);
         UserDTO dto = new UserDTO();
         dto.setUsername(employee.getName());
         dto.setPassword("aish");
         System.out.print("setpassword");
         dto.setRole(employee.getRole());
         System.out.print(employee.getRole());
         dto.setEmployeeId(saved.getEmployeeId());
         authClient.register(dto);
         return saved;
     }

     public Employee updateEmployee(int id, Employee employee) {
         employee.setEmployeeId(id);
         return employeeRepository.save(employee);
     }
     
     public void deleteEmployee(int id) {
    	 employeeRepository.deleteById(id);
     }
     
     
}
