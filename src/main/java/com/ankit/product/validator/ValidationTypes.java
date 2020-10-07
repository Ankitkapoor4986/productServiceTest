package com.ankit.product.validator;

/**
 * Note these values can be configured in DB
 * but we have to make a check that only these
 * values are being put
 */

public enum ValidationTypes {

    KEY_LEN_EQUALITY(ValidationComparator.Equal),
    KEY_LEN_LESS_THAN(ValidationComparator.LessThan),
    KEY_GREATER_THAN(ValidationComparator.GreaterThan);

    private final ValidationComparator validatorComparator;

    ValidationTypes(ValidationComparator validationComparator) {
        this.validatorComparator = validationComparator;
    }

    public ValidationComparator getValidatorComparator() {
        return validatorComparator;
    }
}
