package com.bar.demo2.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum ExceptionMSG {
    NotExist("Id not Exist"),
    StartBiggerEnd("Start Year is Bigger then The End Year u cant do that !"),
    AlreadyExist("This Author Exist Already")
    ;

    private String msg;

    public String getMsg() {
        return msg;
    }
}
