package com.upgrad.ECOM.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "ECOM_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String role;

    @OneToMany
    private List<Order> orders;
}
