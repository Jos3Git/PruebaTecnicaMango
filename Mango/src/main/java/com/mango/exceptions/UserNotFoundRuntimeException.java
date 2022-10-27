package com.mango.exceptions;

public class UserNotFoundRuntimeException extends RuntimeException{
    public UserNotFoundRuntimeException(String s) {
        super(s);
    }
}
