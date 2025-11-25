package com.example.demo.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
//import java.util.stream.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.LeaveRequest;
import com.example.demo.Repository.LeaveRepository;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepo;

    public String applyLeave(LeaveRequest req, int employeeId) {

        int days = (int) ChronoUnit.DAYS.between(req.getStartDate(), req.getEndDate()) + 1;

        req.setEmployeeId(employeeId);
        req.setTotalDays(days);
        req.setStatus("PENDING");

         leaveRepo.save(req);
         return "success";
}

	public List<LeaveRequest> getLeaveHistory(int employeeId) {
		// TODO Auto-generated method stub
		 return leaveRepo.findByEmployeeIdOrderByStartDateDesc(employeeId);

	}
	public List<LeaveRequest> getPendingLeaves() {
	    return leaveRepo.findByStatus("PENDING");
	}


	public int getRemainingLeaves(int employeeId) {
		int totalleaves = 20;
		int used = leaveRepo.findByEmployeeId(employeeId)
				            .stream().filter( lr->lr.getStatus().equals("APPROVED"))
				.mapToInt(LeaveRequest::getTotalDays)
				.sum();
		return totalleaves-used;
	}

	public LeaveRequest approveLeave(int leaveId, boolean approve) {
		Optional<LeaveRequest> leaveopt = leaveRepo.findById(leaveId);
		if(leaveopt == null) {
			throw new RuntimeException("Leave request not found");
		}
		LeaveRequest leave = leaveopt.get();
        leave.setStatus(approve ? "APPROVED" : "REJECTED");

        return leaveRepo.save(leave);

	}

}
