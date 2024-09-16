package com.cabbooking.cabbook.exeption;

public class CabNotFound extends RuntimeException{
    public CabNotFound(String s){
        super(s);
    }
}
