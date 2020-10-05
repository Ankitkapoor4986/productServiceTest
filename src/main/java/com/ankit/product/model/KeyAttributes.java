package com.ankit.product.model;

import lombok.Data;

@Data
public class KeyAttributes {

    private String key;
    private String value;
    private Integer validationValue;
    private ValidationEnum validation;
}
