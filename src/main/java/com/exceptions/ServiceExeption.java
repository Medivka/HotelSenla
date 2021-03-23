package com.exceptions;

public class ServiceExeption extends RuntimeException{
    public ServiceExeption(String message){
        super(message);
    }
    public ServiceExeption(String message,Throwable cause){
        super(message,cause);
    }
    public ServiceExeption(Throwable cause){
        super(cause);
    }
}