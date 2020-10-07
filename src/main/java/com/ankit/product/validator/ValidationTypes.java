package com.ankit.product.validator;

import com.ankit.product.model.KeyAttributes;

import java.util.function.Function;

/**
 * Note these values can be configured in DB
 * but we have to make a check that only these
 * values are being put
 */

public enum ValidationTypes {

    VAl_LEN_EQUALITY(ValidationComparator.Equal, (keyAttribute) -> keyAttribute.getKey().length()),
    VAL_LEN_LESS_THAN(ValidationComparator.LessThan, (keyAttribute) -> keyAttribute.getValue().length()),
    VAL_GREATER_THAN(ValidationComparator.GreaterThan, (keyAttributes) -> keyAttributes.getValue().length());

    private final ValidationComparator validatorComparator;
    private final Function<KeyAttributes, Integer> convertorFunction;

    ValidationTypes(ValidationComparator validationComparator, Function<KeyAttributes, Integer>
            convertorFunction) {
        this.validatorComparator = validationComparator;
        this.convertorFunction = convertorFunction;
    }

    public boolean executeValidation(KeyAttributes keyAttribute) {

        return this.validatorComparator.getKeyAttributesBiPredicateValidator()
                .test(keyAttribute.getConstraintVal(),this.convertorFunction.apply(keyAttribute));
    }

    public ValidationComparator getValidatorComparator() {
        return validatorComparator;
    }
}
