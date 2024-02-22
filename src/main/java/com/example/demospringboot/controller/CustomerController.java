package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Customer;
import com.example.demospringboot.repository.CustomerRepository;
import com.example.demospringboot.service.CustomerService;
import com.example.demospringboot.service.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v3")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("/read")
    public Customer getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id_customer, @RequestBody Customer customer) {
        customerService.updateCustomer(id_customer, customer);
        return new ResponseEntity<>("done",HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id_customer) {
        customerService.deleteCustomer(id_customer);
        return new ResponseEntity<>("done", HttpStatus.OK);
    }
}
