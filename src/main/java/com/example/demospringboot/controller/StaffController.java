package com.example.demospringboot.controller;


import com.example.demospringboot.dto.StaffRequest;
import com.example.demospringboot.entity.Staff;
import com.example.demospringboot.service.impl.StaffServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2")
public class StaffController {
    @Autowired
    private StaffServiceImpl staffService;


    // CREAT API Staff - Post data to db - C
    @PostMapping("/create")
    public ResponseEntity<?> saveStaff(@RequestBody List<StaffRequest> staffRequests) {
        // Check data empty
        if (ObjectUtils.isEmpty(staffRequests)) {
            return new ResponseEntity<>("Empty", HttpStatus.NOT_FOUND);
        } else {
            for (StaffRequest staffRequest : staffRequests) {
                List<StaffRequest> saveStaff = new ArrayList<>();
                saveStaff.add(staffRequest);

                staffService.saveStaff(saveStaff); // API create
            }
            return new ResponseEntity<>("Complete! ", HttpStatus.CREATED);
        }
    }

    // READ API Staff - Get data from db - R
    @GetMapping("/read")
    public List<Staff> getAllStaff() {
        List<Staff> staffs = staffService.getAllStaff();
        if (staffs.isEmpty()) {
            return null;
        } else {
            return staffService.getAllStaff();
        }
    }


    // TODO UPDATE API Staff by ID - get data and PUT them again - U
    @PutMapping("{id_staff}")
    public ResponseEntity<?> updateStaff(@PathVariable Long id_staff, @RequestBody Staff staff) {
        Staff staffUpdate = staffService.updateStaff(id_staff, staff);
        return new ResponseEntity<>(staffUpdate, HttpStatus.OK);
    }

    // TODO DELETE API Staff by ID - DELETE data from db - D
    @DeleteMapping("{id_staff}")
    public ResponseEntity<?> deleteStaffById(@PathVariable Long id_staff) {
        staffService.deleteStaffByIdStaff(id_staff);
        return new ResponseEntity<>("Complete delete id", HttpStatus.OK);
    }


}
