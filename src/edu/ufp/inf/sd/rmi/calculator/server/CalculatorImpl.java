package edu.ufp.inf.sd.rmi.calculator.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CalculatorImpl extends UnicastRemoteObject implements CalculatorRI {


    public CalculatorImpl() throws RemoteException {
        super();
    }


    @Override
    public int soma(ArrayList<Integer> inteiros) {
        int resultado=0;
        for (Integer numero: inteiros) {
            resultado+=resultado+numero;
        }
        return resultado;
    }

    @Override
    public int multiplicar(int a, int b) {
        return a*b;
    }

    @Override
    public int subtracao(int a, int b) {
        return a-b;
    }

    @Override
    public int divisao(int a, int b) throws DivisionByZeroException {
        if(a==0 || b==0){
            throw new DivisionByZeroException("Erro");
        }
        return a/b;
    }

    @Override
    public String methodName() throws RemoteException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO,"someone called me!");
        return "someone called me!";
    }
}