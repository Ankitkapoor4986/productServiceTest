package com.ankit.product.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Product {

    private long id;
    private String name;
    private List<Reviews> reviews;
    private List<KeyAttributes> keyAttributes;
    private double price;
    private String description;

   public Product(String name,String description){
       this.name = name;
       this.description = description;
   }




}
