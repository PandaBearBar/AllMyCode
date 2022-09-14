package com.project.project2.excaptions;

public class CouponSystemException extends Exception{
    public CouponSystemException(ExceptionMsg message) {
        super(message.getMsg());
    }
}
