package com.example.demospringboot.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.GeneratedValue;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")

public class Customer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id_customer;

    @Column(name = "work")
    private String work;
    @Column(name = "describe")
    private String describe;
    @Column(name = "id")
    private Long Id;
}
