package com.bar.demo2.exception;

public class LibraryCustomException extends Exception{
    public LibraryCustomException(ExceptionMSG message) {
        super(message.getMsg());
    }
}
