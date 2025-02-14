package com.example.leave_system_BE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leave_system_BE.Model.LeaveBalance;
import com.example.leave_system_BE.Service.LeaveBalanceService;

@RestController
@RequestMapping("/api/leave-balances")
public class LeaveBalanceController {

    @Autowired
    private LeaveBalanceService leaveBalanceService;

    @GetMapping
    public ResponseEntity<List<LeaveBalance>> getLeaveBalances() {
        List<LeaveBalance> leaveBalances = leaveBalanceService.getLeaveBalances();
        return ResponseEntity.ok(leaveBalances);
    }
}
