package com.example.demospringboot.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.GeneratedValue;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staff")

public class Staff {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id_staff;

    @Column(name = "chucvu")
    private String chucvu;

    @Column(name = "id")
    private Long Id;


}
