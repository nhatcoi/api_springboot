package com.example.demospringboot.dto;

import lombok.Data;

import java.util.Date;
@Data
public class UserResponse {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
}
