package edu.ufp.inf.sd.rmi.calculator.server;

import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface CalculatorRI extends Remote {
    public String methodName() throws RemoteException;
    public int soma(ArrayList <Integer> numeros)throws RemoteException;
    public int multiplicar(int a,int b) throws RemoteException;
    public int divisao(int a,int b) throws RemoteException;
    public int subtracao(int a,int b)throws RemoteException;


}