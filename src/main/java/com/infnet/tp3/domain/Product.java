package com.infnet.tp3.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private String id;
    private String productId;
    private int quantity;
    private double price;
    private String status;
}
