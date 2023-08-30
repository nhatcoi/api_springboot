package com.example.demospringboot.service.impl;

import com.example.demospringboot.dto.StaffRequest;
import com.example.demospringboot.entity.Staff;
import com.example.demospringboot.entity.User;
import com.example.demospringboot.exception.ResourceNotFoundException;
import com.example.demospringboot.repository.StaffRepository;
import com.example.demospringboot.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final StaffRepository userRepository;



    // CREATE API - Service saveStaff to db
    @Override
    public List<Staff> saveStaff(List<StaffRequest> staffRequests) {

        // Convert staff data from StaffRequest to Entity
        List<Staff> staffs = new ArrayList<>();
        for (StaffRequest convertStaffDTO : staffRequests) {
            Staff staff = new Staff();
            staff.setChucvu(convertStaffDTO.getChucvu());
            staff.setId(convertStaffDTO.getId());

            staffs.add(staff);
        }
        return staffRepository.saveAll(staffs);
    }


    // READ API - Service get staff date from db
    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff updateStaff(Long id_staff, Staff staff) {
        Optional<Staff> staffOptional = staffRepository.findById(id_staff);

        if (staffOptional.isPresent()) {
            Staff staffUpdate = staffOptional.get();

            staffUpdate.setChucvu(staff.getChucvu());

            return staffRepository.save(staffUpdate);
        } else {
            throw new ResourceNotFoundException("Staff not found ! " + id_staff);
        }
    }

    @Override
    public void deleteStaffByIdStaff(Long id_staff) {
        staffRepository.deleteById(id_staff);
    }
}
