package com.example.leave_system_BE.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.leave_system_BE.Model.LeaveRequest;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    
    @Query("SELECT lr FROM LeaveRequest lr JOIN FETCH lr.user JOIN FETCH lr.leaveType")
    List<LeaveRequest> findAllWithUserAndLeaveType();
}
