package com.example.demo7.excp;

public class LibraryCustomException extends Exception {
    public LibraryCustomException(ErrMsg message) {
        super(message.getMsg());
    }
}
