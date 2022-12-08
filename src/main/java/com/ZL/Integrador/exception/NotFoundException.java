package com.ZL.Integrador.exception;

public class NotFoundException extends Exception{
    public NotFoundException(){
        super("El recurso no fue encontrado");
    }
    public NotFoundException(String message){
        super(message);
    }
}
