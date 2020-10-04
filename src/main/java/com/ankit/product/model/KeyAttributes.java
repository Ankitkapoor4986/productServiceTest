package com.ankit.product.model;

import lombok.Data;

import java.util.function.Predicate;

@Data
public class KeyAttributes {

    private String key;
    private String value;
    private Predicate<KeyAttributes> validationRule;
}
