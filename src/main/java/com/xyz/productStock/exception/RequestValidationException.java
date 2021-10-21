package com.xyz.productStock.exception;

import java.util.List;

/**
 * The class is for throwing exceptions raiesed from validation rule exceptions
 * @version 1.0
 * @author Hossein Hajjari
 */
public class RequestValidationException extends RuntimeException {

    public RequestValidationException(List<String> errors, String message) {
        super(errors.toString());
    }
}
