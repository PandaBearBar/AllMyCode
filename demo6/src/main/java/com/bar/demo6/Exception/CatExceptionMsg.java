package com.bar.demo6.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CatExceptionMsg {
    CatExist("This Cat Already Exist !"),
    CatDoNotExist("This Cat Not Exist !"),
    CatUpdate("Cat Cant be Update = > not found !"),
    CatDelete("Cat Cant be deleted => not found !"),
    CatNegativeWeight("Cat Cant be with Weight less then ZERO !"),
    ;


    private String msg;
}
