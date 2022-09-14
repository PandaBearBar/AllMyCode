package com.bar.demo6.Exception;

public class CatsCustomException extends Exception{
    public CatsCustomException(CatExceptionMsg message) {
        super(message.getMsg());
    }
}
