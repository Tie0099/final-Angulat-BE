package com.example.leave_system_BE.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leave_system_BE.Model.LeaveBalance;
import com.example.leave_system_BE.Repository.LeaveBalanceRepository;

@Service
public class LeaveBalanceService {

    @Autowired
    private LeaveBalanceRepository leaveBalanceRepository;

    // ดูจำนวนวันลาคงเหลือ
    public List<LeaveBalance> getLeaveBalances() {
        return leaveBalanceRepository.findAll();
    }
}
