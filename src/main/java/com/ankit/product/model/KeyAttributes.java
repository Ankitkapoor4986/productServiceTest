package com.ankit.product.model;

import com.ankit.product.validator.ValidationTypes;
import lombok.Data;

@Data
public class KeyAttributes {

    private String key;
    private String value;
    private int constraintVal;
    private ValidationTypes validationTypes;
}
