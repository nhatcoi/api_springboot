package com.example.demospringboot.service.impl;

import com.example.demospringboot.dto.CustomerRequest;
import com.example.demospringboot.entity.Customer;
import com.example.demospringboot.repository.CustomerRepository;
import com.example.demospringboot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getAllCustomer() {
        return null;
    }

    @Override
    public Customer updateCustomer(Long id_customer, Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id_customer) {

    }
}
