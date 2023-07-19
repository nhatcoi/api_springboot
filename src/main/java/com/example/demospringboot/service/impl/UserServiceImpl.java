package com.example.demospringboot.service.impl;

import com.example.demospringboot.dto.UserRequest;
import com.example.demospringboot.entity.User;
import com.example.demospringboot.exception.ResourceNotFoundException;
import com.example.demospringboot.repository.UserRepository;
import com.example.demospringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // READ API
    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            System.out.println("Danh sách trống!");
        }
        return users;
    }

    // CREATE API
    @Override
    public List<User> saveUser(List<UserRequest> userRequests) {

        List<User> users = new ArrayList<>();
        for (UserRequest convertUserDTO : userRequests) {
            User user = new User();
            // Chuyển đổi các thuộc tính từ UserDTO sang User
            BeanUtils.copyProperties(convertUserDTO, user);
            users.add(user);
        }
        return userRepository.saveAll(users);
    }
    @Override
    public boolean existsByData(String username, String email, String phoneNumber) {
        List<User> users = userRepository.findAll();
        boolean foundDuplicate = false;
        for (User checkData : users) {
            if (checkData.getUsername().equals(username) ||
                    checkData.getEmail().equals(email) ||
                    checkData.getPhoneNumber().equals(phoneNumber)) {
                foundDuplicate = true;
                break;
            }
        }
        return foundDuplicate;
    }


    // DELETE API
    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }


    // UPDATE API
    @Override
    public User updateUser(Long id, User user) {
        Optional<User> checkNull = userRepository.findById(id);

        if (checkNull.isPresent()) {
            User existingUser = checkNull.get();

            existingUser.setPassword(user.getPassword());
            existingUser.setAddress(user.getAddress());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhoneNumber(user.getPhoneNumber());

            return userRepository.save(existingUser);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }
}
