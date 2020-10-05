package com.ankit.product.model;

import lombok.Data;

import java.util.List;

@Data
public class Product {

    private long id;
    private String name;
    private List<Reviews> reviews;
    private List<KeyAttributes> keyAttributes;
    private double price;
    private String description;


}
