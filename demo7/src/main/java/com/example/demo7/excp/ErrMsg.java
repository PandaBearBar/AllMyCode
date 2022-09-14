package com.example.demo7.excp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrMsg {
    IdExist("Cant Add Cuse : Author Already Exist !"), CantBeDeleted("Cant Delete Cuse : Author Does Not Exist !");
    private String msg;
}
