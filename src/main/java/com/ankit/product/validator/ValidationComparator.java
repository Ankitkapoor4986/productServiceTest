package com.ankit.product.validator;

import java.util.function.BiPredicate;

enum ValidationComparator {
    Equal(Integer::equals),
    GreaterThan((constraintValue, val) -> val > constraintValue),
    LessThan((constraintValue, val) -> val < constraintValue);

    BiPredicate<Integer,Integer> keyAttributesBiPredicateValidator;

    ValidationComparator(BiPredicate<Integer,Integer> biPredicateValidator){
        this.keyAttributesBiPredicateValidator = biPredicateValidator;
    }
}
