package com.example.demo.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leave_request")
public class LeaveRequest {

    @Id
    @GeneratedValue
    private Long id;

    private int employeeId;       
    private LocalDate startDate;
    private LocalDate endDate;

    private String leaveType;  
    private String reason;

    private String status = "PENDING";   

    private int totalDays;     

   
    
    public Long getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId2) {
        this.employeeId = employeeId2;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLeaveType() {
        return leaveType;
    }
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalDays() {
        return totalDays;
    }
    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }
}
