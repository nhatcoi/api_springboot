package com.example.demospringboot.service;

import com.example.demospringboot.entity.Customer;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    Customer getAllCustomer();
    Customer updateCustomer(Long id_customer, Customer customer);
    void deleteCustomer(Long id_customer);
}
