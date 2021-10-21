package com.xyz.productStock.exception;

/**
 * The class is for throwing exceptions raiesed from business rule exceptions
 * @version 1.0
 * @author Hossein Hajjari
 */
public class BusinessException extends RuntimeException {

    private BusinessRule businessRuleException;

    public BusinessException(BusinessRule businessRuleException, String message) {
        super(message);

        this.businessRuleException = businessRuleException;
    }
}
