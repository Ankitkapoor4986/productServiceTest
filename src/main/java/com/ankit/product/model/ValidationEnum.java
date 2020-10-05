package com.ankit.product.model;

import java.util.function.BiPredicate;

public enum ValidationEnum {
    Equal((constraintValue, keyAttributes) -> constraintValue.equals(keyAttributes.getValidationValue())),
    GreaterThan((constraintValue, keyAttributes) -> keyAttributes.getValidationValue() > constraintValue),
    LessThan((constraintValue,keyAttribute)->keyAttribute.getValidationValue()<constraintValue);

    BiPredicate<Integer,KeyAttributes> keyAttributesBiPredicateValidator;

    ValidationEnum(BiPredicate<Integer,KeyAttributes> biPredicateValidator){
        this.keyAttributesBiPredicateValidator = biPredicateValidator;
    }
}
