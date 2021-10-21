package com.xyz.productStock.exception;

/**
 * The class is for throwing exceptions raiesed for duplicate inserting in a database table
 * @version 1.0
 * @author Hossein Hajjari
 */
public class DuplicateEntityException extends RuntimeException {

    private EntityType entityType;

    public DuplicateEntityException(EntityType entityType, String message) {
        super(message);

        this.entityType = entityType;
    }
}
