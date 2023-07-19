package com.example.demospringboot.dto;

import java.util.Date;
import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String surname;
    private String givenName;
    private String password;
    private String email;
    private Date dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private Integer idStaff;
    private Integer idCustomer;

}
