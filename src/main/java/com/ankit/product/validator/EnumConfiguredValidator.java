package com.ankit.product.validator;


import com.ankit.product.model.KeyAttributes;

public class EnumConfiguredValidator implements Validator {

    @Override
    public boolean validate(KeyAttributes keyAttribute) {

        keyAttribute.getValidationTypes().getValidatorComparator().getKeyAttributesBiPredicateValidator()
                .test(keyAttribute.getConstraintVal(), Integer.valueOf(keyAttribute.getValue()));

        return false;
    }
}
