package com.example.leave_system_BE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.leave_system_BE.Model.LeaveRequest;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
}
