package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.LeaveRequest;
import com.example.demo.Entity.UserDTO;
import com.example.demo.Feign.EmployeeClient;
import com.example.demo.Service.LeaveService;

@RestController
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @Autowired
    private EmployeeClient client;

    @PostMapping("/apply")
    public String applyLeave(@RequestBody LeaveRequest req, Authentication auth) {

        // 1. Get username from JWT token
        String username = auth.getName();

        // 2. Call UserService to get employeeId
        UserDTO user = client.getUserByUsername(username);

        int employeeId = user.getEmployeeId();

        // 3. Apply leave using employeeId
        return leaveService.applyLeave(req, employeeId);
    }


    @GetMapping("/history")
    public List<LeaveRequest> getHistory(Authentication auth) {
        UserDTO user = client.getUserByUsername(auth.getName());
        return leaveService.getLeaveHistory(user.getEmployeeId());
    }

    @GetMapping("/remaining")
    public int getRemaining(Authentication auth) {
        UserDTO user = client.getUserByUsername(auth.getName());
        return leaveService.getRemainingLeaves(user.getEmployeeId());
    }

    @PostMapping("/approve/{id}")
    public LeaveRequest approve(@PathVariable int id, @RequestParam boolean approve) {
        return leaveService.approveLeave(id, approve);
        
        
    }
    
    @GetMapping("/pending")
    public List<LeaveRequest> getPendingLeaves() {
        return leaveService.getPendingLeaves();
    }

}
