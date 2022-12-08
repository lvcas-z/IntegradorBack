package com.ZL.Integrador.exception;

public class ExistException extends Exception{
    public ExistException(){
        super("El objeto ya existe");
    }
    public ExistException(String message){
        super(message);
    }
}
