package com.test.springTest.exception;

public class SchoolSystemException extends Exception{
    public SchoolSystemException(ExceptionMSG message) {
        super(message.getMsg());
    }
}
