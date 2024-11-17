package com.bits_wilp.fooddeliveryapi.exceptions;

public class PasswordMismatchException extends RuntimeException{
    public PasswordMismatchException(String message){
        super(message);
    }

}
