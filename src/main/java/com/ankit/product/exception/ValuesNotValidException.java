package com.ankit.product.exception;

import java.util.Collection;

public class ValuesNotValidException extends Exception {
    public ValuesNotValidException(Collection<String> keys) {
        super("Follwing keys are not valid" + keys);
    }
}
