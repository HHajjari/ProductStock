package com.xyz.productStock.exception;

/**
 * The class is for throwing exceptions raiesed when a none existing entity is requested from database
 * @version 1.0
 * @author Hossein Hajjari
 */
public class EntityNotFoundException extends RuntimeException {

    private EntityType entityType;

    public EntityNotFoundException(EntityType entityType, String message) {
        super(message);

        this.entityType = entityType;
    }
}
