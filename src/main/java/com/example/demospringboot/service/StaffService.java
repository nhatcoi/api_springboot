package com.example.demospringboot.service;

import com.example.demospringboot.dto.StaffRequest;
import com.example.demospringboot.entity.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    List<Staff> saveStaff(List<StaffRequest> staffRequests); // C

    List<Staff> getAllStaff(); // R

    Staff updateStaff (Long id_staff, Staff staff);
    void deleteStaffByIdStaff(Long id_staff);
}
