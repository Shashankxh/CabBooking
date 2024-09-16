package com.cabbooking.cabbook.exeption;

public class driverNotFound extends RuntimeException{
    public driverNotFound(String message){
        super(message);
    }
}
