package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.LeaveRequest;

public interface LeaveRepository extends JpaRepository<LeaveRequest,Integer> {
	List<LeaveRequest> findByEmployeeId(int employeeId);
    List<LeaveRequest> findByEmployeeIdOrderByStartDateDesc(int employeeId);
	List<LeaveRequest> findByStatus(String string);
}
