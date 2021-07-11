package com.upgrad.ECOM.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "ECOM_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int amount;

    @Column(nullable = false)
    private String date;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Product> products;

}
