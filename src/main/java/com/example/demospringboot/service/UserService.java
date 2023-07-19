package com.example.demospringboot.service;

import com.example.demospringboot.dto.UserRequest;
import com.example.demospringboot.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();

    List<User> saveUser(List<UserRequest> userRequests);

    boolean existsByData(String username, String email, String phoneNumber);

    void deleteUserById(Long id);

    Optional<User> findUserById (Long id);

    User updateUser (Long id, User user);

}
