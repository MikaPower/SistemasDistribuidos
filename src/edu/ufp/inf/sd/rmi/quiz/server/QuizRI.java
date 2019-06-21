package edu.ufp.inf.sd.rmi.quiz.server;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface QuizRI extends Remote {
    public String methodName() throws RemoteException;
}