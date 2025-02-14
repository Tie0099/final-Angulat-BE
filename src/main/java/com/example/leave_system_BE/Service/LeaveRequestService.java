package com.example.leave_system_BE.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leave_system_BE.Model.LeaveRequest;
import com.example.leave_system_BE.Repository.LeaveRequestRepository;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    // สร้างคำขอลา
    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    // ดูประวัติการลา
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    // อัพเดทสถานะการลา
    public LeaveRequest updateLeaveRequestStatus(Long id, String status) {
        Optional<LeaveRequest> leaveRequestOpt = leaveRequestRepository.findById(id);
        if (leaveRequestOpt.isPresent()) {
            LeaveRequest leaveRequest = leaveRequestOpt.get();
            leaveRequest.setStatus(status);
            return leaveRequestRepository.save(leaveRequest);
        }
        return null; 
    }
}
