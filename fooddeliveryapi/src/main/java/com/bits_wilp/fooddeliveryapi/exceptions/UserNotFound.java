package com.bits_wilp.fooddeliveryapi.exceptions;

public class UserNotFound extends RuntimeException {
    String resourceName;
    String fieldName;
    String fieldValue;

    public UserNotFound(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
//        String.format("%s not found with %s : %l", resourceName, fieldName, fieldValue);
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
