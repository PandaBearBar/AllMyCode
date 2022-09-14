package com.test.springTest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionMSG {
    IdNotExist("This Student Not Exist In The System");
    private String msg;

}
