package com.bits_wilp.fooddeliveryapi.exceptions;

public class ResourceDuplicateException extends RuntimeException{
    public ResourceDuplicateException(String message) {
        super(message);
    }
}
