package edu.ufp.inf.sd.rmi.observer.server;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface SubjectRI extends Remote {



    public void attach(edu.ufp.inf.sd.rmi.observer.client.ObserverRI observerRi) throws RemoteException;
    public void dettach(edu.ufp.inf.sd.rmi.observer.client.ObserverRI observerRi) throws RemoteException;
    public State getState () throws  RemoteException;
    public void setState (State state) throws RemoteException;

}