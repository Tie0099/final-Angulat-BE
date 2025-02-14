package com.example.leave_system_BE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.leave_system_BE.Model.LeaveRequest;
import com.example.leave_system_BE.Service.LeaveRequestService;

@RestController
@RequestMapping("/api/leave-requests")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    // POST /api/leave-requests - สร้างคำขอลา
    @PostMapping
    public ResponseEntity<LeaveRequest> createLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        LeaveRequest createdLeaveRequest = leaveRequestService.createLeaveRequest(leaveRequest);
        return ResponseEntity.ok(createdLeaveRequest);
    }

    // GET /api/leave-requests - ดูประวัติการลา
    @GetMapping
    public ResponseEntity<List<LeaveRequest>> getAllLeaveRequests() {
        List<LeaveRequest> leaveRequests = leaveRequestService.getAllLeaveRequests();
        return ResponseEntity.ok(leaveRequests);
    }

    // PUT /api/leave-requests/{id} - อัพเดทสถานะการลา
    @PutMapping("/{id}")
    public ResponseEntity<LeaveRequest> updateLeaveRequestStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        LeaveRequest updatedLeaveRequest = leaveRequestService.updateLeaveRequestStatus(id, status);
        if (updatedLeaveRequest != null) {
            return ResponseEntity.ok(updatedLeaveRequest);
        }
        return ResponseEntity.notFound().build();
    }
}
