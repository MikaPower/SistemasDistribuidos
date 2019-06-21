package edu.ufp.inf.sd.rmi.quiz.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QuizImpl extends UnicastRemoteObject implements QuizRI {


    public QuizImpl() throws RemoteException {
        super();
    }

    @Override
    public String methodName() throws RemoteException {
        return "someone called me!";
    }
}