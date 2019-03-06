package edu.ufp.inf.sd.rmi.calculator.server;

import java.rmi.RemoteException;

public class DivisionByZeroException extends RemoteException {
    public DivisionByZeroException(final String message){
        super(message);
    }
}
