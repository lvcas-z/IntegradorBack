package com.ZL.Integrador.exception;

public class NullException extends Exception{
    public NullException(){
        super("El campo esta vacio");
    }
    public NullException(String message){
        super(message);
    }
}
