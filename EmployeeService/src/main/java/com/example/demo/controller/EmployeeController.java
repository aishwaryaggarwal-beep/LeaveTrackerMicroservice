package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }
    
//    @GetMapping("/{username}")
//    public Optional<Employee> getEmloyeeByUsername(@PathVariable String username){
//    	return employeeService.getEmployeeByUsername(username);
//    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null) {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not authenticated");
//        }
//
//        boolean isAdmin = authentication.getAuthorities().stream()
//                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
//
//        if (!isAdmin) {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN)
//                    .body("Only admins can add employees");
//        }

        Employee savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
