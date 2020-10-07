package com.ankit.product.validator;


import com.ankit.product.model.KeyAttributes;
import org.springframework.stereotype.Component;

@Component
public class EnumConfiguredValidator implements Validator {

    @Override
    public boolean validate(KeyAttributes keyAttribute) {

        return keyAttribute.getValidationTypes().executeValidation(keyAttribute);


    }
}
