package com.upgrad.ECOM.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "ECOM_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    private int amount;

    @ManyToOne
    private Order order;
}
