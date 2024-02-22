package com.example.demospringboot.controller;

import com.example.demospringboot.dto.UserRequest;
import com.example.demospringboot.dto.UserResponse;
import com.example.demospringboot.entity.User;
import com.example.demospringboot.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;


    // GET ALL USERS FROM DATABASE - READ REST API
    @GetMapping("/Users")
    public List<User> getAllUser() {
        return userServiceImpl.getAllUser();
    }


    // SAVE ALL USERS AND CHECK DUPLICATE FROM CLIENT TO DB  - CREATE REST API
    @PostMapping("/insert")
    public ResponseEntity<?> saveUser(@RequestBody List<UserRequest> userRequests) {
        if (ObjectUtils.isEmpty(userRequests)) {
            System.out.println("List user from postman is empty");
        }

        List<UserResponse> userResponses = new ArrayList<>();
        // validate check data from client
        for (UserRequest check : userRequests) {
            if (userServiceImpl.existsByData(check.getUsername(), check.getEmail(), check.getPhoneNumber())) {

                // convert to UserResponse - Tra ve UserResponse du lieu trung lap
                for (UserRequest convert : userRequests) {
                    UserResponse userResponse = new UserResponse();
                    userResponse.setUsername(convert.getUsername());
                    userResponse.setPassword(convert.getPassword());
                    userResponse.setEmail(convert.getEmail());
                    userResponse.setPhoneNumber(convert.getPhoneNumber());

                    userResponses.add(userResponse);
                    System.out.println("+1 user is duplicated");
                }
            } else  {
                System.out.println("+1 user added db");
                List<UserRequest> saveData = new ArrayList<>();
                saveData.add(check);
                userServiceImpl.saveUser(saveData);
            }
        }
        //convert to entity for save to DB
        return new ResponseEntity<>("OKE", HttpStatus.CREATED);
    }


    // DELETE USER BY ID FROM DATABASE - DELETE REST API
    @DeleteMapping("{id}") //annotation
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        Optional<User> userOptional = userServiceImpl.findUserById(id);
        if (userOptional.isPresent()) {
            userServiceImpl.deleteUserById(id);
            return new ResponseEntity<>("Da xoa : " + id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Khong tim thay id : " + id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userServiceImpl.findUserById(id), HttpStatus.OK);
    }



    // UPDATE USER BY ID FROM DATABASE - UPDATE REST API -- Hello
    @PutMapping ("{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        User userUpdate = userServiceImpl.updateUser(id, user);
        return new ResponseEntity<>(userUpdate, HttpStatus.OK);
    }
}
