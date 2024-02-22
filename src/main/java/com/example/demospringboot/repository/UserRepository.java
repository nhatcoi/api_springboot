package com.example.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demospringboot.entity.User;
//Interface này chứa các phương thức tiện ích đã được triển khai sẵn để thực hiện các hoạt động CRUD (Create, Read, Update, Delete)
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // all CRUD database methods.
}

